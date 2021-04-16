package builder.gof.juice;

public class Main {
    public static void main(String[] args) {
        JuiceMachine machine = new JuiceMachine();
        LemonJuiceBuilder lemonJuiceBuilder = new LemonJuiceBuilder();
        GrapeJuiceBuilder grapeJuiceBuilder = new GrapeJuiceBuilder();

        machine.setJuiceBuilder(lemonJuiceBuilder);
        machine.makeJuice();
        System.out.println(machine.getJuice().getType());

        machine.setJuiceBuilder(grapeJuiceBuilder);
        machine.makeJuice();
        System.out.println(machine.getJuice().getType());
    }
}
