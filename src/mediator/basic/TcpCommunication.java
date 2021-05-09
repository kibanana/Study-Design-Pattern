package mediator.basic;

public class TcpCommunication implements ISource { // 이벤트 발생자
    Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void occurEvent(String event) {
        mediator.onEvent("TCP communication", event);
    }
}
