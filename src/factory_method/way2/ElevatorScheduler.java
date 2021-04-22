package factory_method.way2;

public interface ElevatorScheduler {
    public int selectElevator(ElevatorManager manager, int destination, Direction direction);
}
