package adapter.electronics;

public class Nintendo implements JapanElectronics {
    @Override
    public void use110v() {
        System.out.println("110v를 사용합니다!");
    }

    @Override
    public void electricPressure() {
        System.out.println("전압 110v");
    }
}
