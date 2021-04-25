package decorator.navigation;

public class Client {
    public static void main(String[] args) {
        Display road = new RoadDisplay();
        road.draw();
        road = new LaneDecorator(road);
        road.draw();
        road = new TrafficDecorator(road);
        road.draw();
        road = new CrossingDecorator(road);
        road.draw();
    }
}
