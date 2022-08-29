package frc.robot.Auto.Action;

import frc.robot.subsystems.Drive;

public class StopAction implements Action{

    public Drive mDrive;

    @Override
    public void start(){
        mDrive = Drive.getInstance();
        mDrive.stopDrive();
    }

    @Override
    public void update(){
        mDrive.stopDrive();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
    
    @Override
    public void done(){
    }

}
