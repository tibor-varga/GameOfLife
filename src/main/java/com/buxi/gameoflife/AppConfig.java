/**
 * 
 */
package com.buxi.gameoflife;

import java.net.URISyntaxException;

import javax.swing.WindowConstants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author buxi
 *
 */
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
	private int matrixSizeX;
	private int matrixSizeY;
	private int pixelSizeX;
	private int pixelSizeY;
	private String initPattern;
	private int initPattenCoordX;
	private int initPattenCoordY;

	@Bean
	public Matrix createMatrix() {
		return new Matrix(matrixSizeX, matrixSizeY);
	}

	@Bean("screen")
	public Screen createScreen() throws URISyntaxException {
		Screen screen = new Screen(pixelSizeX, pixelSizeY, createMatrix());
		screen.initWithPattern(initPattern, initPattenCoordX, initPattenCoordY);
		screen.setSize(matrixSizeX * pixelSizeX, matrixSizeY * pixelSizeY);
		screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		return screen;
	}

	public int getMatrixSizeX() {
		return matrixSizeX;
	}

	public void setMatrixSizeX(int matrixSizeX) {
		this.matrixSizeX = matrixSizeX;
	}

	public int getMatrixSizeY() {
		return matrixSizeY;
	}

	public void setMatrixSizeY(int matrixSizeY) {
		this.matrixSizeY = matrixSizeY;
	}

	public int getPixelSizeX() {
		return pixelSizeX;
	}

	public void setPixelSizeX(int pixelSizeX) {
		this.pixelSizeX = pixelSizeX;
	}

	public int getPixelSizeY() {
		return pixelSizeY;
	}

	public void setPixelSizeY(int pixelSizeY) {
		this.pixelSizeY = pixelSizeY;
	}

	public String getInitPattern() {
		return initPattern;
	}

	public void setInitPattern(String initPattern) {
		this.initPattern = initPattern;
	}

	public int getInitPattenCoordX() {
		return initPattenCoordX;
	}

	public void setInitPattenCoordX(int initPattenCoordX) {
		this.initPattenCoordX = initPattenCoordX;
	}

	public int getInitPattenCoordY() {
		return initPattenCoordY;
	}

	public void setInitPattenCoordY(int initPattenCoordY) {
		this.initPattenCoordY = initPattenCoordY;
	}

}
