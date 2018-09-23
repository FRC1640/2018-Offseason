package frc.team1640.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import frc.team1640.utilities.Vector2;

public class PivotImpl extends Pivot {

	/**
	 * 
	 * @param position Position vector for where this pivot is located on the robot
	 * @param driveMotorChannel Channel the drive motor is connected to
	 * @param steerMotorChannel Channel the steering motor is connected to
	 * @param resolverChannel Channel the resolver is connected to
	 * @param minResolverVoltage Minimum voltage recognized by the resolver
	 * @param maxResolverVoltage Maximum voltage recognized by the resolver
	 */
	public PivotImpl (Vector2 position, int driveMotorChannel, int steerMotorChannel, int resolverChannel, double minResolverVoltage, double maxResolverVoltage, double angleOffset, boolean reverseDrive, boolean reverseSteer, boolean reverseResolverAngle) {
		super(position, driveMotorChannel, steerMotorChannel, resolverChannel, minResolverVoltage, maxResolverVoltage, angleOffset, reverseDrive, reverseSteer, reverseResolverAngle);
		this.position = position;

		flipDrive = false;
		targetAngleD = 0.0;
		enabled = true;

		reverseDriveMotor = reverseDrive;
		this.reverseResolverAngle = reverseResolverAngle;

		driveMotor = new WPI_TalonSRX(driveMotorChannel);
		steerMotor = new WPI_TalonSRX(steerMotorChannel);

		resolver = new AnalogInput(resolverChannel) {

			@Override
			public double pidGet () {
				double dAngle = targetAngleD - getPivotAngleD();
				flipDrive = (90.0 <= dAngle) && (dAngle <= 270.0);
				double sin = Math.sin(dAngle * Math.PI / 180.0);
				return (flipDrive ^ reverseSteer) ? -sin : sin;
			}

		};

		vSlope = 360.0 / (maxResolverVoltage - minResolverVoltage);
		vOffset = -vSlope * minResolverVoltage;

		steerPidController = new PIDController(1.0, 0.05, 0.0, 0.0, resolver, steerMotor, 0.02); // TODO: PID values

	}

	/**
	 * 
	 * @return Returns the position vector
	 */
	public Vector2 getPosition () {
		return position;
	}

	/**
	 * 
	 */
	public void enable () {
		if (!enabled) {
			enabled = true;
			steerPidController.enable();
		}
	}

	/**
	 * 
	 */
	public void disable () {
		if (enabled) {
			enabled = false;
			steerPidController.disable();
		}
	}

	/**
	 * 
	 * @return Returns the flip drive flag
	 */
	public boolean getFlipDrive () {
		return flipDrive;
	}

	/**
	 * 
	 * @return Returns the target angle in degrees
	 */
	public double getTargetAngleD () {
		return targetAngleD;
	}

	/**
	 * 
	 * @return Returns the target angle in radians
	 */
	public double getTargetAngle () {
		return targetAngleD * Math.PI / 180.0;
	}

	/**
	 * 
	 * @return Returns the target drive speed
	 */
	public double getTargetSpeed () {
		return targetSpeed;
	}

	/**
	 * 
	 * @return Returns the absolute angle this pivot is pointing, in radians
	 */
	public double getPivotAngle () {
		return getPivotAngleD() * Math.PI / 180.0;
	}

	/**
	 * 
	 * @return Returns the absolute angle this pivot is pointing, in degrees
	 */
	public double getPivotAngleD () {
		double angle = vSlope * resolver.getValue() + vOffset;
		return (reverseResolverAngle) ? 360 - angle : angle;
	}

	/**
	 * 
	 * @param angleD Target angle to set in degrees. 0-degrees is east (right), and increases counter-clockwise
	 */
	public void setTargetAngleD (double angleD) {
		targetAngleD = angleD;
	}

	/**
	 * 
	 * @param angleR Target angle to set in radians
	 */
	public void setTargetAngle (double angleR) {
		targetAngleD = angleR * 180.0 / Math.PI;
	}

	/**
	 * 
	 * @param speed Target speed for this pivot
	 */
	public void setSpeed (double speed) {
		if (!enabled) { speed = 0.0; }
		else if (reverseDriveMotor ^ flipDrive) { speed = -speed; }
		driveMotor.set(speed);
	}

}