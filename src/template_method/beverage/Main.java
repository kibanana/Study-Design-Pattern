package template_method.beverage;

public class Main {
    public static void main(String[] args) {
        Coffee coffee1 = new Coffee();
        Tea tea1 = new Tea();

        coffee1.prepareRecipe();
        System.out.println("=====");
        tea1.prepareRecipe();
    }
}
