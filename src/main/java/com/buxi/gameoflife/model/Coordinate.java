/**
 * 
 */
package com.buxi.gameoflife.model;

/**
 * @author buxi
 *
 */
public class Coordinate {
	public int x;
	public int y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (o == this)
			return true;

		if (!o.getClass().equals(getClass()))
			return false;

		Coordinate that = (Coordinate) o;

		return this.x == that.x && this.y == that.y;
	}

	@Override
	public int hashCode() {
		return (31 + x) * 31 + y;
	}

}
