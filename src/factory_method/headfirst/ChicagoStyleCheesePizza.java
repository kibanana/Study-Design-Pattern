package factory_method.headfirst;

public class ChicagoStyleCheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("시카고스타일 치즈 준비~");
    }

    @Override
    public void bake() {
        System.out.println("시카고스타일 치즈 굽기~");
    }

    @Override
    public void box() {
        System.out.println("시카고스타일 치즈 포장하기~");
    }
}
