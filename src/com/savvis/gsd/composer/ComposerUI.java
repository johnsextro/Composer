package com.savvis.gsd.composer;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("composer")
public class ComposerUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ComposerUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Tree tree = new Tree("Email Templates");
		loadTemplates(tree);
		layout.addComponent(tree);
	}
	
	private void loadTemplates(Tree tree) {
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