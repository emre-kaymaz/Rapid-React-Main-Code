package frc.robot.Auto.Action;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Shooter;

public class ShooterAction implements Action {

    Shooter mShooter;
    double shooterOnTime;
    Timer timer;

    public ShooterAction(double shooterTime) {
        shooterOnTime = shooterTime;
        mShooter = Shooter.getInstance();
        timer = new Timer();
    }

    @Override
    public void start() {
        timer.reset();
        timer.start();
    }

    @Override
    public void update() {
        mShooter.shooterrRunForRotationClockwise();
    }

    @Override
    public boolean isFinished() {
        return timer.get() > shooterOnTime;
    }

    @Override
    public void done() {
        mShooter.shooterStopAllMotors();
    }
}