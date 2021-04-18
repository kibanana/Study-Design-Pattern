package factory_method.headfirst;

public class NYStylePepperoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("뉴욕스타일 페페로니 준비~");
    }

    @Override
    public void bake() {
        System.out.println("뉴욕스타일 페페로니 굽기~");
    }

    @Override
    public void box() {
        System.out.println("뉴욕스타일 페페로니 포장하기~");
    }
}
