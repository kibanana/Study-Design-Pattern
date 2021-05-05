package observer.talent;

import observer.score.Observer;

import java.util.ArrayList;

public class Singer implements Talent {
    private ArrayList<Fan> fans;

    public Singer() {
        fans = new ArrayList<Fan>();
    }

    @Override
    public void addFan(Fan o) {
        fans.add(o);
    }

    @Override
    public void deleteFan(Fan o) {
        if (fans.indexOf(o) <= 0) {
            fans.remove(0);
        }
    }

    @Override
    public void speak(String sentence) {
        for (Fan o : fans) {
            o.hear(sentence);
        }
    }
}
