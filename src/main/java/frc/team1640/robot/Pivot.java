package frc.team1640.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import frc.team1640.utilities.Vector2;

public abstract class Pivot {

	WPI_TalonSRX driveMotor;
	WPI_TalonSRX steerMotor;
	AnalogInput resolver;
	PIDController steerPidController;

	Vector2 position;

	double targetAngleD;
	double targetSpeed;
	double angleOffset;

	double vSlope;
	double vOffset;

	boolean enabled;
	boolean flipDrive;

	boolean reverseDriveMotor;
	boolean reverseResolverAngle;

	/**
	 * 
	 * @param position Position vector for where this pivot is located on the robot
	 * @param driveMotorChannel Channel the drive motor is connected to
	 * @param steerMotorChannel Channel the steering motor is connected to
	 * @param resolverChannel Channel the resolver is connected to
	 * @param minResolverVoltage Minimum voltage recognized by the resolver
	 * @param maxResolverVoltage Maximum voltage recognized by the resolver
	 */
	public Pivot (Vector2 position, int driveMotorChannel, int steerMotorChannel, int resolverChannel, double minResolverVoltage, double maxResolverVoltage, double angleOffset, boolean reverseDrive, boolean reverseSteer, boolean reverseResolverAngle) {
		// TODO: Store the position vector of this pivot

		// TODO: Set flip drive to false
		// TODO: set target angle to 0.0
		// TODO: Set enabled to true

		// TODO: Set reverse drive motor to reverse drive argument
		// TODO: Set class variable reverse resolver angle to argument reverse resolver angle

		// TODO: Create a new drive motor instance with its motor channel
		// TODO: Create a new steering motor instance with its motor channel

		resolver = new AnalogInput(resolverChannel) {

			@Override
			public double pidGet () {
				// TODO: Calculate the difference between the target angle and this pivot's angle
				// TODO: Set the flip drive flag to true if the difference between the target angle and this pivot's angle is between 90 and 270 degrees
					// This indicates the shortest way for the pivot to reach its target angle is to go to angle on the opposite side of the unit circle
				// TODO: Calculate the sine of the difference in angles
				// TODO: If either flipDrive or reverseSteer (but not both), return the negative of the sine, otherwise the positive sine
				return 0.0;
			}

		};

		// TODO: Store the voltage slope, which is 360 / (v_max - v_min)
			// See derivation in getPivotAngleD method
		// TODO: Store voltage offset, which is -360 * v_min / (v_max - v_min)
			// See derivation in getPivotAngleD method
			// This can also be interpreted as - vSlope * minResolverVoltage

		// TODO: Create a new PIDController and instantiate it with the following values:
			// TODO: Set P-value to 1.0
			// TODO: Set I-value to 0.05
			// TODO: Set D-value to 0.0
			// TODO: Set F-value to 0.0
			// TODO: Set the source to the resolver reference
			// TODO: Set the output to the steer motor reference
			// TODO: Set the period to 0.02 seconds

	}

	/**
	 * 
	 * @return Returns the position vector
	 */
	public Vector2 getPosition () {
		// TODO: Return a reference to the position variable
		return null;
	}

	/**
	 * 
	 */
	public void enable () {
		// TODO: Check if the enabled flag is cleared (false) and if so:
			// TODO: Set the enabled flag to true
			// TODO: Enable the steer pid controller
	}

	/**
	 * 
	 */
	public void disable () {
		// TODO: Check if the enabled flag is set (true) and if so:
			// TODO: Set the enabled flag to false
			// TODO: Disable the steer pid controller
	}

	/**
	 * 
	 * @return Returns the flip drive flag
	 */
	public boolean getFlipDrive () {
		// TODO: Return whether the flip drive variable is set
		return false;
	}

	/**
	 * 
	 * @return Returns the target angle in degrees
	 */
	public double getTargetAngleD () {
		// TODO: Return target angle variable, in degrees
		return 0.0;
	}

	/**
	 * 
	 * @return Returns the target angle in radians
	 */
	public double getTargetAngle () {
		// TODO: Return target angle variable, in radians
		return 0.0;
	}

	/**
	 * 
	 * @return Returns the target drive speed
	 */
	public double getTargetSpeed () {
		// TODO: Return the value of the target speed variable
		return 0.0;
	}

	/**
	 * 
	 * @return Returns the absolute angle this pivot is pointing, in radians
	 */
	public double getPivotAngle () {
		// TODO: Return the pivot's angle in radians
		// HINT: Call getPivotAngleD and convert to radians
		return 0.0;
	}

	/**
	 * 
	 * @return Returns the absolute angle this pivot is pointing, in degrees
	 */
	public double getPivotAngleD () {
		// 360 = m * v_max + b
		// 0   = m * v_min + b

		// 360 = m * dV
		// m = 360 / dV

		// 0 = ( 360 / dV ) * v_min + b
		// b = - 360 * ( v_min / dV )

		// angle = (360 / dV) * v - (360 * v_min / dV)
		
		// TODO: Calculate and return the angle of this pivot
			// angle = (voltageSlope * voltage) + voltageOffset
			// TODO: return 360 - angle if reverse resolver angle is set, otherwise return the angle

		return 0.0;
	}

	/**
	 * 
	 * @param angleD Target angle to set in degrees. 0-degrees is east (right), and increases counter-clockwise
	 */
	public void setTargetAngleD (double angleD) {
		// TODO: Set target angle parameter equal to angleD
	}

	/**
	 * 
	 * @param angleR Target angle to set in radians
	 */
	public void setTargetAngle (double angleR) {
		// TODO: Set target angle in radians
		// HINT: Convert the angle to degrees and call setTargetAngleD()
	}

	/**
	 * 
	 * @param speed Target speed for this pivot
	 */
	public void setSpeed (double speed) {
		// TODO: If the pivot is not enabled, set speed to 0.0
		// TODO: Otherwise, if reverseDriveMotor or flipDrive is set (but not both), negate the speed
		// TODO: Use the set() method on the drive motor object to set the motor speed
	}

}