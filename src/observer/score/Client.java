package observer.score;

public class Client {
    public static void main(String args[]) {
        ScoreRecord scoreRecord = new ScoreRecord();
        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 5);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.attach(dataSheetView);
        scoreRecord.attach(minMaxView);

        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("Adding: " + score);
            scoreRecord.addScore(score);
        }
    }
}
