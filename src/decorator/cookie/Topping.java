package decorator.cookie;

public abstract class Topping implements CookieInterface { // 데코레이터 클래스
    @Override
    public abstract String getName();
}
