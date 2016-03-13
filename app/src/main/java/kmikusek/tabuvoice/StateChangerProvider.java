package kmikusek.tabuvoice;

public interface StateChangerProvider<STATE extends AbstractState, STATE_CONTEXT> {

    StateChanger<STATE, STATE_CONTEXT> provideStateChanger();
}