package mediator.basic;

public class Client {
    public static void main(String args[]) {

        // 복잡한 관계를 단순화하기 위해서는 소스와 수신자를 동일화시킬 필요가 있다.
        // 소스 측은 ISource 인터페이스를 통해 구현, 수신자 측은 IDestination 인터페이스를 통해 구현하도록 한다.
        // 그리고 각각 2개씩 구체클래스를 만든다.

        // 소스는 setMediator() 메서드를 통해 외부로부터 Mediator 객체를 주입받는다.
        // 그리고 이벤트가 발생하면 Mediator 객체의 onEvent() 메서드를 호출하여 자신에게 발생한 이벤트를 전달하도록 한다.

        // IDestination을 구현한 수신자 객체는 생성된 후 Mediator 객체에 자신을 등록한다. 이를 통해 Mediator 객체가 이벤트 발생 시 이벤트를 전달할 수신자를 알 수 있다.

        Mediator mediator = new Mediator();

        ISource tcp = new TcpCommunication();
        ISource system = new SystemSignal();

        tcp.setMediator(mediator);
        system.setMediator(mediator);

        mediator.addDestination(new Display());
        mediator.addDestination(new Log());

        tcp.occurEvent("[TCP]connected");
        tcp.occurEvent("[TCP]send_message");

        system.occurEvent("[SYSTEM]input_keyboard");
        system.occurEvent("[SYSTEM]input_headphone");
    }
}
