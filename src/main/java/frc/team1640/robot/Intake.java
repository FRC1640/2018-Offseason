package main.java.frc.team1640.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

public class Intake {

    private Solenoid solenoidClose;
    private Solenoid solenoidOpen;
    private WPI_TalonSRX leftMotor;
    private WPI_TalonSRX rightMotor;

    private boolean enable;

    public Intake(int solenoidCloseChannel, int solenoidOpenChannel, int leftMotorChannel, int rightMotorChannel) {
        solenoidClose = new Solenoid(solenoidCloseChannel);
        solenoidOpen = new Solenoid(solenoidOpenChannel);
        leftMotor = new WPI_TalonSRX(leftMotorChannel);
        rightMotor = new WPI_TalonSRX(rightMotorChannel);

        leftMotor.setNeutralMode(NeutralMode.Brake);
        rightMotor.setNeutralMode(NeutralMode.Brake);
    }

    public boolean getSolenoidOpenState() {
        return solenoidOpen.get();
    }

    private void operateSolenoid(boolean solenoidState) {
        if (enable) {
            solenoidOpen.set(solenoidState);
            solenoidClose.set(!solenoidState);
        }
    }

    public void openIntake() {
        operateSolenoid(true);
    }

    public void closeIntake() {
        operateSolenoid(false);
    }

    public void driveMotors(double motorSpeed) {
        if (enable) {
            leftMotor.set(motorSpeed);
            rightMotor.set(-motorSpeed);
        }
    }

    public double getLeftMotorCurrent() {
        return leftMotor.getOutputCurrent();
    }

    public double getRightMotorCurrent() {
        return rightMotor.getOutputCurrent();
    }

    public void enable() {
        enable = true;
    }

    public void disable() {
        enable = false;
    }
}