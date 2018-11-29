package frc.team1640.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;

public class Arm {
	
	WPI_TalonSRX armMotorLeft;
	WPI_TalonSRX armMotorRight;
	AnalogInput armSensor;
	Solenoid armBrake;
	double minVoltage = 0.2;
	double maxVoltage = 4.8;
	double dVoltage = maxVoltage - minVoltage;
	boolean enabled;
	// public static final double COUNTS_PER_INCH = 4 * 4096 / 18;
	// public static final double INCHES_PER_COUNT = 1.0 / COUNTS_PER_INCH;

	public Arm(boolean reversePrimary, boolean reverseSecondary) {
		armMotorLeft = new WPI_TalonSRX(11);
		armMotorRight = new WPI_TalonSRX(15);
		// armSensor = sensorSet.getArmSensor();
		armBrake = new Solenoid(0);
		
		armMotorLeft.setInverted(reversePrimary);
		armMotorRight.setInverted(reverseSecondary);

		armMotorLeft.setNeutralMode(NeutralMode.Brake);
		armMotorRight.setNeutralMode(NeutralMode.Brake);
		
	}

	public static enum ArmPosition {
		Floor      (-4.6), // Same as ScaleMid
		Switch     (46.0), // Same as ScaleMin, ScaleMax, Travel
		Start      (76.6),
		ScaleBack (133.0);
//These values may not be correct
		ArmPosition (double angle) {
			this.angle = angle;
		}

		double angle;
	}

	public double getAngle() {
		return ( (-(360.0 * (armSensor.getVoltage() - minVoltage) / dVoltage) + 360.0 - 0) % 360.0) - 27.33;
	}	

	public void enable() {
			enabled = true;

	}

	public void disable() {
			enabled = false;

	}

}
