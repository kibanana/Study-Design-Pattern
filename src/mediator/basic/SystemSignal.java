package mediator.basic;

public class SystemSignal implements ISource { // 이벤트 발생자
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
