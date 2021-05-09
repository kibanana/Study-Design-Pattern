package adapter.electronics;

public class Samsung implements KoreanElectronics {
    @Override
    public void use220v() {
        System.out.println("220v를 사용합니다!");
    }

    @Override
    public void electricPressure() {
        System.out.println("전압 220v");
    }
}
