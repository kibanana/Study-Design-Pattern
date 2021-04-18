package template_method.battle;

public abstract class Person {
    void readyToBattle() {
        startBodyTraining();
        prepareWeapon();
        prepareArmor();
        if (personWantsOther()) {
            prepareOther();
        }
    }

    final void startBodyTraining() { // 상속받은 클래스에서 수정할 수 없도록 final 키워드 붙임
        System.out.println("체력 단련하기");
    } // 공통의 일을 하는 메소드는 abstract 키워드를 붙이지 않음

    abstract void prepareWeapon();

    abstract void prepareArmor();

    boolean personWantsOther() { // 후킹(Hooking) 용도 메소드
        return false;
    }

    void prepareOther() {} // personWantsOther 값에 의해 오버라이드해서 사용함
}
