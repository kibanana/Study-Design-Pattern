package builder.gof.juice;

public abstract class JuiceBuilder { // Builder
    protected  Juice juice;

    public Juice createJuice() {
        return this.juice;
    }

    public void prepareNewJuice() {
        this.juice = new Juice(); // 객체의 생성
    }

    public abstract void setFruit();
}
