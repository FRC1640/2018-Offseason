package frc.team1640.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Lift {

    public static final double COUNTS_PER_INCH = 4 * 4096 / 18;
	public static final double INCHES_PER_COUNT = 1.0 / COUNTS_PER_INCH;
	public static final double CRITICAL_HEIGHT = 0.0; //TODO change value

	public static enum OperatingMode {
		MANUAL,
		MANAGED;
	}

	public static enum LiftState {
		AT_TARGET,
		TRANSITIONING;
	}

	// These MUST be ordered from SMALLEST to LARGEST
	public static enum LiftTarget {
		MIN 			(0.0),		// NONE, START
		FLOOR 			(0.5),		// CUBE_TRAVEL
		SWITCH 			(25.0),
		SCALE_SHOOT 	(40.0),
		SCALE_BACK		(57.5),
		SCALE_MIN 		(59.0),
		SCALE_MAX		(60.0),		// WHY ?
		SCALE_MID 		(67.0);		// WHY ?

		double height;

		LiftTarget (double height) {
			this.height = height;
		}
	}

	WPI_TalonSRX liftMotor1;
	WPI_TalonSRX liftMotor2;

	OperatingMode operatingMode;
	LiftState liftState;
	LiftTarget liftTarget;
	

	public Lift (boolean reversePrimary, boolean reverseSecondary) {
		liftMotor1 = new WPI_TalonSRX(14);
		liftMotor2 = new WPI_TalonSRX(1);

		liftMotor1.setInverted(reversePrimary);
		liftMotor2.setInverted(reverseSecondary);

		liftMotor1.setNeutralMode(NeutralMode.Brake);
		liftMotor2.setNeutralMode(NeutralMode.Brake);

		operatingMode = OperatingMode.MANAGED;
		liftState = LiftState.AT_TARGET;
		liftTarget = LiftTarget.MIN;
	}

	public double getLiftHeightInInches () {
		return INCHES_PER_COUNT * getLiftHeightInCounts();
	}

	public double getLiftHeightInCounts () {
		return liftMotor1.getSelectedSensorPosition(0);
	}

	// This assumes the highest point is last in the list
	public void raiseTarget () {
		int ord = liftTarget.ordinal();
		if (ord == LiftTarget.values().length-1) { return; }
		liftTarget = LiftTarget.values()[ord+1];
	}

	// This assumes the lowest point is first in the list
	public void lowerTarget () {
		int ord = liftTarget.ordinal();
		if (ord == 0) { return; }
		liftTarget = LiftTarget.values()[ord-1];
	}

	public void resetTarget () {
		liftTarget = LiftTarget.MIN;
	}

	public void update () {
		switch (operatingMode) {
			case MANUAL: { updateManual(); } break;
			case MANAGED: { updateManaged(); } break;
		}
	}

	private void updateManual () {

	}

	private void updateManaged () {
		switch (liftState) {

			case AT_TARGET: {
				liftMotor1.set(0.0);
				liftMotor2.set(0.0);
			} break;

			case TRANSITIONING: {

			} break;

		}
	}

}