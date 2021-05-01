package mediator.basic;

public interface ISource {
    public void setMediator(Mediator mediator);
    public void occurEvent(String event);
}
