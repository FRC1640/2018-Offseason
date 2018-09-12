package frc.team1640.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import frc.team1640.utilities.Vector2;

public class Pivot {

	WPI_TalonSRX driveMotor;
	WPI_TalonSRX steerMotor;
	AnalogInput resolver;

	Vector2 position;

	double targetAngleD;
	double targetSpeed;

	double minVoltage;
	double dVoltage;

	boolean enabled;
	boolean flipDrive;

	/**
	 * 
	 * @param position
	 * @param driveMotorChannel
	 * @param steerMotorChannel
	 * @param resolverChannel
	 * @param minResolverVoltage
	 * @param maxResolverVoltage
	 */
	public Pivot (Vector2 position, int driveMotorChannel, int steerMotorChannel, int resolverChannel, double minResolverVoltage, double maxResolverVoltage) {
		
	}

	/**
	 * 
	 * @return
	 */
	public Vector2 getPosition () {

		return null;
	}

	/**
	 * 
	 */
	public void enable () {

	}

	/**
	 * 
	 */
	public void disable () {

	}

	/**
	 * 
	 * @return
	 */
	public boolean getFlipDrive () {

		return false;
	}

	/**
	 * 
	 * @return
	 */
	public double getTargetAngle () {

		return 0.0;
	}

	/**
	 * 
	 * @return
	 */
	public double getTargetSpeed () {

		return 0.0;
	}

	/**
	 * 
	 * @return
	 */
	public double getPivotAngle () {
		
		return 0.0;
	}

	/**
	 * 
	 * @return
	 */
	public double getPivotAngleD () {

		return 0.0;
	}

	/**
	 * 
	 * @param angleR
	 */
	public void setTargetAngle (double angleR) {
		
	}

	/**
	 * 
	 * @param angleD
	 */
	public void setTargetAngleD (double angleD) {
		// TODO: Set target angle parameter equal to angleD
	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed (double speed) {
		// TODO: Use the set() method on the drive motor object
	}

}