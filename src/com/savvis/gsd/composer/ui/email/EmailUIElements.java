package com.savvis.gsd.composer.ui.email;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class EmailUIElements {
	

	public static Component createEmailUI() {
		final VerticalLayout centerColumn = new VerticalLayout();
		centerColumn.addComponent(createEmailButtons());
		centerColumn.addComponent(createEmailHeaderComponent());
		centerColumn.addComponent(createEmailEditor());
		return centerColumn;
	}

	public static RichTextArea createEmailEditor() {
		RichTextArea emailBody = new RichTextArea();
		emailBody.setId("emailBody");
		emailBody.setWidth("600px");
		return emailBody;
	}

	public static HorizontalLayout createEmailButtons() {
		final HorizontalLayout emailButtonsArea = new HorizontalLayout();
		emailButtonsArea.setId("emailButtonsArea");
		
		Button previewEmail = new Button("Preview");
		previewEmail.setId("previewEmailButton");
		
		Button sendEmail = new Button("Send");
		sendEmail.setId("sendEmailButton");
		
		emailButtonsArea.addComponent(previewEmail);
		emailButtonsArea.addComponent(sendEmail);
		return emailButtonsArea;
	}

	public static TextArea createEmailHeaderComponent() {
		TextArea headerArea = new TextArea();
		headerArea.setId("emailHeader");
		headerArea.setValue("From: \nReply To: \nSubject: \nTo: \nCC: \nBCC: ");
		return headerArea;
	}

}
