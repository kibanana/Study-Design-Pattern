package proxy.marriage;

public interface PersonBean {
    String getName();
    String getGender();
    String getInterest();
    int getHotOrNotRating();

    void setName(String name);
    void setGender(String gender);
    void setInterest(String interest);
    void setHotOrNotRating(int rating);
}

//    동적프록시의 경우는 Proxy클래스를 Java에서 만들어 주기 때문에 Proxy 클래스 내부를 직접 구현 할 수가 없습니다.
//        따라서, 무슨 일을 할지 알려주기 위한 방법이 필요합니다.
//        필요한 코드를 InvocationHandler를 implements 하여 InvocationHandler의 invoke() 메소드에
//        Proxy로 호출되는 모든 메소드에 대해 응답하는 역할을 맡도록 구현 후  Proxy.newProxyInstance의 파라메터로 넘겨줍니다.