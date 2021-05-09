package template_method.beverage;

public abstract class CoffeineBeverage {
    // 템플릿 메소드: 알고리즘을 가지고 있다
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customWantsCondiments()) { // personWantsOther -> hook operation
            addCondiments(); // -> prepareOther
        }

        // prepareOther 메서드가 훅 메서드(= 훅 연산, 필요하다면 서브클래스에서 확장할 수 있는 기본적인 행동을 제공하는 메서드)다. 그리고 personWantsOther 메서드는 훅 메서드를 후킹하는 역할만 한다.
    }

    abstract void brew(); // 서브클래스에서 구현
    abstract void addCondiments(); // 서브클래스에서 구현

    protected void boilWater() {
        System.out.println("물 끓이기");
    }

    protected void pourInCup() {
        System.out.println("컵에 따르기");
    }

    boolean customWantsCondiments() {
        return false;
    }
}