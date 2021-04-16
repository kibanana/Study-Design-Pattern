package builder.effective.pizza;

public class Pizza {
    private String bread;
    private String cheese;
    private Number pepperoni;
    private Number meat;
    private Number olive;
    private Number paprika;

    public Pizza(String bread, String cheese, Number pepperoni, Number meat, Number olive, Number paprika) {
        this.bread = bread;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.meat = meat;
        this.olive = olive;
        this.paprika = paprika;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "bread='" + bread + '\'' +
                ", cheese='" + cheese + '\'' +
                ", pepperoni=" + pepperoni +
                ", meat=" + meat +
                ", olive=" + olive +
                ", paprika=" + paprika +
                '}';
    }
}
