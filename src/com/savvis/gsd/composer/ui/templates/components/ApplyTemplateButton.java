package com.savvis.gsd.composer.ui.templates.components;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;

public class ApplyTemplateButton extends CustomComponent implements Button.ClickListener {
	private Button applyTemplateButton;
	
	public ApplyTemplateButton() {
		applyTemplateButton = new Button("Apply");
		applyTemplateButton.addClickListener(this);
		applyTemplateButton.setImmediate(true);
		
		setCompositionRoot(applyTemplateButton);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		System.out.println("Apply Button Click");
		
	}
}
