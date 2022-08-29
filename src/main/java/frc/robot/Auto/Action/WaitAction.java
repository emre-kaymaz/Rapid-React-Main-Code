package frc.robot.Auto.Action;

import edu.wpi.first.wpilibj.Timer;

public class WaitAction implements Action{

    double _time;
    Timer timer;

    @Override
    public void done() {
    }

    public WaitAction(double time){
        _time = time;
        timer = new Timer();
    }

    @Override
    public boolean isFinished() {
        return timer.get() > _time;
    }

    @Override
    public void start() {
        timer.reset();
        timer.start();
    }

    @Override
    public void update() {
    }
    
}
