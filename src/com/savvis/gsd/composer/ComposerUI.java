package com.savvis.gsd.composer;

import javax.servlet.annotation.WebServlet;

import com.savvis.gsd.composer.ui.email.EmailComposite;
import com.savvis.gsd.composer.ui.templates.TemplateComposite;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("composer")
public class ComposerUI extends UI {

	private TemplateComposite templateComposite = new TemplateComposite();
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ComposerUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final HorizontalLayout contentBody = new HorizontalLayout();
		
		contentBody.setMargin(true);
		setContent(contentBody);


		contentBody.addComponent(templateComposite);
		contentBody.addComponent(new EmailComposite());
		
		loadTemplates();
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
		templateComposite.loadTemplates(templates);
	}


}