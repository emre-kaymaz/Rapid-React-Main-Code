package frc.robot.Auto.Modes;

import java.util.Arrays;

import frc.robot.Auto.AutoModeEndedException;
import frc.robot.Auto.Action.*;

public class SimpleOneCargoAuto extends AutoModeBase {

    @Override
    protected void routine() throws AutoModeEndedException {
        runAction(new SeriesAction(Arrays.asList(
                    new ParallelAction(Arrays.asList(
                        new ShooterAction(3),
                        new IntakeAction(3)
                        )),
                    new SeriesAction(Arrays.asList(
                        new WaitAction(1.5),
                        new DriveAction(0.10, 0.10, 0)
                    )),
                    new SeriesAction(Arrays.asList(
                new StopAction())
        ))));
    }
}