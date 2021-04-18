package template_method.motor;

public class HyundaiMotor {
    private Door door;
    private MotorStatus motorStatus;

    public HyundaiMotor(Door door) {
        this.door = door;
    }

    private void moveHyundaiMotor(Direction direction) {
        // TODO: Hyundai Motor 구동
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    private void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public void move(Direction direction) { // 엘레베이터 제어
        MotorStatus motorStatus = getMotorStatus();
        if (motorStatus == MotorStatus.MOVING) return; // 이동 중이면 아무 작업 안함

        DoorStatus doorStatus = door.getDoorStatus();
        if (doorStatus == DoorStatus.OPENED) door.close(); // 문 상태가 '열림' 이면 닫음

        moveHyundaiMotor(direction); // 주어진 방향으로 이동함
        setMotorStatus(MotorStatus.MOVING); // 모터 상태를 '이동 중' 으로 변경함
    }
}
