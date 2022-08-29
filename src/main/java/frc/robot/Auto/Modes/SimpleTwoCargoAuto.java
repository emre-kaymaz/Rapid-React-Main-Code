package frc.robot.Auto.Modes;

import java.util.Arrays;

import frc.robot.Auto.AutoModeEndedException;
import frc.robot.Auto.Action.*;

public class SimpleTwoCargoAuto extends AutoModeBase {
    @Override
    protected void routine() throws AutoModeEndedException {
        runAction(new SeriesAction(Arrays.asList(
                    new ParallelAction(Arrays.asList(
                        new DriveAction(1.5, 0.5, 0),
                        new IntakeAction(1)
                        )),
                    new SeriesAction(Arrays.asList(new DriveAction(-1.5, 0.5, 0),
                    new ParallelAction(Arrays.asList(
                    new ShooterAction(1),
                    new IntakeAction(1))
                ),
                new SeriesAction(Arrays.asList(new DriveAction(1.5, 0.5, 0),
                new StopAction()
            )))
        ))
    ));
    
    }
}