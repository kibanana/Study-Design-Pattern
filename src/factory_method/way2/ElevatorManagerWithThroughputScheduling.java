package factory_method.way2;

public class ElevatorManagerWithThroughputScheduling extends ElevatorManager { // 처리량 최대화 전략 하위 클래스
    ElevatorManagerWithThroughputScheduling(int controllerCount) {
        super(controllerCount); // 상위 클래스 생성자 호출
    }

    // primitive 또는 hook 메서드 오버라이드
    @Override
    protected ElevatorScheduler getScheduler() {
        ElevatorScheduler scheduler = (ElevatorScheduler) ThroughputScheduler.getInstance();
        return scheduler;
    }
}
