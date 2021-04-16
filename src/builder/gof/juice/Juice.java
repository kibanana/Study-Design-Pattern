package builder.gof.juice;

public class Juice { // Product
    public enum JuiceType {
        None,
        Lemon,
        Grape
    }

    public JuiceType type = JuiceType.None;

    public void setType(JuiceType type) {
        this.type = type;
    }
    public JuiceType getType() {
        return this.type;
    }
}
