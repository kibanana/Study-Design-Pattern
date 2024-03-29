package decorator.cookie;

import java.util.List;
import java.util.Random;

public class RandomColorTopping extends Topping { // Concrete Decorator B
    protected CookieInterface cookie;

    public RandomColorTopping(CookieInterface cookie) {
        this.cookie = cookie;
    }

    public enum ColorType {
        NONE,
        REDDISH_BROWN,
        BROWN,
        RED,
        DARK_RED,
        GREY,
        BLACK,
        PURPLE,
        GREEN,
        SKY_BLUE
    }

    private static final List<ColorType> VALUES = List.of(ColorType.values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ColorType randomColor() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    @Override
    public String getName() {
        System.out.println("색상 추가중~");
        return "♥" + randomColor() + "♥ " + cookie.getName();
    }
}
