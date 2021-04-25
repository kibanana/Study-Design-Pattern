package decorator.navigation;

public class DisplayDecorator extends Display {
    private Display decoratedDisplay;

    public DisplayDecorator(Display decoratedDisplay) { // 합성(composition) 관계를 이용해 RoadDisplay 객체에 대한 참조
        this.decoratedDisplay = decoratedDisplay;
    }

    @Override
    public void draw() {
        decoratedDisplay.draw();
    }
}
