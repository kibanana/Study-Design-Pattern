package template_method.battle;

public class Archer extends Person {

    @Override
    void prepareWeapon() {
        System.out.println("활을 손질하고 챙김");
    }

    @Override
    void prepareArmor() {}

    @Override
    boolean personWantsOther() {
        return true;
    }

    @Override
    void prepareOther() {
        System.out.println("화살통에 화살을 챙김");
    }
}
