package frc.team1640.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class RobotImpl extends Robot {

	Controller controller;
	SwerveController swerveController;

	/**
	 * This method is called once when the robot first starts up. 
	 * Initialize anything that only needs to be setup once here.
	 */
	@Override
	public void robotInit () {
		// TODO: Create a new controller object (port 0) and assign it to the controller variable
		// TODO: Create a new SwerveController and assign it to the swerve controller variable
		controller = new Controller(0);
		swerveController = new SwerveControllerImpl();
	}

	/**
	 * This method is called once when the robot first transitions to the disabled state
	 * from teleop, autonomous, or test.
	 */
	@Override
	public void disabledInit () {
		// TODO: Call disable() on the swerve controller object
		swerveController.disable();
	}

	/**
	 * This method is called once when the robot transitions to the autonomous state.
	 */
	@Override
	public void autonomousInit () {

	}

	/**
	 * This method is called once when the robot transitions to the teleop state.
	 */
	@Override
	public void teleopInit () {
		// TODO: Call enable() on the swerve controller object
		swerveController.enable();
	}

	/**
	 * This method is called once when the robot transitions to the test state.
	 */
	@Override
	public void testInit () {

	}
	
	/**
	 * This method is called every iteration, regardless of what state the robot is in, but at the end of every iteration
	 */
	public void robotPeriodic() {
		// TODO: Call update() on the controller object
		controller.update();
	}

	/**
	 * This method is called repeatedly while the robot is disabled.
	 */
	@Override
	public void disabledPeriodic () {

	}
	
	/**
	 * This method is called repeatedly while the robot is in the autonomous state.
	 */
	@Override
	public void autonomousPeriodic () {

	}

	/**
	 * This method is called repeatedly while the robot is in the teleop state.
	 */
	@Override
	public void teleopPeriodic () {
		try {
			// TODO: Get the value of the left x-axis and assign it to a double "x1"
			// TODO: Get the value of the left y-axis and assign it to a double "y1"
			// TODO: Get the value of the right x-axis and assign it to a double "x2"
			double x1 = controller.getAxis(Controller.Axis.LX);
			double y1 = controller.getAxis(Controller.Axis.LY);
			double x2 = controller.getAxis(Controller.Axis.RX);

			// TODO: Call drive on the swerve controller, passing in x1, y1, and x2
			swerveController.drive(x1, y1, x2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * This method is called repeatedly while the robot is in the test state.
	 */
	@Override
	public void testPeriodic () {

	}
	
}