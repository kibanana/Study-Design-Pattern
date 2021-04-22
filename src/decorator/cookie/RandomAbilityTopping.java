package decorator.cookie;

import java.util.List;
import java.util.Random;

public class RandomAbilityTopping extends Topping {
    protected CookieInterface cookie;

    public RandomAbilityTopping(CookieInterface cookie) {
        this.cookie = cookie;
    }

    public enum AbilityType {
        HEAL,
        MAGIC,
        RUSH,
        DEFENSE,
        ARROW,
        SHOOT
    }

    private static final List<AbilityType> VALUES = List.of(AbilityType.values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static AbilityType randomAbility()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    @Override
    public String getName() {
        return "★" + randomAbility() + "★ " + cookie.getName();
    }
}