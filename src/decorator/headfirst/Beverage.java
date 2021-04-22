package decorator.headfirst;

abstract class Beverage {
    String description = "제목 없음";

    public String getDescription() {
        return description;
    }

    public abstract double getCost();

    @Override
    public String toString() {
        return getDescription() + ": $" + getCost();
    }
}