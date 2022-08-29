package frc.robot.Auto.Action;

public interface Action {

    void start();

    void update();

    boolean isFinished();

    void done();
    
}
