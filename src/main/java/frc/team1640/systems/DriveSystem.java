package frc.team1640.systems;

import frc.team1640.robot.Controller;
import frc.team1640.robot.Controller.Axis;
import frc.team1640.robot.SwerveController;
import frc.team1640.robot.SwerveControllerImpl;
import frc.team1640.utilities.Vector2;
import frc.team1640.utilities.Vector2Impl;

public class DriveSystem implements ISystem {

	public static double DB_LJS = 0.2;
	public static double DB_RJS = 0.2;

	private Controller driverController;
	private SwerveController swerveController;

	private Vector2 leftJsDeadband;

	public DriveSystem () {
		driverController = Controller.getController(0);
		swerveController = new SwerveControllerImpl();

		leftJsDeadband = new Vector2Impl();
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
		swerveController.enable();
	}

	@Override
	public void teleopUpdate() {
		double x1 = driverController.getAxis(Axis.LX);
		double y1 = driverController.getAxis(Axis.LY);
		double x2 = driverController.getAxis(Axis.RX);

		leftJsDeadband.set(x1,y1);
		if (leftJsDeadband.magnitude() < DB_LJS) { leftJsDeadband.reset(); }
		else { leftJsDeadband.multiply(driveDeadbandCurve(leftJsDeadband.magnitude(), DB_LJS)); }

		if (x2 < DB_RJS) { x2 = 0.0; }

		swerveController.drive(leftJsDeadband.getX(), leftJsDeadband.getY(), x2);
	}

	@Override
	public void testInit() {
		disabledInit();
	}

	@Override
	public void testUpdate() {
		disabledUpdate();
	}

	private double driveDeadbandCurve (double mag, double db) {
		// y = f ( (mag-db) / (1-db) )
		double rescale = ( (mag-db) / (1-db) );
		return Math.pow(rescale,2);
	}

}