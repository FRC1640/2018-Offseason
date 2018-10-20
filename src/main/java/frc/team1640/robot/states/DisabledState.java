package frc.team1640.robot.states;

public class DisabledState implements IControlState {

	private static DisabledState state = null;

	public static IControlState getInstance () {
		if (state == null) { state = new DisabledState(); }
		return state;
	}

	private DisabledState () {
		
	}

	public void init () {
		
	}

	public void update () {

	}

}