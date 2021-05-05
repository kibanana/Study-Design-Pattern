package observer.talent;

public class Client {
    public static void main(String[] args) {
        Singer firstSinger = new Singer();
        SingerFan person1 = new SingerFan("김");
        SingerFan person2 = new SingerFan("이");

        firstSinger.addFan(person1);
        firstSinger.addFan(person2);

        firstSinger.speak("저를 사랑해주시는 팬분들 언제나 사랑합니다~");

        firstSinger.deleteFan(person2);

        SingerFan person3 = new SingerFan("박");
        firstSinger.addFan(person3);

        firstSinger.speak("저 컴백해요!");
    }
}
