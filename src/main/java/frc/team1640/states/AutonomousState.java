package frc.team1640.states;

public class AutonomousState implements IControlState {

	private static AutonomousState state = null;

	public static IControlState getInstance () {
		if (state == null) { state = new AutonomousState(); }
		return state;
	}

	private AutonomousState () {

	}

	public void init () {

	}

	public void update () {

	}

}