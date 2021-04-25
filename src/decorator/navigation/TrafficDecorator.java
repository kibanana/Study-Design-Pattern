package decorator.navigation;

public class TrafficDecorator extends DisplayDecorator {
    TrafficDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void draw() {
        super.draw(); // 기존 표시 기능 수행
        drawTraffic(); // 추가적으로 교통량 표시
    }

    public void drawTraffic() {
        System.out.println("\t교통량 표시");
    }
}
