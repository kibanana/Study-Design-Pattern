package decorator.cookie;

import java.util.List;
import java.util.Random;

public class RandomAbilityTopping extends Topping { // Concrete Decorator A
    protected CookieInterface cookie;

    public RandomAbilityTopping(CookieInterface cookie) {
        this.cookie = cookie;
    }

    public enum AbilityType {
        HEAL, // 회복형
        MAGIC, // 마법형
        RUSH, // 돌격형
        DEFENSE, // 방어형
        ARROW, // 사격형
        SHOOT // 총기형
    }

    private static final List<AbilityType> VALUES = List.of(AbilityType.values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static AbilityType randomAbility()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    @Override
    public String getName() {
        System.out.println("능력 추가중~");
        return "★" + randomAbility() + "★ " + cookie.getName();
    }
}