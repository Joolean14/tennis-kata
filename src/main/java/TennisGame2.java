
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;
    public String P1text = "";
    public String P2text = "";
    private String P1name;
    private String P2name;
    String score = "";
    boolean tied = P1point == P2point;

    public String getScore() {
        if (checkIfTiedAndScoreLessThanFour()) {
            getTiedScores();
        }
        if (checkIfDeuce()) {
            score = "Deuce";
        }

        P1LoveP2leads();
        P2LoveP1Leads();

        handleAverageGameplayP1Leads();
        handleAverageGameplayP2Leads();

        handlePlayerAdvantage();
        handleDeuceAfterMath();

        return score;
    }

    public TennisGame2(String P1name, String P2name) {
        this.P1name = P1name;
        this.P2name = P2name;
    }

    public boolean checkIfTiedAndScoreLessThanFour() {
        return tied && P1point < 4;

    }

    public boolean checkIfDeuce() {
        return tied && P1point >= 3;
    }

    public String getTiedScores() {
        switch (P1point) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
        }
        return score += "-All";
    }

    public boolean checkIfP1LoveVSP2scores() {
        return P2point > 0 && P1point == 0;
    }

    public boolean checkIfP2LoveVSP1scores() {
        return P1point > 0 && P2point == 0;

    }

    public String P1LoveP2leads() {
        if (checkIfP2LoveVSP1scores()) {
            switch (P1point) {
                case 1:
                    P1text = "Fifteen";
                    break;
                case 2:
                    P1text = "Thirty";
                    break;
                case 3:
                    P1text = "Forty";
                    break;
            }

            P2text = "Love";
            score = P1text + "-" + P2text;
        }
        return score;
    }


    public String P2LoveP1Leads() {
        if (checkIfP1LoveVSP2scores()) {
            switch (P2point) {
                case 1:
                    P2text = "Fifteen";
                    break;
                case 2:
                    P2text = "Thirty";
                    break;
                case 3:
                    P2text = "Forty";
                    break;
            }

            P1text = "Love";
            score = P1text + "-" + P2text;
        }
        return score;
    }

    public String handleAverageGameplayP1Leads() {
        if (checkIfP1LeadsWithoutWinningSet()) {
            if (P1point == 2)
                P1text = "Thirty";
            if (P1point == 3)
                P1text = "Forty";
            if (P2point == 1)
                P2text = "Fifteen";
            if (P2point == 2)
                P2text = "Thirty";
            score = P1text + "-" + P2text;
        }
        return score;
    }

    public String handleAverageGameplayP2Leads() {
        if (checkIfP2LeadsWithoutWinningSet()) {
            if (P2point == 2)
                P2text = "Thirty";
            if (P2point == 3)
                P2text = "Forty";
            if (P1point == 1)
                P1text = "Fifteen";
            if (P1point == 2)
                P1text = "Thirty";
            score = P1text + "-" + P2text;
        }
        return score;
    }

    public boolean checkIfP1LeadsWithoutWinningSet() {
        return P1point > P2point && P1point < 4;
    }

    public boolean checkIfP2LeadsWithoutWinningSet() {
        return P2point > P1point && P2point < 4;
    }

    public String handlePlayerAdvantage() {
        if (checkP1Advantage()) {
            score = "Advantage player1";
        }

        if (checkP2Advantage()) {
            score = "Advantage player2";
        }
        return score;
    }

    public boolean checkP1Advantage() {
        return P1point > P2point && P2point >= 3;
    }

    public boolean checkP2Advantage() {
        return P2point > P1point && P1point >= 3;
    }


    public boolean P1LeadsByMoreThanTwo() {
        return (P1point - P2point) >= 2;
    }

    public boolean P2LeadsByMoreThanTwo() {
        return (P2point - P1point) >= 2;
    }

    public boolean P1winsDeuce() {
        return P1point >= 4 && P2point >= 0 && P1LeadsByMoreThanTwo();
    }

    public boolean P2winsDeuce() {
        return P2point >= 4 && P1point >= 0 && P2LeadsByMoreThanTwo();
    }


    public String handleDeuceAfterMath() {
        if (P1winsDeuce()) {
            score = "Win for player1";
        }
        if (P2winsDeuce()) {
            score = "Win for player2";
        }
        return score;

    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }
}