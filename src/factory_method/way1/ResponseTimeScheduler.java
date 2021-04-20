package factory_method.way1;

public class ResponseTimeScheduler implements ElevatorScheduler { // 해결 2: 싱글톤 패턴
    private static ElevatorScheduler scheduler; // 생성자 private으로 정의
    private ResponseTimeScheduler() {}

    public static ElevatorScheduler getInstance() { // 정적 메서드로 객체 생성을 구현 (싱글턴 패턴)
        if (scheduler == null)
            scheduler = (ElevatorScheduler) new ResponseTimeScheduler();
        return scheduler;
    }
    public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
        return 1;
    }
}
