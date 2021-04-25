package decorator.navigation;

public class LaneDecorator extends DisplayDecorator { // 차선 표시를 추가하는 클래스
    public LaneDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void draw() {
        super.draw(); // 기존 표시 기능 수행
        drawLane(); // 추가적으로 차선 표시
    }

    public void drawLane() {
        System.out.println("\t차선 표시");
    }
}
