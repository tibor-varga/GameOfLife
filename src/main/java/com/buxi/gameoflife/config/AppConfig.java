/**
 * 
 */
package com.buxi.gameoflife.config;

import java.net.URISyntaxException;

import javax.swing.WindowConstants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.buxi.gameoflife.MatrixInitializerFactory;
import com.buxi.gameoflife.Screen;
import com.buxi.gameoflife.model.Coordinate;
import com.buxi.gameoflife.model.Matrix;

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
	private String initScene;
	private int defaultPatternCoordX;
	private int defaultPatternCoordY;

	@Bean
	public Matrix createMatrix() throws URISyntaxException {
		return MatrixInitializerFactory.createInitMatrix(matrixSizeX, matrixSizeY,
				new Coordinate(defaultPatternCoordX, defaultPatternCoordY), initScene);
	}

	@Bean("screen")
	public Screen createScreen() throws URISyntaxException {
		Screen screen = new Screen(pixelSizeX, pixelSizeY, createMatrix());
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

	public String getInitScene() {
		return initScene;
	}

	public void setInitScene(String initScene) {
		this.initScene = initScene;
	}

	public int getDefaultPatternCoordX() {
		return defaultPatternCoordX;
	}

	public void setDefaultPatternCoordX(int defaultPatternCoordX) {
		this.defaultPatternCoordX = defaultPatternCoordX;
	}

	public int getDefaultPatternCoordY() {
		return defaultPatternCoordY;
	}

	public void setDefaultPatternCoordY(int defaultPatternCoordY) {
		this.defaultPatternCoordY = defaultPatternCoordY;
	}

}
