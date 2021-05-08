package facade.movie;

public class Facade {
    private String beverage = "";
    private String movie = "";

    public Facade(String beverage, String movie) {
        this.beverage = beverage;
        this.movie = movie;
    }

    public void viewMovie() {
        RemoteControl rc = new RemoteControl();
        Beverage beverage = new Beverage(this.beverage);
        Movie movie = new Movie(this.movie);

        beverage.prepare();
        rc.turnOn();
        movie.searchMovie();
        movie.chargeMovie();
        movie.playMovie();
    }
}
