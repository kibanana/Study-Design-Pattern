package builder.gof.juice;

public class Juice { // Product
    public enum JuiceType {
        None,
        Lemon,
        Grape
    }

    public JuiceType type = JuiceType.None; // 객체의 표현ㄴ

    public void setType(JuiceType type) {
        this.type = type;
    }
    public JuiceType getType() {
        return this.type;
    }
}
