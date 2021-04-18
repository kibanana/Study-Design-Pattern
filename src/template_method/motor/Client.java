package template_method.motor;

// 엘레베이터 제어 시스템에서 모터를 구동시키는 기능
// 예를 들어 현대 모터를 이용하는 제어 시스템이라면 HyundaiMotor 클래스에 move 메서드를 정의할 수 있다.
// HyundaiMotor 클래스 -> Door 클래스: move 메서드를 실행할 때 안전을 위해 Door가 닫혀있는지 확인하기 위해 연관관계를 정의한다.
// Enumeration Interface - 모터의 상태(정지/이동), 문의 상태(열림/닫힘), 이동 방향(위/아래)

public class Client {
    public static void main(String[] args) {
        Door door1 = new Door();
        HyundaiMotor hyundaiMotor = new HyundaiMotor(door1);
        hyundaiMotor.move(Direction.DOWN);

        Door door2 = new Door();
        LGMotor lgMotor = new LGMotor(door2);
        lgMotor.move(Direction.UP);
    }
}
