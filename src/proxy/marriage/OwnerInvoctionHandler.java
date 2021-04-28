package proxy.marriage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 회원정보 당사자 프록시
public class OwnerInvoctionHandler implements InvocationHandler {
    PersonBean person;

    OwnerInvoctionHandler(PersonBean personBean) {
        this.person = personBean;
    }

    // 프록시에서 함수 호출 시 핸들러인 InvoctionHandler의 invoke 메서드 호출
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            }
            else if (method.getName().equals("setHotOrNotRating")) {
                System.out.println("IllegalAccessException");
                new IllegalAccessException();
            }
            else if (method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }
            else if (method.getName().equals("toString") == true) {
                System.out.println("Account{" +
                        "name='" + person.getName() + '\'' +
                        ", gender='" + person.getGender() + '\'' +
                        ", interest='" + person.getInterest() + '\'' +
                        ", rating=" + person.getHotOrNotRating() +
                        '}');
            }

        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}