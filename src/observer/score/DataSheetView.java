package observer.score;

import java.util.List;

public class DataSheetView implements Observer {
    private ScoreRecord scoreRecord;
    private int viewCount;

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    @Override
    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord();
        displayScores(record, viewCount);
    }

    private void displayScores(List<Integer> record, int viewCount) {
        System.out.println("보여줄 레코드 개수: " + viewCount);
        for (int i = 0; i < viewCount && i < record.size(); i++) {
            System.out.println(i + ", " + record.get(i));
        }
        System.out.println();
    }
}
