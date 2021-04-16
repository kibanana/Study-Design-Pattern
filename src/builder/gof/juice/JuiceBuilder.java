package builder.gof.juice;

public abstract class JuiceBuilder { // Builder
    protected  Juice juice;

    public Juice createJuice() {
        return this.juice;
    }

    public void prepareNewJuice() {
        this.juice = new Juice();
    }

    public abstract void setFruit();
}
