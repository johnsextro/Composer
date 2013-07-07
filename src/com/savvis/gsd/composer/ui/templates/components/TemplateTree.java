package com.savvis.gsd.composer.ui.templates.components;

import com.vaadin.ui.Tree;

public class TemplateTree extends Tree {

	public TemplateTree() {
		Tree tree = new Tree("Email Templates");
		tree.setId("templateTree");
		tree.setImmediate(true);
	}
}
