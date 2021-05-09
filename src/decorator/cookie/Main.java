package decorator.cookie;

public class Main {
    public static void main(String[] args) {
        CookieInterface milkCookie1 = new Cookie("우유 쿠키");
        CookieInterface milkCookie2 = new RandomColorTopping(new Cookie("우유 쿠키"));
        CookieInterface milkCookie3 = new RandomAbilityTopping( new Cookie("우유 쿠키"));
        CookieInterface milkCookie4 = new RandomAbilityTopping(new RandomColorTopping(new Cookie("우유 쿠키")));
//        1) Ability -> ★HEAL★
//        2) (1) + Color -> ★HEAL★ ♥PURPLE♥
//        3) (2) + 우유 쿠키 -> ★HEAL★ ♥PURPLE♥ 우유 쿠키

//        milkCookie4 = new RandomAbilityTopping(new Cookie("우유 쿠키"));
//        milkCookie4 = new RandomColorTopping(milkCookie4);
        CookieInterface herbCookie1 = new Cookie("허브 쿠키");
        CookieInterface herbCookie2 = new RandomAbilityTopping(new Cookie("허브 쿠키"));
        CookieInterface espressoCookie1 = new Cookie("에스프레소 쿠키");
        CookieInterface espressoCookie2 = new RandomAbilityTopping(new Cookie("에스프레소 쿠키"));

        System.out.println(milkCookie1.getName());
        System.out.println(milkCookie2.getName());
        System.out.println(milkCookie3.getName());
        System.out.println(milkCookie4.getName());  // (CookieInterface) -> 내부 -> 외부 순으로 getName() 에 접근하기 때문에 맨 처음에 능력(색상(CookieInterface)) 순으로 호출했다면 이름은 색상 능력 CookieInterface's name 이다
        System.out.println(herbCookie1.getName());
        System.out.println(herbCookie2.getName());
        System.out.println(espressoCookie1.getName());
        System.out.println(espressoCookie2.getName());
    }
}