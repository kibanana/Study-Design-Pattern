package proxy.marriage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 결혼정보회사 이용자용 프록시
public class NonOwnerInvoctionHandler implements InvocationHandler {
    PersonBean person;

    public  NonOwnerInvoctionHandler(PersonBean person) {
        this.person = person;
    }

    // 프록시에서 함수 호출 시 핸들러인 InvoctionHandler의 invoke 메서드 호출
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if (method.getName().startsWith("get") == true) {
                return method.invoke(person, args);
            }
            else if (method.getName().equals("setHotOrNotRating") == true) {
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
            else {
                System.out.println("IllegalAccessException");
                return new IllegalAccessException();
            }
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}