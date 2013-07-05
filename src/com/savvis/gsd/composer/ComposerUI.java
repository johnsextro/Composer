package com.savvis.gsd.composer;

import javax.servlet.annotation.WebServlet;

import com.savvis.gsd.composer.ui.email.EmailUIElements;
import com.savvis.gsd.composer.ui.templates.TemplateUIElements;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("composer")
public class ComposerUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ComposerUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final HorizontalLayout contentBody = new HorizontalLayout();
		
		contentBody.setMargin(true);
		setContent(contentBody);

		contentBody.addComponent(TemplateUIElements.createTemplateUI());
		contentBody.addComponent(EmailUIElements.createEmailUI());
	}


}