package template_method.motor;

public class LGMotor extends Motor {
    public LGMotor(Door door) {
        super(door);
    }

    @Override
    void moveMotor(Direction direction) {
        System.out.println("LG 모터로 엘레베이터가 " + direction + " !");
    }
}
