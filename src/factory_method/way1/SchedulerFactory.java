package factory_method.way1;

import java.util.Calendar;

public class SchedulerFactory { // 해결 2: 스케줄링 전략에 맞는 객체를 생성하기 위한 팩토리
    public static ElevatorScheduler getScheduler(SchedulingStrategyId strategyId) {
        ElevatorScheduler scheduler = null; // 해결 1: ElevatorScheduler 인터페이스

        switch (strategyId) {
            case RESPONSE_TIME: // 대기 시간 최소화 전략
                scheduler = ResponseTimeScheduler.getInstance(); // 해결 2
                break;
            case THROUGHPUT: // 처리량 최대화 전략
                scheduler = ThroughputScheduler.getInstance();
                break;
            case DYNAMIC: // 동적 스케줄링
                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                // 동적 스케줄링 방식
                if (hour < 12)
                    scheduler = ResponseTimeScheduler.getInstance();
                else
                    scheduler = ThroughputScheduler.getInstance();
                break;
        }

        return scheduler;
    }
}
