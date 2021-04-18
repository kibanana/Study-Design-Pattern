package factory_method.headfirst;

public class NYStyleCheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("뉴욕스타일 치즈피자 준비~");
    }

    @Override
    public void bake() {
        System.out.println("뉴욕스타일 치즈피자 굽기~");
    }

    @Override
    public void box() {
        System.out.println("뉴욕스타일 치즈피자 포장하기~");
    }
}
