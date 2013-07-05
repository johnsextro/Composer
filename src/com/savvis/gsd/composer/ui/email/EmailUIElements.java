package com.savvis.gsd.composer.ui.email;

import com.vaadin.ui.Component;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class EmailUIElements {
	

	public static Component createEmailUI() {
		final VerticalLayout centerColumn = new VerticalLayout();
		
		TextArea headerArea = createEmailHeaderComponent();
		RichTextArea emailBody = new RichTextArea();
		emailBody.setId("emailBody");
		emailBody.setWidth("500px");
		emailBody.setHeight("500px");
		
		centerColumn.addComponent(headerArea);
		centerColumn.addComponent(emailBody);
		return centerColumn;
	}

	public static TextArea createEmailHeaderComponent() {
		TextArea headerArea = new TextArea();
		headerArea.setId("emailHeader");
		headerArea.setValue("From: \nReply To: \nTo: \nCC: \nBCC: \n");
		return headerArea;
	}

}
