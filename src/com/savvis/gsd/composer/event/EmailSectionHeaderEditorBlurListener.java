package com.savvis.gsd.composer.event;

import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class EmailSectionHeaderEditorBlurListener implements BlurListener {
	private TextField field;
	private Label label;

	public EmailSectionHeaderEditorBlurListener(Label label, TextField field) {
		super();
		this.field = field;
		this.label = label;
	}

	@Override
	public void blur(BlurEvent event) {
		label.setVisible(true);
		label.setValue(field.getValue());
		field.setVisible(false);
	}
}