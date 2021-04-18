package factory_method.java;

public class PointCard extends Product {
    private String owner;

    public PointCard(String owner) {
        System.out.println(owner + "님의 포인트카드를 생성합니다.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner + "님의 포인트카드를 사용합니다.");
    }

    public String getOwner() {
        return owner;
    }
}
