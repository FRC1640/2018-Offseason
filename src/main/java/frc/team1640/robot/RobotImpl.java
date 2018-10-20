package frc.team1640.robot;

import frc.team1640.robot.states.RobotState;

public class RobotImpl extends Robot {

	Controller controller;
	SwerveController swerveController;

	private static RobotState robotState;

	public static RobotState getState () {
		return robotState;
	}

	/**
	 * This method is called once when the robot first starts up. 
	 * Initialize anything that only needs to be setup once here.
	 */
	@Override
	public void robotInit () {
		// controller = new Controller(0);
		// swerveController = new SwerveControllerImpl();

		robotState = RobotState.DISABLED;
	}

	/**
	 * This method is called once when the robot first transitions to the disabled state
	 * from teleop, autonomous, or test.
	 */
	@Override
	public void disabledInit () {
		// swerveController.disable();
		robotState = RobotState.DISABLED;
		robotState.init();
	}

	/**
	 * This method is called once when the robot transitions to the autonomous state.
	 */
	@Override
	public void autonomousInit () {
		robotState = RobotState.AUTONOMOUS;
		robotState.init();
	}

	/**
	 * This method is called once when the robot transitions to the teleop state.
	 */
	@Override
	public void teleopInit () {
		// swerveController.enable();
		robotState = RobotState.TELEOP;
		robotState.init();
	}

	/**
	 * This method is called once when the robot transitions to the test state.
	 */
	@Override
	public void testInit () {
		robotState = RobotState.TEST;
		robotState.init();
	}
	
	/**
	 * This method is called every iteration, regardless of what state the robot is in, but at the end of every iteration
	 */
	public void robotPeriodic() {
		controller.update();
	}

	/**
	 * This method is called repeatedly while the robot is disabled.
	 */
	@Override
	public void disabledPeriodic () {
		robotState = RobotState.DISABLED;
		robotState.update();
	}
	
	/**
	 * This method is called repeatedly while the robot is in the autonomous state.
	 */
	@Override
	public void autonomousPeriodic () {
		robotState = RobotState.AUTONOMOUS;
		robotState.update();
	}

	/**
	 * This method is called repeatedly while the robot is in the teleop state.
	 */
	@Override
	public void teleopPeriodic () {
		robotState = RobotState.TELEOP;
		robotState.update();

		// try {
		// 	double x1 = controller.getAxis(Controller.Axis.LX);
		// 	double y1 = controller.getAxis(Controller.Axis.LY);
		// 	double x2 = controller.getAxis(Controller.Axis.RX);

		// 	swerveController.drive(x1, y1, x2);
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// }
	}

	/**
	 * This method is called repeatedly while the robot is in the test state.
	 */
	@Override
	public void testPeriodic () {
		robotState = RobotState.TEST;
		robotState.update();
	}
	
}