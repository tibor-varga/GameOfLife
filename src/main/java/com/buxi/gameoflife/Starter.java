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

		// Matrix matrix = new Matrix(200, 200);
		// MatrixHelper.initMatrixRandom(matrix);
		// MatrixHelper.initWithPattern(matrix, "acorn.dat", new Coordinate(100, 100));
		// MatrixHelper.initWithPattern(matrix, "diehard.dat", new Coordinate(100,
		// 100));
		// MatrixHelper.initWithPattern(matrix, "r-pentomino.dat", new Coordinate(100,
		// 100));
		// MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80,
		// 90));
		// MatrixHelper.initWithPattern(matrix, "gun1.dat", new Coordinate(100, 100));
		// MatrixHelper.initWithPattern(matrix, "first_gun.dat", new Coordinate(100,
		// 100));
		// MatrixHelper.initWithPattern(matrix, "endup_in_pulsar.dat", new
		// Coordinate(100, 100));
		// MatrixHelper.initWithPattern(matrix, "interessant.dat", new Coordinate(100,
		// 100));
		// MatrixHelper.initWithPattern(matrix, "own.dat", new Coordinate(100, 100));
		// supernova(matrix);
		// killPulsarWithFirework(matrix);
		// Screen frame = new Screen(5, 5, matrix);
		// frame.setSize(1700, 700);
		// frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// frame.setVisible(true);
	}

	public static void supernova(Matrix matrix) throws URISyntaxException {
		MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
		MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(33, 41));
		MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(15, 10));
		MatrixHelper.initWithPattern(matrix, "gun3.dat", new Coordinate(185, 15));
	}

	public static void killPulsarWithFirework(Matrix matrix) throws URISyntaxException {
		MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
		MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(35, 45));
	}

	public static void killPulsar7(Matrix matrix) throws URISyntaxException {
		MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
		MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(35, 55));
	}

	public static void explodePulsar6(Matrix matrix) throws URISyntaxException {
		MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
		MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(40, 55));
	}

	public static void killPulsar5(Matrix matrix) throws URISyntaxException {
		MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
		MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(50, 65));
	}

	public static void killPulsar4(Matrix matrix) throws URISyntaxException {
		MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
		MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(60, 85));
	}

	public static void killPulsar2(Matrix matrix) throws URISyntaxException {
		MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
		MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(70, 90));
	}

	public static void killPulsar3(Matrix matrix) throws URISyntaxException {
		MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
		MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(70, 85));
	}

}
