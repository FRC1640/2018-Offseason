package frc.team1640.systems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.team1640.robot.Controller;
import frc.team1640.robot.Controller.Axis;
import frc.team1640.robot.SwerveController;
import frc.team1640.utilities.Vector2;

public class DriveSystem implements ISystem {

	static enum OpMode { NORMAL, CALIBRATION; }

	public static double DB_LJS = 0.2;
	public static double DB_RJS = 0.2;

	private Controller driverController;
	private SwerveController swerveController;
	private Vector2 leftJsDeadband;
	private OpMode opMode;
	private NetworkTable networkTable;

	public DriveSystem () {
		// Get reference to controller & create new swerve controller
		driverController = Controller.getController(0);
		swerveController = new SwerveController();

		networkTable = NetworkTableInstance.getDefault().getTable("drive_system");

		// Create a vector for deadband calculations
		leftJsDeadband = new Vector2();
		// Set op-mode to "normal"
		opMode = OpMode.NORMAL;
	}

	@Override
	public void statelessUpdate() {
		
	}

	@Override
	public void disabledInit() {
		swerveController.disable();
	}

	@Override
	public void disabledUpdate() {

	}

	@Override
	public void autonInit() {
		swerveController.enable();
	}

	@Override
	public void autonUpdate() {

	}

	@Override
	public void teleopInit() {
		// Enable swerve controller
		swerveController.enable();
	}

	@Override
	public void teleopUpdate() {

		opMode = (networkTable.getEntry("CALIBRATION_MODE").getBoolean(false)) ? OpMode.CALIBRATION : OpMode.NORMAL;

		switch (opMode) {

			case NORMAL: {

				// Get left- and right-x and left-y joystick values
				double x1 = driverController.getAxis(Axis.LX);
				double y1 = driverController.getAxis(Axis.LY);
				double x2 = driverController.getAxis(Axis.RX);

				// System.out.format("(%3.2f, %3.2f, %3.2f)\n", x1, y1, x2);

				// Perform deadbanding on left joystick values
				leftJsDeadband.set(x1,y1);
				if (leftJsDeadband.magnitude() < DB_LJS) { leftJsDeadband.reset(); }
				else { leftJsDeadband.multiply(driveDeadbandCurve(leftJsDeadband.magnitude(), DB_LJS)); }

				// Perform deadbanding on right joystick
				if (Math.abs(x2) < DB_RJS) { x2 = 0.0; }

				// TODO: Gyro-correction if in a "compatible" mode



				// Call drive code on swerve controller
				swerveController.drive(leftJsDeadband.getX(), leftJsDeadband.getY(), x2);

			} break;

			case CALIBRATION: {

				double rotationSpeed = networkTable.getEntry("ROTATION_SPEED").getDouble(0.0);
				double driveSpeed = networkTable.getEntry("DRIVE_SPEED").getDouble(0.0);												
				
				swerveController.setRotationRaw(rotationSpeed);
				swerveController.setDriveRaw(driveSpeed);

				
				

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

	private double driveDeadbandCurve (double mag, double db) {
		// re-scale the "x-value" to be 0-1, then perform some kind of function (like squaring)
		// y = f ( (mag-db) / (1-db) )
		double rescale = ( (mag-db) / (1-db) );
		return Math.pow(rescale,2);
	}

}