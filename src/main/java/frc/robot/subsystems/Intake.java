package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import frc.robot.robot.Constants;

public class Intake {
    
    private static Intake mInstance = new Intake();
    
    public static Intake getInstance(){
        return mInstance;
    }
    
    public PWMSparkMax IntakeMotor;
    
    public Timer timer;
    
    public Intake(){
        IntakeMotor = new PWMSparkMax(Constants.intakeMotorPort);
        timer = new Timer();
    }
    
    public void IntakeRunForRotationClockwise(){
        IntakeMotor.set(1);
    }
    
    public void IntakeRunForRotationAntiClockwise(){
        IntakeMotor.set(-1);
    }
    
    public void IntakeStopAllMotors(){
        IntakeMotor.stopMotor();
    }
}