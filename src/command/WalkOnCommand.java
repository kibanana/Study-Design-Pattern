package command;

public class WalkOnCommand implements Command {
    private WalkingMachine theWalkingMachine;

    public WalkOnCommand(WalkingMachine theWalkingMachine) {
        this.theWalkingMachine = theWalkingMachine;
    }

    @Override
    public void execute() {
        this.theWalkingMachine.turnOn();
    }
}
