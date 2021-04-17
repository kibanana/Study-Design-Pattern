package decorator.cookie;

public class Main {
    public static void main(String[] args) {
        CookieInterface milkCookie1 = new Cookie("우유 쿠키");
        CookieInterface milkCookie2 = new RandomColorTopping((Cookie) new Cookie("우유 쿠키"));
        CookieInterface milkCookie3 = new RandomAbilityTopping((Cookie) new Cookie("우유 쿠키"));
        CookieInterface milkCookie4 = new RandomColorTopping((Cookie) new Cookie("우유 쿠키"));
        CookieInterface herbCookie1 = new Cookie("허브 쿠키");
        CookieInterface herbCookie2 = new RandomAbilityTopping((Cookie) new Cookie("허브 쿠키"));
        CookieInterface espressoCookie1 = new Cookie("에스프레소 쿠키");
        CookieInterface espressoCookie2 = new RandomAbilityTopping((Cookie) new Cookie("에스프레소 쿠키"));

        System.out.println(milkCookie1.getName());
        System.out.println(milkCookie2.getName());
        System.out.println(milkCookie3.getName());
        System.out.println(milkCookie4.getName());
        System.out.println(herbCookie1.getName());
        System.out.println(herbCookie2.getName());
        System.out.println(espressoCookie1.getName());
        System.out.println(espressoCookie2.getName());
    }
}