package template_method.battle;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Archer archer = new Archer();
        Wizard wizard = new Wizard();

        warrior.readyToBattle();

        System.out.println("=====");

        archer.readyToBattle();

        System.out.println("=====");

        wizard.readyToBattle();
    }
}
