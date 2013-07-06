package com.savvis.gsd.composer.ui.templates.components;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.ComboBox;


public class TemplateSearchBox extends CustomComponent implements Property.ValueChangeListener {
	private static final long serialVersionUID = -3498640374700355524L;
	private ComboBox templateSearch;

	public TemplateSearchBox(){
		templateSearch = new ComboBox();
		templateSearch.addValueChangeListener(this);
		templateSearch.setImmediate(true);  //This setting ensures that change events fire immediately
		templateSearch.setId("templateSearch");
		templateSearch.setInputPrompt("Search Templates");
		templateSearch.addItem("Global");
		templateSearch.addItem("Coke");
		
		setCompositionRoot(templateSearch);
	}


	@Override
	public void valueChange(ValueChangeEvent event) {
		System.out.println("Value Change Fired");
	}
}
