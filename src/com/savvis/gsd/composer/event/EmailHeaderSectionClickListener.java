package com.savvis.gsd.composer.event;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class EmailHeaderSectionClickListener implements LayoutClickListener {
	private TextField textField;
	private Label label;

	public EmailHeaderSectionClickListener(Label label, TextField textField) {
		super();
		this.label = label;
		this.textField = textField;
	}

	@Override
	public void layoutClick(LayoutClickEvent event) {
		label.setVisible(false);
		textField.setVisible(true);
		textField.setValue(label.getValue());
		textField.setCursorPosition(textField.getValue().length() + 1);
	}

}
