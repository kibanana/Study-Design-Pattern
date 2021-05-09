package adapter.electronics;

public class Client {
    public static void main(String args[]) {
        Samsung s = new Samsung();
        Nintendo n = new Nintendo();
        JapanElectronics jButS = new SamsungAdapter(new Samsung());

        s.use220v();
        s.electricPressure();

        n.use110v();
        n.electricPressure();

        jButS.use110v();
        jButS.electricPressure();
    }
}
