package kmikusek.tabuvoice;

@SuppressWarnings("PMD.GenericsNaming")
public class AbstractState<STATE_CONTEXT> {

    protected STATE_CONTEXT stateContext;

    public void onStateLeaving(STATE_CONTEXT stateContext) {
        this.stateContext = stateContext;
    }

    public void onStateApplied(STATE_CONTEXT stateContext) {
        this.stateContext = stateContext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
