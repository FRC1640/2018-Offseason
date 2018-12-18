package frc.team1640.systems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.team1640.robot.Controller;
import frc.team1640.robot.Controller.Axis;
import frc.team1640.robot.Controller.Button;
import frc.team1640.systems.ISystem;
import main.java.frc.team1640.robot.Intake;
import frc.team1640.robot.SwerveController;

public class IntakeSystem implements ISystem {

	static enum OpMode { NORMAL, CALIBRATION; }

	public static double DB_LJS = 0.2;
	public static double DB_RJS = 0.2;

	private Controller driverController;
	private Intake intake;
	private Vector2 leftJsDeadband;
	private OpMode opMode;
	private NetworkTable networkTable;

	public IntakeSystem () {
		// Get reference to controller & create new swerve controller
		driverController = Controller.getController(0);
		intake = new Intake();
	
		// Set op-mode to "normal"
		opMode = OpMode.NORMAL;
	}

	@Override
	public void statelessUpdate() {
		
	}

	@Override
	public void disabledInit() {
		intake.disable();
	}

	@Override
	public void disabledUpdate() {

	}

	@Override
	public void autonInit() {
		intake.enable();
	}

	@Override
	public void autonUpdate() {
	}

	@Override
	public void teleopInit() {
		// Enable swerve controller
		intake.enable();
	}

	@Override
	public void teleopUpdate() {

		opMode = (networkTable.getEntry("CALIBRATION_MODE").getBoolean(false)) ? OpMode.CALIBRATION : OpMode.NORMAL;

		switch (opMode) {

			case NORMAL: {

				boolean rightBumper = driverController.getButtonPressed(Button.RB);
				boolean leftBumper = driverController.getButtonPressed(Button.LB);

				boolean rightTrigger = driverController.getButtonPressed(Button.RT);
				boolean leftTrigger = driverController.getButtonPressed(Button.LT);
				
				double motorSpeed = 5;

				if (rightBumper) { intake.closeIntake(); } else
				if (leftBumper) { intake.openIntake(); }

				if (rightTrigger) { intake.driveMotors(motorSpeed); } else
				if (leftTrigger) { intake.driveMotors(-motorSpeed); }

			} break;

			case CALIBRATION: {
								

			} break;

		}

	}

	@Override
	public void testInit() {
		// Do same as disabled
		disabledInit();
	}

	@Override
	public void testUpdate() {
		// Do same as disabled
		disabledUpdate();
	}
}