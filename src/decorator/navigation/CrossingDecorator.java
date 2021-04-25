package decorator.navigation;

public class CrossingDecorator extends DisplayDecorator { // 교차로 표시를 추가하는 클래스
    public CrossingDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void draw() {
        super.draw();
        drawCrossing();
    }

    private void drawCrossing() {
        System.out.println("\t교차로 표시");
    }
}
