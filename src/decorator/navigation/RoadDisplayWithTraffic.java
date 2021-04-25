package decorator.navigation;

public class RoadDisplayWithTraffic extends RoadDisplay { // 기본 도로 표시 + 교통량 표시 클래스
    public void draw() {
        super.draw();
        drawTraffic(); // 추가적으로 교통량 표시
    }

    private void drawTraffic() {
        System.out.println("교통량 표시");
    }
}
