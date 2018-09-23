package frc.team1640.utilities;

public class Vector2Impl extends Vector2 {

	double x;
	double y;

	/**
	 * 
	 * @param x X-value to assign to a new vector.
	 * @param y Y-value to assign to a new vector.
	 */
	public Vector2Impl (double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param v1 Reference to a vector to copy.
	 */
	public Vector2Impl (Vector2 v1) {
		this(v1.x, v1.y);
	}

	/**
	 * 
	 */
	public Vector2Impl () {
		this(0.0, 0.0);
	}

	/**
	 * 
	 * @return Returns a copy of this vector.
	 */
	public Vector2 copy () {
		return new Vector2Impl(this);
	}

	/**
	 * 
	 * @return Returns the x value of this vector.
	 */
	public double getX () {
		return x;
	}

	/**
	 * 
	 * @return Returns the y value of this vector.
	 */
	public double getY () {
		return y;
	}

	/**
	 * 
	 * @return Returns the magnitude of this vector.
	 */
	public double magnitude () {
		return Math.sqrt(x*x + y*y);
	}

	/**
	 * 
	 * @return Returns the angle of this vector with respect to the x-axis, in radians.
	 */
	public double getAngle () {
		return Math.atan2(y, x);
	}

	/**
	 * 
	 * @return Returns the angle of this vecotr with respect to the x-axis, in degrees.
	 */
	public double getAngleD () {
		return getAngle() * 180.0 / Math.PI;
	}

	/**
	 * 
	 * @param angleR The angle by which to rotate this vector counterclockwise, in radians.
	 * @return Returns a reference to this vector.
	 */
	public Vector2 rotate (double angleR) {
		double xc = x, yc = y;
		double cos = Math.cos(angleR), sin = Math.sin(angleR);

		x = xc * cos - yc * sin;
		y = xc * sin + yc * cos;
		
		return this;
	}

	/**
	 * 
	 * @param angleD The angle by which to rotate this vector counterclockwise, in degrees.
	 * @return Returns a reference to this vector.
	 */
	public Vector2 rotateD (double angleD) {
		return rotate(angleD * Math.PI / 180.0);
	}

	/**
	 * 
	 * @param v1 Reference to a vector to add to this one.
	 * @return Returns a reference to this vector.
	 */
	public Vector2 add (Vector2 v1) {
		x += v1.x;
		y += v1.y;
		return this;
	}

	/**
	 * 
	 * @param scalar A scalar value to multiply this vector by.
	 * @return Returns a reference to this vector.
	 */
	public Vector2 multiply (double scalar) {
		x *= scalar;
		y *= scalar;
		return this;
	}

	/**
	 * 
	 * @return Returns a reference to this vector.
	 */
	public Vector2 negate () {
		return multiply(-1.0);
	}

	/**
	 * 
	 * @return Returns a reference to this vector.
	 */
	public Vector2 reset () {
		x = y = 0.0;
		return this;
	}

	/**
	 * 
	 * @return Returns a reference to this vector.
	 */
	public Vector2 unitVector () {
		return multiply(1.0 / magnitude());
	}

	/**
	 * 
	 * @param v1 Reference to one vector to add.
	 * @param v2 Reference to a second vector to add.
	 * @return Returns a new vector that is a sum of the two parameters.
	 */
	public static Vector2 add (Vector2 v1, Vector2 v2) {
		return new Vector2Impl(v1).add(v2);
	}

}