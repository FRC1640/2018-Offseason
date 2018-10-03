package frc.team1640.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;

public class Controller {

    public static enum Button {
        A, B, X, Y, LB, RB, LT, RT, START, SELECT, LJ, RJ, N, E, S, W, NE, SE, SW, NW;
    }

    public static enum Axis {
        LX, LY, RX, RY, LT, RT;
    }

    private XboxController controller;
    private HashMap<Button,Boolean> prevButtonMap;

    public Controller (int port) {
        controller = new XboxController(port);
        prevButtonMap = new HashMap<Button,Boolean>();
    }

    public void update () {
        for (Button button : Button.values()) {
            prevButtonMap.put(button,getButton(button));
        }
    }

    public boolean getButton (Button button) {
        switch (button) {
            case A: return controller.getAButton();
            case B: return controller.getBButton();
            case X: return controller.getXButton();
            case Y: return controller.getYButton();
            case LB: return controller.getBumper(Hand.kLeft);
            case RB: return controller.getBumper(Hand.kRight);
            case LT: return controller.getTriggerAxis(Hand.kLeft) > 0.05;
            case RT: return controller.getTriggerAxis(Hand.kRight) > 0.05;
            case START: return controller.getStartButton();
            case SELECT: return controller.getBackButton();
            case LJ: return controller.getStickButton(Hand.kLeft);
            case RJ: return controller.getStickButton(Hand.kRight);
            case N: return controller.getPOV() == 0;
            case E: return controller.getPOV() == 90;
            case S: return controller.getPOV() == 180;
            case W: return controller.getPOV() == 270;
            case NE: return controller.getPOV() == 45;
            case SE: return controller.getPOV() == 135;
            case SW: return controller.getPOV() == 225;
            case NW: return controller.getPOV() == 315;
            default: return false;
        }
    }

    public boolean getButtonPressed (Button button) {
        return getButton(button) && !prevButtonMap.get(button);
    }

    public boolean getButtonReleased (Button button) {
        return !getButton(button) && prevButtonMap.get(button);
    }

	// TODO: Deadbands... here? elsewhere?
    public double getAxis (Axis axis) {
        switch (axis) {
            case LX: return controller.getX(Hand.kLeft);
            case LY: return controller.getY(Hand.kRight);
            case RX: return controller.getX(Hand.kLeft);
            case RY: return controller.getY(Hand.kRight);
            case LT: return controller.getTriggerAxis(Hand.kLeft);
            case RT: return controller.getTriggerAxis(Hand.kRight);
            default: return 0.0;
        }
    }

    public int getPOV () {
        return controller.getPOV();
    }

}