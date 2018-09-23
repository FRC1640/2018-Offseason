package frc.team1640.robot;

import java.util.HashMap;

import frc.team1640.utilities.Vector2;

public class SwerveController {

	public static final double W = 21.0;
	public static final double L = 27.25;

	public static enum SwerveMode {
		NORMAL,
		FIELD_CENTRIC,
		GYRO_CORRECTED;
	}

	SwerveMode swerveMode;
	HashMap<Pivot,Vector2> pivotMap;

	public SwerveController () {
		// TODO: Set the swerveMode variable to NORMAL
		// TODO: Set the pivotMap variable equal to a new HashMap

		pivotMap.put(new PivotImpl(new Vector2(-W,L).multiply(0.5), 13, 10, 0, 0.20019529200000002, 4.737548343, 0.0, false, false, false), null); // FL
		pivotMap.put(new PivotImpl(new Vector2(W,L).multiply(0.5), 12, 9, 1, 0.20385740100000002, 4.729003422, 0.0, false, false, false), null); // FR
		pivotMap.put(new PivotImpl(new Vector2(-W,-L).multiply(0.5), 2, 6, 2, 0.209960916, 4.742431155, 180.0, false, false, false), null); // BL
		pivotMap.put(new PivotImpl(new Vector2(W,-L).multiply(0.5), 3, 7, 3, 0.205078104, 4.739989749, 180.0, false, false, false), null); // BR
	}

	public void setSwerveMode (SwerveMode sm) {
		// TODO: Set the swerveMode variable to argument "sm"
	}

	public void drive (double x1, double y1, double x2) {

		// TODO: If swerveMode is not equal to NORMAL, return
			// So we don't do anything, since the other modes aren't implemented yet

		// TODO: Create a new Vector2 (call it tVec) and set its x and y values to x1 and y1
		// TODO: If the magnitude of this vector is less than 0.03, reset this vector

		// TODO: If the absolute value of x2 is less than 0.02, set x2 equal to 0.0

		// TODO: Create a new double variable (call it max), and initialize it to 0.0
		// TODO: Iterate over all the pivots in the pivotMap
			// TODO: Create a new Vector2 variable and set it to a copy of the position
				// TODO: Rotate this vector -90 degrees, convert it to a unit vector, multiply it by x2, and add the tVec vector
			// TODO: Put a reference to vector in the pivotMap, mapped by the pivot reference
			// TODO: Set the max variable to whichever is greater, the max variable, or the magnitude of this
		
		// TODO: If the max variable is greater than one
			// TODO: Iterate over all the pivots in the pivotMap
				// TODO: Get the reference to the Vector2 from the pivotMap and multiply it by 1.0 / max
		
		// TODO: Iterate over all the pivots in the pivotMap
			// TODO: Get a reference to the Vector2 from the pivotMap
			// TODO: Set the pivot's speed to the magnitude of the vector
			// TODO: Set the pivot's angle to be the vector's angle

	}

	public void disable () {
		// TODO: Iterate over all the pivots in the pivotMap
			// TODO: Disable the pivot
	}

	public void enable () {
		// TODO: Iterate over all the pivots in the pivotMap
			// TODO: Enable the pivot
	}

}