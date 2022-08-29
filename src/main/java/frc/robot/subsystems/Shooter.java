package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import frc.robot.robot.Constants;

public class Shooter {

    private static Shooter mInstance = new Shooter();

    public PWMSparkMax shooterMotor;
        
    public static Shooter getInstance() {
        return mInstance;
    }

    private Shooter() {
        shooterMotor = new PWMSparkMax(Constants.dropMotorPort);
    }

    public void shooterrRunForRotationClockwise() {
        shooterMotor.set(-1);
    }

    public void shooterRunForRotationAntiClockwise() {
        shooterMotor.set(1);
    }

    public void shooterStopAllMotors() {
        shooterMotor.set(0);
    }

}
