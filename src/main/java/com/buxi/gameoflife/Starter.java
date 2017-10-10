/**
 * 
 */
package com.buxi.gameoflife;

import java.awt.EventQueue;
import java.net.URISyntaxException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author buxi
 *
 */
@SpringBootApplication
public class Starter {

	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(Starter.class).headless(false).run(args);
		EventQueue.invokeLater(() -> {
			Screen screen = (Screen) context.getBean("screen");
			screen.setVisible(true);
		});
	}
}
