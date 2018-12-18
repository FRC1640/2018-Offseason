package frc.team1640.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.IterativeRobot;
import frc.team1640.states.RobotState;
import frc.team1640.systems.DriveSystem;
import frc.team1640.systems.ISystem;

public class Robot extends IterativeRobot {

	public ArrayList<ISystem> systemList;

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
		robotState = RobotState.DISABLED;

		systemList = new ArrayList<ISystem>();
		systemList.add(new LiftSystem());
		systemList.add(new DriveSystem());
	}

	/**
	 * This method is called once when the robot first transitions to the disabled state
	 * from teleop, autonomous, or test.
	 */
	@Override
	public void disabledInit () {
		robotState = RobotState.DISABLED;
		for (ISystem sys : systemList) { sys.disabledInit(); }
		
	}

	/**
	 * This method is called once when the robot transitions to the autonomous state.
	 */
	@Override
	public void autonomousInit () {
		robotState = RobotState.AUTONOMOUS;
		for (ISystem sys : systemList) { sys.autonInit(); }
	}

	/**
	 * This method is called once when the robot transitions to the teleop state.
	 */
	@Override
	public void teleopInit () {
		// swerveController.enable();
		robotState = RobotState.TELEOP;
		for (ISystem sys : systemList) { sys.teleopInit(); }
	}

	/**
	 * This method is called once when the robot transitions to the test state.
	 */
	@Override
	public void testInit () {
		robotState = RobotState.TEST;
		for (ISystem sys : systemList) { sys.testInit(); }
	}
	
	/**
	 * This method is called every iteration, regardless of what state the robot is in, but at the end of every iteration
	 */
	public void robotPeriodic() {
		for (ISystem sys : systemList) { sys.statelessUpdate(); }
		Controller.updateAllControllers();
	}

	/**
	 * This method is called repeatedly while the robot is disabled.
	 */
	@Override
	public void disabledPeriodic () {
		robotState = RobotState.DISABLED;
		for (ISystem sys : systemList) { sys.disabledUpdate(); }
	}
	
	/**
	 * This method is called repeatedly while the robot is in the autonomous state.
	 */
	@Override
	public void autonomousPeriodic () {
		robotState = RobotState.AUTONOMOUS;
		for (ISystem sys : systemList) { sys.autonUpdate(); }
	}

	/**
	 * This method is called repeatedly while the robot is in the teleop state.
	 */
	@Override
	public void teleopPeriodic () {
		robotState = RobotState.TELEOP;
		for (ISystem sys : systemList) { sys.teleopUpdate(); }
	}

	/**
	 * This method is called repeatedly while the robot is in the test state.
	 */
	@Override
	public void testPeriodic () {
		robotState = RobotState.TEST;
		for (ISystem sys : systemList) { sys.testUpdate(); }
	}
	
}