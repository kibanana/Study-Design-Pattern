package decorator.cookie;

public abstract class Topping implements CookieInterface { // Decorator
    @Override
    public abstract String getName();
}
