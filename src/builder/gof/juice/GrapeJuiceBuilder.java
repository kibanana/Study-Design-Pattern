package builder.gof.juice;

public class GrapeJuiceBuilder extends JuiceBuilder { // ConcreteBuilder
    @Override
    public void setFruit() {
        this.juice.setType(Juice.JuiceType.Grape);
    }
}
