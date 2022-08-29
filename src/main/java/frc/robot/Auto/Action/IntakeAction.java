package frc.robot.Auto.Action;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Intake;

public class IntakeAction implements Action {

    Intake mIntake;
    double intakeOnTime;
    Timer timer;

    public IntakeAction(double intakeTime) {
        intakeOnTime = intakeTime;
        mIntake = Intake.getInstance();
        timer = new Timer();
    }

    @Override
    public void start() {
        timer.reset();
        timer.start();
    }

    @Override
    public void update() {
        mIntake.IntakeRunForRotationClockwise();
    }

    @Override
    public boolean isFinished() {
        return timer.get() > intakeOnTime;
    }

    @Override
    public void done() {
        mIntake.IntakeStopAllMotors();
    }

}
