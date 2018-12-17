package frc.team1640.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;

public class Arm {
	
	public static final double CRITICAL_ANGLE = 0.0; //TODO change value
	ArmPosition armPosition;
	WPI_TalonSRX motorLeft;
	WPI_TalonSRX motorRight;
	AnalogInput angleSensor;
	Solenoid brakeSolenoid;
	double minVoltage = 0.2;
	double maxVoltage = 4.8;
	double dVoltage = maxVoltage - minVoltage;
	double angle;
	boolean enabled;
	double speed;
	public static final double ANGLE_BUFFER = 5.0;
	public static final double MAX_LIMIT = 25.0;
	// public static final double COUNTS_PER_INCH = 4 * 4096 / 18;
	// public static final double INCHES_PER_COUNT = 1.0 / COUNTS_PER_INCH;
	PIDController armPidController;	

	public Arm(int motorLeftChannel, int motorRightChannel, int angleSensorChannel, int brakeSolenoidChannel, boolean reversePrimary, boolean reverseSecondary, Lift lift) {
		armPosition = ArmPosition.Start;
		motorLeft = new WPI_TalonSRX(motorLeftChannel); // 11
		motorRight = new WPI_TalonSRX(motorRightChannel); // 15
		brakeSolenoid = new Solenoid(brakeSolenoidChannel); // 0
		angleSensor = new AnalogInput(angleSensorChannel) {
			@Override
			public double pidGet() {
				double target2 = (lift.getLiftHeightInInches() < Lift.CRITICAL_HEIGHT) ? CRITICAL_ANGLE : armPosition.angleSetPoint;
				double dif = getAngle() - target2;
				if(dif < 5) {
					brakeSolenoid.set(true);
					disable();		
					dif = 0;		
				}
				return dif;
			}
		};// 6

		
		motorLeft.setInverted(reversePrimary);
		motorRight.setInverted(reverseSecondary);
		
		motorLeft.setNeutralMode(NeutralMode.Brake);
		motorRight.setNeutralMode(NeutralMode.Brake);

		// http://first.wpi.edu/FRC/roborio/release/docs/java/

		PIDOutput pidOutput = new PIDOutput() {
			
			@Override
			public void pidWrite (double value) {
				if(Math.abs(value) > 1.0) {
					value /= Math.abs(value);
				}
				
				motorLeft.set(value);
				motorRight.set(value);
			}
	
		}; 
		
		armPidController = new PIDController(1.0, 0.05, 0.0, 0.0, angleSensor, pidOutput, 0.02);
		
	}

	public static enum ArmPosition {
		Floor      (-4.6), // Same as ScaleMid
		Switch     (46.0), // Same as ScaleMin, ScaleMax, Travel
		Start      (76.6),
		ScaleBack (133.0);
//These values may not be correct
		ArmPosition (double angleSetPoint) {
			this.angleSetPoint = angleSetPoint;
		}

		double angleSetPoint;
	}

	public double getAngle() {
		return ((-(360.0 * (angleSensor.getVoltage() - minVoltage) / dVoltage) + 360.0 - 0) % 360.0) - 27.33;
	}	

	public void enable() {
		enabled = true;
		armPidController.enable();
	}

	public void disable() { 
		enabled = false;	
		armPidController.disable();
	}

	public void setTarget(ArmPosition armPosition) {
		this.armPosition = armPosition;
		brakeSolenoid.set(false);
		enable();
	}

	public void update() {

	}

	// This assumes the highest point is last in the list
	public void raiseTarget () {
		int ord = armPosition.ordinal();
		if (ord == ArmPosition.values().length-1) { return; }
	 	armPosition = ArmPosition.values()[ord+1];
	}

	// This assumes the lowest point is first in the list
	public void lowerTarget () {
		int ord = armPosition.ordinal();
		if (ord == 0) { return; }
		armPosition = ArmPosition.values()[ord-1];
	}
}	