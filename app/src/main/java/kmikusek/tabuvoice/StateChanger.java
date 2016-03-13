package kmikusek.tabuvoice;

@SuppressWarnings("PMD.GenericsNaming")
public class StateChanger<STATE extends AbstractState, STATE_CONTEXT> implements Stateable<STATE> {

    protected STATE currentState;

    protected STATE previousState;

    private final STATE_CONTEXT stateContext;

    public StateChanger(STATE_CONTEXT stateContext) {
        this.stateContext = stateContext;
    }

    @Override
    public void setState(STATE newState) {
//        Timber.d("Changing state from %s to %s", currentState, newState);
        this.previousState = this.currentState;
        if (previousState != null) {
            this.previousState.onStateLeaving(stateContext);
        }
        this.currentState = newState;
        this.currentState.onStateApplied(stateContext);
    }

    public STATE getCurrentState() {
        return this.currentState;
    }

    public STATE getPreviousState() {
        return this.previousState;
    }
}