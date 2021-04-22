package factory_method.way2;

public class ThroughputScheduler implements ElevatorScheduler { // 엘리베이터 작업 처리량을 최대화시키는 전략 클래스, 해결 2: 싱글톤 패턴
    private static ElevatorScheduler scheduler; // 생성자 private으로 정의
    private ThroughputScheduler() {}

    public static ElevatorScheduler getInstance() { // 정적 메서드로 객체 생성을 구현 (싱글턴 패턴)
        if(scheduler == null)
            scheduler = (ElevatorScheduler) new ThroughputScheduler();
        return scheduler;
    }
    public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
        return 0;
    }
}
