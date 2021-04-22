package factory_method.way2;

public class ElevatorManagerWithResponseTimeScheduling extends ElevatorManager { // 대기 시간 최소화 전략 하위 클래스
    public ElevatorManagerWithResponseTimeScheduling(int controllerCount) {
        super(controllerCount); // 상위 클래스 생성자 호출
    }

    // primitive 또는 hook 메서드 오버라이드
    @Override
    protected ElevatorScheduler getScheduler() {
        ElevatorScheduler scheduler = (ElevatorScheduler) ResponseTimeScheduler.getInstance();
        return scheduler;
    }
}
