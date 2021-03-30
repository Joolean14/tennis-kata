
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1render = "";
    public String P2render = "";
    private String P1name;
    private String P2name;
    String score = "";

    public TennisGame2(String P1name, String P2name) {
        this.P1name = P1name;
        this.P2name = P2name;
    }

    public boolean checkIfTiedAndLessThanFour() {
        return P1point == P2point && P1point < 4;

    }

    public boolean checkIfDeuce() {
        return P1point == P2point && P1point >= 3;
    }

    public String getTiedScore() {
        if (P1point == 0)
            score = "Love";
        if (P1point == 1)
            score = "Fifteen";
        if (P1point == 2)
            score = "Thirty";
        score += "-All";
        return score;
    }

    public String P1LoveP2scores() {
        if (P1point > 0 && P2point == 0) {
            if (P1point == 1)
                P1render = "Fifteen";
            if (P1point == 2)
                P1render = "Thirty";
            if (P1point == 3)
                P1render = "Forty";

            P2render = "Love";
            score = P1render + "-" + P2render;
        }
        return score;
    }

    public String P2LoveP1Scores() {
        if (P2point > 0 && P1point == 0) {
            switch (P2point) {
                case 1:
                    P2render = "Fifteen";
                    break;
                case 2:
                    P2render = "Thirty";
                    break;
                case 3:
                    P2render = "Forty";
                    break;
            }

            P1render = "Love";
            score = P1render + "-" + P2render;
        }
        return score;
    }

    public String getScore() {
        if (checkIfTiedAndLessThanFour()) {
            getTiedScore();
        }
//        ==========================================================================
        if (checkIfDeuce())
            score = "Deuce";
//        ===========================================================================
        P1LoveP2scores();

        P2LoveP1Scores();


        if (P1point > P2point && P1point < 4) {
            if (P1point == 2)
                P1render = "Thirty";
            if (P1point == 3)
                P1render = "Forty";
            if (P2point == 1)
                P2render = "Fifteen";
            if (P2point == 2)
                P2render = "Thirty";
            score = P1render + "-" + P2render;
        }
        if (P2point > P1point && P2point < 4) {
            if (P2point == 2)
                P2render = "Thirty";
            if (P2point == 3)
                P2render = "Forty";
            if (P1point == 1)
                P1render = "Fifteen";
            if (P1point == 2)
                P1render = "Thirty";
            score = P1render + "-" + P2render;
        }
//        ========================================================================
//        
        checkAdvantage();
//        ============================================================================
//
        checkWinAfterDeuce();

//        ====================================================================
        return score;
    }

    public String checkAdvantage() {
        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }
        return score;
    }

    public String checkWinAfterDeuce() {
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;

    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}