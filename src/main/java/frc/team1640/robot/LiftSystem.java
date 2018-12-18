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
        arm = new Arm(11, 15, 6, 0, true, false, lift);
    }

    @Override
    public void statelessUpdate() {

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
        if (opController.getButton(Button.A)) {
			arm.setTarget(ArmPosition.Floor);
		}
		else if (opController.getButton(Button.B)) {
			arm.setTarget(ArmPosition.Switch);
        }
        else if (opController.getButton(Button.Y)) {
            arm.setTarget(ArmPosition.Switch);
        }
    }

    @Override
    public void testInit() {

    }

    @Override
    public void testUpdate() {

    }

}