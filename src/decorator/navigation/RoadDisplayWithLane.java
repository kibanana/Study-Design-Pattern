package decorator.navigation;

public class RoadDisplayWithLane extends RoadDisplay {
    public void draw() {
        super.draw(); // 상위(RoadDisplay) 클래스의 draw 메서드를 호출해서 기본 도로 표시
        drawLane(); // 추가 차선 표시
    }

    private void drawLane() {
        System.out.println("차선 표시");
    }
}
