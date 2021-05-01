package mediator.basic;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    List<IDestination> list = new ArrayList<IDestination>();

    public void addDestination(IDestination destination) {
        list.add(destination);
    }

    public void onEvent(String from, String event) {
        for (IDestination each : list) {
            each.receiveEvent(from, event);
        }
    }
}
