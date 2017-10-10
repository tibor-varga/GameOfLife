/**
 * 
 */
package com.buxi.gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;

import com.buxi.gameoflife.jmx.IConfigJmxBean;
import com.buxi.gameoflife.model.Matrix;

/**
 * @author buxi
 *
 */
public class Screen extends JFrame {
	private int pixelSizeX;
	private int pixelSizeY;
	private Matrix matrix;

	@Autowired
	private IConfigJmxBean configBean;

	public Screen(int pixelSizeX, int pixelSizeY, Matrix matrix) throws HeadlessException {
		super();
		this.pixelSizeX = pixelSizeX;
		this.pixelSizeY = pixelSizeY;
		this.matrix = matrix;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// System.out.println("sleep:" + configBean.getThreadSleepInMillis());
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		while (true) {
			showMatrix(graphics);

			try {
				Thread.sleep(configBean.getThreadSleepInMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			matrix = MatrixHelper.recalculateMatrix(matrix);
		}
	}

	public void showRectXY(int x, int y, Graphics2D graphics) {
		graphics.setPaint(new Color(150, 150, 150));
		graphics.fillRect(x * pixelSizeX, y * pixelSizeY, pixelSizeX, pixelSizeY);
	}

	public void hideRectXY(int x, int y, Graphics2D graphics) {
		graphics.setPaint(new Color(0, 0, 0));
		graphics.fillRect(x * pixelSizeX, y * pixelSizeY, pixelSizeX, pixelSizeY);
	}

	public void showMatrix(Graphics2D graphics) {
		for (int i = 0; i < matrix.getMatrixSizeX(); i++) {
			for (int j = 0; j < matrix.getMatrixSizeY(); j++) {
				if (matrix.getMatrix()[i][j] == 0) {
					hideRectXY(i, j, graphics);
				} else {
					showRectXY(i, j, graphics);
				}
			}
		}

	}

	public IConfigJmxBean getConfigBean() {
		return configBean;
	}

	public void setConfigBean(IConfigJmxBean configBean) {
		this.configBean = configBean;
	}
}
