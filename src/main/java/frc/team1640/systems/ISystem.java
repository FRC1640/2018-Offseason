package frc.team1640.systems;

 public interface ISystem {

	public void statelessUpdate ();

	public void disabledInit ();

	public void disabledUpdate ();

	public void autonInit ();

	public void autonUpdate ();

	public void teleopInit ();

	public void teleopUpdate ();

	public void testInit ();

	public void testUpdate ();

}