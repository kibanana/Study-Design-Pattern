package factory_method.way2;

import java.util.ArrayList;
import java.util.List;

public abstract class ElevatorManager { // 템플릿 메서드를 정의하는 클래스: 하위 클래스에서 구현될 기능을 primitive 메서드로 정의
    private List<ElevatorController> controllers;

    public ElevatorManager(int controllerCount) {
        controllers = new ArrayList<ElevatorController>(controllerCount);
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i + 1);
            controllers.add(controller);
        }
    }
    protected abstract ElevatorScheduler getScheduler(); // 팩토리 메서드: 스케줄링 전략 객체를 생성하는 기능 제공

    void requestElevator(int destination, Direction direction) { // 템플릿 메서드: 요청에 따라 엘리베이터를 선택하고 이동시킴
        // 하위 클래스에서 오버라이드된 getScheduler() 메서드를 호출함 (변경)
        ElevatorScheduler scheduler = getScheduler(); // primitive 또는 hook 메서드
        System.out.println(scheduler);

        int selectedElevator = scheduler.selectElevator(this, destination, direction); // primitive 또는 hook 메서드로 받은 전략 사용
        controllers.get(selectedElevator).gotoFloor(destination);
    }
}