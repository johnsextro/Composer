package test.java.composer.template;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.savvis.gsd.composer.template.TemplateContainer;

public class TemplateContainerTest {
	TemplateContainer container;
	
	@Before
	public void setup() {
		container = new TemplateContainer();
	}
	
	@Test
	public void testNotNull() {
		assertNotNull(container);
	}
	
}
