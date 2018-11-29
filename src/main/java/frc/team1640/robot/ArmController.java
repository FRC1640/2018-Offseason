package frc.team1640.robot;

import edu.wpi.first.wpilibj.Solenoid;
import frc.team1640.robot.Arm.ArmPosition;

public class ArmController {

    double speed;
    Solenoid armBrake;
    OperatingMode operatingMode;
    ArmState armState;
    ArmPosition armTarget;

    public static enum OperatingMode {
		Manual,
        Managed;
    
    }

    public static enum ArmState {
        AT_TARGET,  
        TRANSITIONING;

    }

    public void IncreaseAngle() {
        int ord = armTarget.ordinal();
        

    }

}