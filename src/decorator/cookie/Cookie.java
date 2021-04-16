package decorator.cookie;

public class Cookie implements CookieInterface {
    public String name;

    public Cookie(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
