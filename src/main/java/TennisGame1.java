
public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    int tempScore = 0;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";

        if (tied()) {
            score = printTiedScores();
        } else if (checkIfScoreIsGreaterThanFour()) {
            score = handleDeuceAfterMath();
        } else {
            score = gameplay();
        }
        return score;
    }

    public boolean tied () {
        return player1Score == player2Score;
    }

    public String printTiedScores() {

        switch (player1Score) {
            case 0:
                return  "Love-All";
            case 1:
                return  "Fifteen-All";
            case 2:
                return  "Thirty-All";
            default:
                return "Deuce";
        }
    }

    public String handleDeuceAfterMath() {
        String score = "";

        if (getScoreDifference() == 1 || getScoreDifference() == -1) {
            score = advantage();
        } else {
            score = scoreDifference2();
        }
        return score;
    }


    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }



    public int getScoreDifference() {
        return player1Score - player2Score;
    }


    public String advantage() {
        String score = "";

        if (getScoreDifference() == 1) score = "Advantage player1";
        else if (getScoreDifference() == -1) score = "Advantage player2";
        return score;

    }

    public String scoreDifference2() {
        String score = "";

        if (getScoreDifference() >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }



    public String gameplay() {
        String score = "";

        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            score += printScoresText();
        }
        return score;
    }

    public String printScoresText() {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }

    }

    public boolean checkIfScoreIsGreaterThanFour() {
                return player1Score >= 4 || player2Score >= 4;
    }


}


