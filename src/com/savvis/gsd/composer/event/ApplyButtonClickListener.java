package com.savvis.gsd.composer.event;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.Tree;

public class ApplyButtonClickListener implements ClickListener{
	private Tree treeTemplate;
	private RichTextArea emailEditor;

	public ApplyButtonClickListener(Tree templateTree, RichTextArea emailEditor) {
		super();
		this.treeTemplate = templateTree;
		this.emailEditor = emailEditor;
	}

	@Override
	public void buttonClick(ClickEvent event) {
		String selectedTemplate = (String) treeTemplate.getValue();
		if (selectedTemplate != null && selectedTemplate != "") {
			emailEditor.setValue(selectedTemplate);
		}
	}

}
