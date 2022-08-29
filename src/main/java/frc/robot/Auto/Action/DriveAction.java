package frc.robot.Auto.Action;

import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.Timer;

public class DriveAction implements Action{

    public Drive mDrive;
    public Timer timer;
    public double time;
    public double speed;
    public double rotation;

    public DriveAction(double wantedTime, double wantedSpeed, double wantedRotation){
        
        time = wantedTime;
        speed = wantedSpeed;
        rotation = wantedRotation;
        mDrive = Drive.getInstance();
        timer = new Timer();
        
    }

    @Override
    public void start() {
        timer.reset();
        timer.start();
    }

    @Override
    public void update() {
        mDrive.arcade(speed, rotation);
        
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= time;
    }

    @Override
    public void done() {
        mDrive.stopDrive();
    }
}

