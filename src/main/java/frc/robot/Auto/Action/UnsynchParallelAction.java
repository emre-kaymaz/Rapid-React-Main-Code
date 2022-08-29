package frc.robot.Auto.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnsynchParallelAction implements Action {
    private final ArrayList<Action> mActions;

    public UnsynchParallelAction(List<Action> actions) {
        mActions = new ArrayList<>(actions);
    }

    public UnsynchParallelAction(Action... actions) {
        this(Arrays.asList(actions));
    }

    @Override
    public void start() {
        mActions.forEach(Action::start);
    }

    @Override
    public void update() {
        for (Action currentAction:mActions){
            if (!currentAction.isFinished()){
                currentAction.update();
            }
            else{
                currentAction.done();
            }
        }
    }

    @Override
    public boolean isFinished() {
        for (Action action : mActions) {
            if (!action.isFinished()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void done() {
        mActions.forEach(Action::done);
    }
}
