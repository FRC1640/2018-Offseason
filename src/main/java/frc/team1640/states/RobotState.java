package frc.team1640.states;

public enum RobotState {

	DISABLED (DisabledState.getInstance()),
	AUTONOMOUS (AutonomousState.getInstance()),
	TELEOP (TeleopState.getInstance()),
	TEST (DisabledState.getInstance());

	private IControlState state = null;

	RobotState (IControlState cs) {
		state = cs;
	}

	public void init () {
		state.init();
	}

	public void update () {
		state.update();
	}
}