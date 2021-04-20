package factory_method.way1;

public class ElevatorController {
    private int id;
    private int currentFloor;

    public ElevatorController(int id) {
        this.id = id;
        currentFloor = 1;
    }

    public void gotoFloor(int destination) {
        System.out.println("Elevator [" + id + "] Floor: " + currentFloor + " => " + destination);

        // 현재 층 갱신, 즉 주어진 목적지 층(destination)으로 엘리베이터가 이동함
        currentFloor = destination;
    }
}
