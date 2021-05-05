package observer.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord {
    private List<Integer> scores = new ArrayList<Integer>();
    private DataSheetView dataSheetView;

    public void setDataSheetView(DataSheetView dataSheetView) {
        this.dataSheetView = dataSheetView;
    }

    public void addScore(int score) { // 새로운 점수를 추가하면 출력하는 클래스의 객체에 변화를 통보해서 출력하는 부분 갱신
        scores.add(score); // scores 목록에 주어진 점수를 추가함
        dataSheetView.update(); // scores 목록이 변경되었음을 통보함
    }

    public List<Integer> getScoreRecord() {
        return scores;
    }
}
