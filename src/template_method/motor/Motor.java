package template_method.motor;

// 방법1
// 현대 모터만 사용 및 제어하는 경우는 괜찮다. 하지만 만약 LG 모터를 구동시켜야 한다면?
// 만약 현대 모터와 LG 모터 클래스를 각각 따로 만든다면 2개의 클래스는 많은 중복 코드를 가지게 된다.
// ex) Door 클래스와의 연관관계(1), motorStatus 필드(2), getMotorStatus 메서드(3), setMotorStatus 메서드(4)
// 중복 코드는 유지보수성을 약화시키므로 바람직하지 않다.
// -> 상속을 이용해서 코드 중복 문제를 피할 수 있다.

// 방법2
// 여전히 move 메서드가 부분적으로 중복된다. 이 경우에도 상속을 이용해 코드 중복 문제를 피할 수 있다.
// Motor 클래스의 move 메서드는 HyundaiMotor와 LGMotor에서 동일한 기능을 구현하면서 각 하위 클래스에서 구체적으로 정의할 필요가 있는 부분, 즉 moveMotor 메서드 부분만 각 하위 클래스에서 오버라이드되도록 한다.
// 이렇게 Template Method 패턴을 이용하면 전체적으로는 동일하면서 부분적으로는 다른 구문으로 구성된 메서드의 코드 중복을 최소화할 수 있다.

public abstract class Motor {
    protected Door door;
    private MotorStatus motorStatus; // 2

    public Motor(Door door) { // 1
        this.door = door;
        motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() { // 3
        return motorStatus;
    }

    protected void setMotorStatus(MotorStatus motorStatus) { // 4
        this.motorStatus = motorStatus;
    }

    abstract void moveMotor(Direction direction);

    public void move(Direction direction) { // 엘레베이터 제어 -> 템플릿 메서드
        MotorStatus motorStatus = getMotorStatus();
        if (motorStatus == MotorStatus.MOVING) return; // 이동 중이면 아무 작업 안함

        DoorStatus doorStatus = door.getDoorStatus();
        if (doorStatus == DoorStatus.OPENED) door.close(); // 문 상태가 '열림' 이면 닫음

        moveMotor(direction); // 주어진 방향으로 이동함
        setMotorStatus(MotorStatus.MOVING); // 모터 상태를 '이동 중' 으로 변경함
    }
}
