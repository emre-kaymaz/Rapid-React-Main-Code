package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import frc.robot.robot.Constants;

public class Gamepad {

    private static Gamepad mInstance = new Gamepad();

    public static Gamepad getInstance(){
        return mInstance;
    }

    public XboxController gamepad;

    public Gamepad() {
        gamepad = new XboxController(Constants.gamepadJoystick);
    }

    public double getForward() {
        return gamepad.getRawAxis(3);
    }

    public double getReverse() {
        return gamepad.getRawAxis(2);
    }

    public double getSteering() {
        return gamepad.getRawAxis(0);
    }

    public double getSensetiveSteering() {
        return gamepad.getRawAxis(3);
    }

    public boolean getIntakeGamepad(){
        return gamepad.getRawButton(6);
    }

    public boolean getIntakeReverseGamepad(){
        return gamepad.getRawButton(5);
    }

    public boolean getDropperGamepad(){
        return gamepad.getRawButton(3);
    }
    
    public boolean getDroppperReverseGamepad(){
        return gamepad.getRawButton(4);
    }

    public boolean getConveyorGameapad(){
        return gamepad.getRawButton(1);
    }
    
    public boolean getConveyorReverseGameapad(){
        return gamepad.getRawButton(2);
    }

    public int getReleaseClimberGamepad(){
        return gamepad.getPOV(0);
    }

    public int getReleaseSlowlyClimberGamepad(){
        return gamepad.getPOV(90);
    }

    public int getReleaseHangingGamepad(){
        return gamepad.getPOV(180);
    }

    public int getClimbGamepad(){
        return gamepad.getPOV(270);
    }

    public void forceFeedback(double speed, double rotation) {
        double leftRotation;
        double rightRotation;
        if (rotation < 0) {
            leftRotation = 0.5 * (Math.abs(rotation) + speed);
            rightRotation = 0.5 * (Math.abs(speed));
        } else {
            leftRotation = 0.5 * Math.abs(speed);
            rightRotation = 0.5 * (Math.abs(rotation) + speed);
        }
        gamepad.setRumble(RumbleType.kLeftRumble, leftRotation);
        gamepad.setRumble(RumbleType.kRightRumble, rightRotation);
    }

   
}