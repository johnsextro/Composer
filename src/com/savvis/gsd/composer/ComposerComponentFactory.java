package com.savvis.gsd.composer;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.Tree;

public class ComposerComponentFactory {

	public static Tree createTemplateTree() {
		Tree tree = new Tree("Email Templates");
		tree.setId("templateTree");
		tree.setImmediate(true);
		return tree;
	}
	
	public static ComboBox createTemplateSearchBox() {
		ComboBox templateSearch = new ComboBox();
		templateSearch.setImmediate(true);  //This setting ensures that change events fire immediately
		templateSearch.setId("templateSearch");
		templateSearch.setInputPrompt("Search Templates");
		templateSearch.addItem("Global");
		templateSearch.addItem("Coke");
		return templateSearch;
	}
	
	public static RichTextArea createEmailEditor() {
		RichTextArea emailBody = new RichTextArea();
		emailBody.setId("emailBody");
		emailBody.setWidth("600px");
		return emailBody;
	}

	public static Button createPreviewButton() {
		Button previewEmail = new Button("Preview");
		previewEmail.setId("previewEmailButton");
		return previewEmail;
	}
	
	public static Button createSendButton() {
		Button sendEmail = new Button("Send");
		sendEmail.setId("sendEmailButton");
		return sendEmail;

	}

	public static TextArea createEmailHeaderComponent() {
		TextArea headerArea = new TextArea();
		headerArea.setId("emailHeader");
		headerArea.setValue("From: \nReply To: \nSubject: \nTo: \nCC: \nBCC: ");
		return headerArea;
	}
}
