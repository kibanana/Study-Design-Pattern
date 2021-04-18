package template_method.beverage;

public class Tea extends CoffeineBeverage {
    public void brew() {
        System.out.println("차 우려내기");
    }
    public void addCondiments() {
        System.out.println("레몬 추가하기");
    }
}