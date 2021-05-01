package mediator.basic;

public interface IDestination {
    public void receiveEvent(String from, String event);
}
