package proxy.marriage;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        PersonBean person1 = new Account();
        PersonBean person2 = new Account();

        // 프록시는 PersonBean인터페이스를 전달 받기 때문에  ownerProxy.setName("홍길동") 과 같이 PersonBean 의 메소드를 그대로 쓸 수 있습니다.
        PersonBean ownerProxy = main.getOwnerProxy(person1);
        ownerProxy.setName("A");
        ownerProxy.setGender("F");
        ownerProxy.setInterest("Reading a book");
//        ownerProxy.setHotOrNotRating(10); // ownerProxy 이기 때문에 실제 실행이 안되는 것을 볼 수 있다.
        ownerProxy.toString();

        PersonBean nonOwnProxy = main.getNonOwnerProxy(person2);
//        nonOwnProxy.setName("B");  // nonOwnProxy 이기 때문에 setName은  실행이 안되는 것을 볼 수 있다.
        nonOwnProxy.toString();
    }

    PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvoctionHandler(person));
    }

    PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvoctionHandler(person));
    }
}
