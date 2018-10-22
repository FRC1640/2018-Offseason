package frc.team1640.utilities;

public class Vector2 {

	double x;
	double y;

	/**
	 * 
	 * @param x X-value to assign to a new vector.
	 * @param y Y-value to assign to a new vector.
	 */
	public Vector2 (double x, double y) {
		// TODO: Assign this.x and this.y to x and y, respectively
	}

	/**
	 * 
	 * @param v1 Reference to a vector to copy.
	 */
	public Vector2 (Vector2 v1) {
		// TODO: Assign x and y to the x and y values of v1
	}

	/**
	 * 
	 */
	public Vector2 () {
		// TODO: Assign x and y to 0.0
	}

	/**
	 * 
	 * @return Returns a copy of this vector.
	 */
	public Vector2 copy () {
		// TODO: Create a new vector based on this one and return a reference to it
		return null;
	}

	public void set (double x, double y) {
		// TODO: 
	}

	/**
	 * 
	 * @return Returns the x value of this vector.
	 */
	public double getX () {
		// TODO: Return the x value of this vector
		return 0.0;
	}

	/**
	 * 
	 * @return Returns the y value of this vector.
	 */
	public double getY () {
		// TODO: Return the y value of this vector
		return 0.0;
	}

	/**
	 * 
	 * @return Returns the magnitude of this vector.
	 */
	public double magnitude () {
		// TODO: Return the magnitude of this vector
		// sqrt ( x^2 + y^2 )
		return 0.0;
	}

	/**
	 * 
	 * @return Returns the angle of this vector with respect to the x-axis, in radians.
	 */
	public double getAngle () {
		// TODO: Return the angle of this vector in radians with respect to the x-axis
		// atan ( y / x )
		// HINT: try Math.atan2()
		return 0.0;
	}

	/**
	 * 
	 * @return Returns the angle of this vecotr with respect to the x-axis, in degrees.
	 */
	public double getAngleD () {
		// TODO: Return the angle of this vector in degrees with respect to the x-axis
		// HINT: use getAngle() and convert radians to degrees
		return 0.0;
	}

	/**
	 * 
	 * @param angleR The angle by which to rotate this vector counterclockwise, in radians.
	 * @return Returns a reference to this vector.
	 */
	public Vector2 rotate (double angleR) {
		// TODO: Rotate this vector by the specified angle, in radians
		//
		// | cos(ang)  -sin(ang) |  | x |
		// | sin(ang)   cos(ang) |  | y |
		//
		// x_new = x * cos(ang) - y * sin(ang)
		// y_new = x * sin(ang) + y * cos(ang)
		return null;
	}

	/**
	 * 
	 * @param angleD The angle by which to rotate this vector counterclockwise, in degrees.
	 * @return Returns a reference to this vector.
	 */
	public Vector2 rotateD (double angleD) {
		// TODO: Rotate this vector by the specified angle, in degrees
		// HINT: convert the angle from degrees to radians and call rotate()
		return null;
	}

	/**
	 * 
	 * @param v1 Reference to a vector to add to this one.
	 * @return Returns a reference to this vector.
	 */
	public Vector2 add (Vector2 v1) {
		// TODO: Add the components of v1 to the components of this vector and return a reference to this
		return null;
	}

	/**
	 * 
	 * @param scalar A scalar value to multiply this vector by.
	 * @return Returns a reference to this vector.
	 */
	public Vector2 multiply (double scalar) {
		// TODO: Multiply the components of this vector by the scalar value
		return null;
	}

	/**
	 * 
	 * @return Returns a reference to this vector.
	 */
	public Vector2 negate () {
		// TODO: Negate this vector by multiplying its components by -1
		return null;
	}

	/**
	 * 
	 * @return Returns a reference to this vector
	 */
	public Vector2 reset () {
		// TODO: Set the x and y values of this to 0.0, and return a reference to this
		return null;
	}

	/**
	 * 
	 * @return Returns a reference to this vector.
	 */
	public Vector2 unitVector () {
		// TODO: Scale the components of this vector by 1 / the magnitude of this vector and return a reference to this
		return null;
	}

	/**
	 * 
	 * @param v1 Reference to one vector to add.
	 * @param v2 Reference to a second vector to add.
	 * @return Returns a new vector that is a sum of the two parameters.
	 */
	public static Vector2 add (Vector2 v1, Vector2 v2) {
		// TODO: Create a new vector based off one of the arguments, add the second vector to it, then return it
		return null;
	}

}