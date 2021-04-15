package command;

public class Client {
    public static void main(String[] args) {
        RunningMachine runningMachine = new RunningMachine();
        Command runOnCommand = new RunOnCommand(runningMachine);

        WalkingMachine walkingMachine = new WalkingMachine();
        Command walkOnCommand = new WalkOnCommand(walkingMachine);

        Button runButton = new Button(runOnCommand);
        runButton.pressed();

        Button walkButton = new Button(walkOnCommand);
        walkButton.pressed();

        walkButton.setCommand(runOnCommand);
        walkButton.pressed();
    }
}
