package kmikusek.tabuvoice;

public interface Stateable<STATE extends AbstractState> {

    default void setState(STATE newState) {
        ((StateChangerProvider) this).provideStateChanger().setState(newState);
    }
}
