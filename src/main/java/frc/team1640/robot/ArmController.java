package frc.team1640.robot;

import edu.wpi.first.wpilibj.Solenoid;
import frc.team1640.robot.Arm.ArmPosition;
import frc.team1640.robot.Controller;

public class ArmController {

    private Controller armController; 

    public boolean armController (Controller armController) {
        if (armController.controller.getAButton()) {
			Arm.setPreset(ArmPosition.Floor);
		}
		else if (armController.controller.getBButton()) {
			Arm.setPreset(ArmPosition.Switch);
        }
        else if (armController.controller.getYButton()) {
            Arm.setPreset(ArmPosition.Switch);
        }


    // double speed;
    // Solenoid armBrake;
    // OperatingMode operatingMode;
    // ArmState armState;
    // ArmPosition armTarget;

    // public static enum OperatingMode {
	// 	Manual,
    //     Managed;
    
    // }

    // public static enum ArmState {
    //     AT_TARGET,  
    //     TRANSITIONING;

    // }

    // public void IncreaseAngle() {
    //     int ord = armTarget.ordinal();
        

    // }

}