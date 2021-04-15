package command;

public class RunOnCommand implements Command {
    private RunningMachine theRunnintMachine;

    public RunOnCommand(RunningMachine theRunnintMachine) {
        this.theRunnintMachine = theRunnintMachine;
    }

    @Override
    public void execute() {
        this.theRunnintMachine.turnOn();
    }
}
