package observer.talent;

public interface Talent {
    public void addFan(Fan o);
    public void deleteFan(Fan o);
    public void speak(String sentence);
}
