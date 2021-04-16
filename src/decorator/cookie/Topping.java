package decorator.cookie;

public abstract class Topping implements CookieInterface { // 데코레이터 클래스
    protected Cookie cookie;

    public Topping(Cookie cookie) {
        this.cookie = cookie;
    }

    @Override
    public abstract String getName();
}
