
package com.savvis.gsd.composer;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("composer")
public class ComposerUI extends UI {

	private final ComboBox templateSearchBox = ComposerComponentFactory.createTemplateSearchBox();
	private final Tree templateTree = ComposerComponentFactory.createTemplateTree();
	private final Button applyTemplateButton = ComposerComponentFactory.createButton("Apply", "applyTemplateButton");
	private final Button previewButton = ComposerComponentFactory.createButton("Preview", "previewEmailButton");
	private final Button sendButton = ComposerComponentFactory.createButton("Send", "sendEmailButton");
	private final RichTextArea emailEditor = ComposerComponentFactory.createEmailEditor();
	private final Label fromDisplay = ComposerComponentFactory.createLabel("fromDisplay");
	private final TextField fromEditor = ComposerComponentFactory.createTextField("fromEditor");
	private final Label replyToDisplay = ComposerComponentFactory.createLabel("replyToDisplay");
	private final TextField replyToEditor = ComposerComponentFactory.createTextField("replyToEditor");
	private final Label subjectDisplay = ComposerComponentFactory.createLabel("subjectDisplay");
	private final TextField subjectEditor = ComposerComponentFactory.createTextField("subjectEditor");
	private final Label ccDisplay = ComposerComponentFactory.createLabel("ccDisplay");
	private final TextField ccEditor = ComposerComponentFactory.createTextField("ccEditor");
	private final Label bccDisplay = ComposerComponentFactory.createLabel("bccDisplay");
	private final TextField bccEditor = ComposerComponentFactory.createTextField("ccEditor");
	private HorizontalLayout fromSection;
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ComposerUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final HorizontalLayout contentBody = new HorizontalLayout();
		final VerticalLayout leftColumnContent = createLeftColumnLayout();
		final VerticalLayout centerColumnContent = createCenterColumnLayout();
		
		contentBody.setMargin(true);
		setContent(contentBody);
		
		contentBody.addComponent(leftColumnContent);
		contentBody.addComponent(centerColumnContent);
		
		registerEvents();
		loadTemplates();
	}

	private void registerEvents() {
		applyTemplateButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				String selectedTemplate = (String) templateTree.getValue();
				if (selectedTemplate != null && selectedTemplate != "") {
					emailEditor.setValue(selectedTemplate);
				}
			}
		});
		
		fromSection.addLayoutClickListener(new LayoutClickListener(){
			@Override
			public void layoutClick(LayoutClickEvent event) {
				enableEditing(fromDisplay, fromEditor);
			}
		});
		
		fromEditor.addBlurListener(new BlurListener() {
			@Override
			public void blur(BlurEvent event) {
				disableEditing(fromDisplay, fromEditor);
			}
		});
		
	}

	protected void disableEditing(Label label, TextField field) {
		label.setVisible(true);
		label.setValue(field.getValue());
		field.setVisible(false);
	}

	protected void enableEditing(Label label, TextField field) {
		label.setVisible(false);
		field.setVisible(true);
		field.setValue(label.getValue());
	}

	private VerticalLayout createLeftColumnLayout() {
		final VerticalLayout leftColumn = new VerticalLayout();
		final HorizontalLayout topLeft = new HorizontalLayout();
		topLeft.addComponent(templateSearchBox);
		applyTemplateButton.setId("applyTemplateButton");
		topLeft.addComponent(applyTemplateButton);
		leftColumn.addComponent(topLeft);
		leftColumn.addComponent(templateTree);
		
		return leftColumn;
	}
	
	private VerticalLayout createCenterColumnLayout() {
		final VerticalLayout centerColumn = new VerticalLayout();
		final HorizontalLayout emailButtons = new HorizontalLayout();
		emailButtons.setId("emailButtonsArea");
		emailButtons.addComponent(previewButton);
		emailButtons.addComponent(sendButton);
		
		centerColumn.addComponent(emailButtons);
		centerColumn.addComponent(createEmailHeader());
		centerColumn.addComponent(emailEditor);
		return centerColumn;
	}

	private Component createEmailHeader() {
		VerticalLayout emailHeader = new VerticalLayout();
		emailHeader.setId("emailHeader");
		fromSection = createHeaderSection("fromSection", "From: ", fromDisplay, fromEditor);
		emailHeader.addComponent(fromSection);
		emailHeader.addComponent(createHeaderSection("replyToSection", "Reply: ", replyToDisplay, replyToEditor));
		emailHeader.addComponent(createHeaderSection("subjectSection", "Subject: ", subjectDisplay, subjectEditor));
		emailHeader.addComponent(createHeaderSection("ccSection", "CC: ", ccDisplay, ccEditor));
		emailHeader.addComponent(createHeaderSection("bccSection", "BCC: ", bccDisplay, bccEditor));
		return emailHeader;
	}

	public HorizontalLayout createHeaderSection(String uniqueIdentified, String sectionLabel, Component displayComponent, Component editorComponent) {
		final HorizontalLayout section = new HorizontalLayout();
		section.setId(uniqueIdentified);
		section.addComponent(new Label(sectionLabel));
		section.addComponent(displayComponent);
		section.addComponent(editorComponent);
		return section;
	}

	private void loadTemplates() {
		final Object[][] templates = new Object[][]{
		        new Object[]{"Mercury"}, 
		        new Object[]{"Venus"},
		        new Object[]{"Earth", "The Moon"},    
		        new Object[]{"Mars", "Phobos", "Deimos"},
		        new Object[]{"Jupiter", "Io", "Europa", "Ganymedes",
		                                "Callisto"},
		        new Object[]{"Saturn",  "Titan", "Tethys", "Dione",
		                                "Rhea", "Iapetus"},
		        new Object[]{"Uranus",  "Miranda", "Ariel", "Umbriel",
		                                "Titania", "Oberon"},
		        new Object[]{"Neptune", "Triton", "Proteus", "Nereid",
		                                "Larissa"}};
		loadTree(templates);
	}
	
	private void loadTree(Object[][] templates) {
		for (int i=0; i<templates.length; i++) {
		    String planet = (String) (templates[i][0]);
		    templateTree.addItem(planet);
		    
		    if (templates[i].length == 1) {
		        // The planet has no moons so make it a leaf.
		        templateTree.setChildrenAllowed(planet, false);
		    } else {
		        // Add children (moons) under the planets.
		        for (int j=1; j<templates[i].length; j++) {
		            String moon = (String) templates[i][j];
		            
		            // Add the item as a regular item.
		            templateTree.addItem(moon);
		            
		            // Set it to be a child.
		            templateTree.setParent(moon, planet);
		            
		            // Make the moons look like leaves.
		            templateTree.setChildrenAllowed(moon, false);
		        }

		        // Expand the subtree.
		        templateTree.expandItemsRecursively(planet);
		    }
		}
	}


}