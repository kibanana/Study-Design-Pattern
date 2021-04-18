package template_method.beverage;

public class Coffee extends CoffeineBeverage {
    public void brew() {
        System.out.println("커피 우려내기");
    }
    public void addCondiments() {
        System.out.println("설탕과 우유 추가하기");
    }
}