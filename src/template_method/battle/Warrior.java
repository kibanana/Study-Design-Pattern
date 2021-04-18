package template_method.battle;

public class Warrior extends Person {

    @Override
    void prepareWeapon() {
        System.out.println("검을 닦고 챙김");
    }

    @Override
    void prepareArmor() {
        System.out.println("갑옷을 입음");
    }
}
