package builder.gof.juice;

public class JuiceMachine {
    private JuiceBuilder juiceBuilder;

    public void setJuiceBuilder(JuiceBuilder builder) {
        this.juiceBuilder = builder;
    }

    public void makeJuice() {
        juiceBuilder.prepareNewJuice();
        juiceBuilder.setFruit();
    }

    public Juice getJuice() {
        return juiceBuilder.createJuice();
    }
}
