package facade.movie;

public class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public void searchMovie() {
        System.out.println("영화 찾기: " + name);
    }

    public void chargeMovie() {
        System.out.println("영화 결제하기");
    }

    public void playMovie() {
        System.out.println("영화 재생하기");
    }
}
