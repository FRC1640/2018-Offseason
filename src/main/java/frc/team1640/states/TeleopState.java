package frc.team1640.states;

public class TeleopState implements IControlState {

	private static TeleopState state = null;

	public static IControlState getInstance () {
		if (state == null) { state = new TeleopState(); }
		return state;
	}

	private TeleopState () {
		
	}

	public void init () {
		
	}

	public void update () {

	}

}