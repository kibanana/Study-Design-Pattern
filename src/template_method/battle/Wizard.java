package template_method.battle;

public class Wizard extends Person {

    @Override
    void prepareWeapon() {
        System.out.println("마법 지팡이를 준비함");
    }

    @Override
    void prepareArmor() {
        System.out.println("로브를 입음");
    }
}
