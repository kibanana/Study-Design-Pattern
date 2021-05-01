package mediator.basic;

public class SystemSignal implements ISource {
    Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void occurEvent(String event) {
        mediator.onEvent("System", event);
    }
}
