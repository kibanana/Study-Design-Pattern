package decorator.headfirst;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "하우스 블렌드 커피";
    }

    @Override
    public double getCost() {
        return 0.99;
    }
}
