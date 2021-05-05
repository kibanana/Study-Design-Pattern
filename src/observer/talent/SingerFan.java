package observer.talent;

public class SingerFan implements Fan {
    private String name;

    public SingerFan(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return name;
    }

    @Override
    public void hear(String voice) {
        System.out.println("팬 '" + name + "'은(는) 좋아하는 연예인에게 '" + voice + "'" + "를 들었습니다");
    }
}
