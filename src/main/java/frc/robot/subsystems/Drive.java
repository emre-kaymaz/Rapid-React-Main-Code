package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.robot.Constants;

public class Drive {

    private static Drive mInstance = new Drive();

    public static Drive getInstance(){
        return mInstance;
    }

    public VictorSP leftOne;
    public VictorSP leftTwo;

    public VictorSP rightOne;
    public VictorSP rightTwo;
    public TalonSRX rightThree;

    public MotorControllerGroup left;
    public MotorControllerGroup right;

    public DifferentialDrive chassis;

    public Drive(){
        leftOne = new VictorSP(Constants.driveOneLeftMotorPort);
        leftTwo = new VictorSP(Constants.driveTwoLeftMotorPort);
        
        rightOne = new VictorSP(Constants.driveOneRightMotorPort);
        rightTwo = new VictorSP(Constants.driveTwoRightMotorPort);
        rightThree = new TalonSRX(6);
        
        rightOne.setInverted(false);
        rightTwo.setInverted(false);

        left = new MotorControllerGroup(leftOne,leftTwo);
        right = new MotorControllerGroup(rightOne,rightTwo);

        chassis = new DifferentialDrive(left, right);
    }

    public void arcade(double speed , double rotation){
        chassis.arcadeDrive(speed, rotation);
    }
    public void stop(){
        chassis.tankDrive(0, 0);
    }
    public void getInverts(){
        System.out.println(leftOne.getInverted());
    }
    
    public void stopDrive(){
        chassis.stopMotor();
    }

    rightThree.

}
