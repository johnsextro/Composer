package com.savvis.gsd.composer.ui.templates;

import com.savvis.gsd.composer.ui.templates.components.TemplateSearchBox;
import com.savvis.gsd.composer.ui.templates.components.TemplateTree;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TemplateComposite extends CustomComponent {
	
	private TemplateSearchBox templateSearchBox = new TemplateSearchBox();
	private TemplateTree templateTree = new TemplateTree();


	public TemplateComposite() {
		final VerticalLayout leftColumn = new VerticalLayout();
		final HorizontalLayout topLeft = new HorizontalLayout();
		final Button applyTemplateButton = new Button("Apply");
		
		templateTree.setImmediate(true);
		templateTree.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				System.out.println(templateTree.getValue());
			}
			
		});
		
		topLeft.addComponent(templateSearchBox);
		topLeft.addComponent(applyTemplateButton);
		
		leftColumn.addComponent(topLeft);
		leftColumn.addComponent(templateTree);
		setCompositionRoot(leftColumn);
	}

	public void loadTemplates(Object[][] templates) {
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