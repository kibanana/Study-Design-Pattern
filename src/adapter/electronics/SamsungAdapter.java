package adapter.electronics;

public class SamsungAdapter implements JapanElectronics {
    Samsung samsung;

    public SamsungAdapter(Samsung samsung) {
        this.samsung = samsung;
    }

    @Override
    public void use110v() {
        System.out.println("삼성 어댑터 사용!(110v -> 220v)");
        samsung.use220v();
    }

    @Override
    public void electricPressure() {
        System.out.println("삼성 어댑터 사용!(110v -> 220v)");
        samsung.electricPressure();
    }
}
