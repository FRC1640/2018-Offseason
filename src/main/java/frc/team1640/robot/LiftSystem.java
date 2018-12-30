package frc.team1640.robot;

import frc.team1640.systems.ISystem;
import frc.team1640.robot.Arm.ArmPosition;
import frc.team1640.robot.Controller.Button;

public class LiftSystem implements ISystem {

    private Controller opController;
    private Arm arm;
    private Lift lift;

    public LiftSystem() {
        opController = Controller.getController(1);
        lift = new Lift(true, false);
        arm = new Arm(11, 15, 4, 0, true, false, lift);
    }

    @Override
    public void statelessUpdate() {
        arm.update();
        // lift.update();
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledUpdate() {

    }

    @Override
    public void autonInit() {

    }

    @Override
    public void autonUpdate() {

    }

    @Override
    public void teleopInit() {
    
    }

    @Override
    public void teleopUpdate() {
        if (opController.getButtonPressed(Button.A)) {
            arm.setTarget(ArmPosition.Floor);
		}
		else if (opController.getButtonPressed(Button.B)) {
			arm.setTarget(ArmPosition.Switch);
        }
        else if (opController.getButtonPressed(Button.Y)) {
            arm.setTarget(ArmPosition.Start);
        }

        if(opController.getButtonPressed(Button.X)) {
            arm.toggleBrake();
        }

        if (opController.getButtonPressed(Button.N)) {
            lift.raiseTarget();
        }

        if (opController.getButtonPressed(Button.S)) {
            lift.lowerTarget();
        }
    }

    @Override
    public void testInit() {

    }

    @Override
    public void testUpdate() {

    }

}