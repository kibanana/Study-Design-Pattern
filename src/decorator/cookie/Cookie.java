package decorator.cookie;

public class Cookie implements CookieInterface { // ConcreteComponent
    public String name;

    public Cookie(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
