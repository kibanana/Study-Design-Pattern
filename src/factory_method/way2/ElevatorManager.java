package factory_method.way1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// 이동 요청을 처리하는 클래스
// 엘리베이터를 스케줄링하기 위한 ThroughputScheduler 객체를 갖는다.
// 각 엘리베이터의 이동을 책임지는 ElevatorController 객체를 복수 개 갖는다.

public class ElevatorManager {
    private List<ElevatorController> controllers; // 엘리베이터 이동을 책임지는 ElevatorController

    public ElevatorManager(int controllerCount) {
        controllers = new ArrayList<ElevatorController>(controllerCount);
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i + 1); // 해결 1: i -> i + 1
            controllers.add(controller);
        }
    }

    // 1. 요청(목적지 층,방향)을 받았을 때 우선 ThroughputScheduler 클래스의 selectElevator() 메서드를 호출해 적절한 엘리베이터를 선택한다.
    // 2. 선택된 엘리베이터에 해당하는 ElevatorController 객체의 gotoFloor() 메서드를 호출해 엘리베이터를 이동시킨다.
    public void requestElevator(int destination, Direction direction) { // 요청에 따라 엘리베이터를 선택하고 이동시킴
        ElevatorScheduler scheduler;

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour < 12)
            scheduler = new ResponseTimeScheduler();
        else
            scheduler = new ThroughputScheduler();

        System.out.println(scheduler);

        int selectedElevator = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectedElevator).gotoFloor(destination);
    }
}

