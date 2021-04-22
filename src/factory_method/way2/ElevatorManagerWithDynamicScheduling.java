package factory_method.way2;

import java.util.Calendar;

public class ElevatorManagerWithDynamicScheduling extends ElevatorManager { // 동적 스케줄링 전략 하위 클래스
    public ElevatorManagerWithDynamicScheduling(int controllerCount) {
        super(controllerCount); // 상위 클래스 생성자 호출
    }

    // primitive 또는 hook 메서드 오버라이드
    @Override
    protected ElevatorScheduler getScheduler() {
        ElevatorScheduler scheduler = null;

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour < 12) // 오전: 대기 시간 최소화, 오후: 처리량 최대화
            scheduler = (ElevatorScheduler) ResponseTimeScheduler.getInstance();
        else
            scheduler = (ElevatorScheduler)ThroughputScheduler.getInstance();

        return scheduler;
    }
}
