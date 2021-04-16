package builder.gof.juice;

public class LemonJuiceBuilder extends JuiceBuilder { // ConcreteBuilder
    @Override
    public void setFruit() {
        this.juice.setType(Juice.JuiceType.Lemon);
    }
}
