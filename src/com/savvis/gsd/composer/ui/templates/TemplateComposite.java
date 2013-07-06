package com.savvis.gsd.composer.ui.templates;

import com.savvis.gsd.composer.ui.templates.components.TemplateSearchBox;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class TemplateComposite {
	
	public static VerticalLayout createTemplateUI() {
		final VerticalLayout leftColumn = new VerticalLayout();
		final HorizontalLayout topLeft = createTopLeftUIComponents();
		
		Tree tree = createTemplateTreeUIComponent();
		leftColumn.addComponent(topLeft);
		leftColumn.addComponent(tree);
		return leftColumn;
	}

	public static Tree createTemplateTreeUIComponent() {
		Tree tree = new Tree("Email Templates");
		tree.setId("templateTree");
		loadTemplates(tree);
		return tree;
	}

	public static HorizontalLayout createTopLeftUIComponents() {
		final HorizontalLayout topLeft = new HorizontalLayout();
		Button applyTemplateButton = new Button("Apply");

		topLeft.addComponent(new TemplateSearchBox());
		topLeft.addComponent(applyTemplateButton);
		
		return topLeft;
	}
	
	private static void loadTemplates(Tree tree) {
		final Object[][] planets = new Object[][]{
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
		        
		/* Add planets as root items in the tree. */
		for (int i=0; i<planets.length; i++) {
		    String planet = (String) (planets[i][0]);
		    tree.addItem(planet);
		    
		    if (planets[i].length == 1) {
		        // The planet has no moons so make it a leaf.
		        tree.setChildrenAllowed(planet, false);
		    } else {
		        // Add children (moons) under the planets.
		        for (int j=1; j<planets[i].length; j++) {
		            String moon = (String) planets[i][j];
		            
		            // Add the item as a regular item.
		            tree.addItem(moon);
		            
		            // Set it to be a child.
		            tree.setParent(moon, planet);
		            
		            // Make the moons look like leaves.
		            tree.setChildrenAllowed(moon, false);
		        }

		        // Expand the subtree.
		        tree.expandItemsRecursively(planet);
		    }
		}
	}
}