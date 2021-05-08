package facade.movie;

public class Client {
    public static void main(String args[]) {
        // Client 입장에서는 Facade 객체에서 제공하는 doSomething() 메서드를 호출함으로써 복잡한 서브클래스 사용이 간편해짐

        Facade facade = new Facade("콜라", "아무거나");
        facade.viewMovie();
    }
}
