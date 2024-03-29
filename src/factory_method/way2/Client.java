package factory_method.way2;

public class Client {
    public static void main(String[] args) {
        ElevatorManager emWithResponseTimeScheduler = new ElevatorManagerWithThroughputScheduling(2);
        emWithResponseTimeScheduler.requestElevator(10, Direction.UP);

        ElevatorManager emWithThroughputScheduler = new ElevatorManagerWithResponseTimeScheduling(2);
        emWithThroughputScheduler.requestElevator(10, Direction.UP);

        ElevatorManager emWithDynamicScheduler = new ElevatorManagerWithDynamicScheduling(2);
        emWithDynamicScheduler.requestElevator(10, Direction.UP);
    }
}
