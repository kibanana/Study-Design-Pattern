package template_method.motor;

public class HyundaiMotor extends Motor {
    public HyundaiMotor(Door door) {
        super(door);
    }

    @Override
    void moveMotor(Direction direction) {
        System.out.println("현대 모터로 엘레베이터가 " + direction + " !");
    }
}
