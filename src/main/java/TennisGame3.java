
public class TennisGame3 implements TennisGame {

    private int p2points;
    private int p1points;
    private String p1text;
    private String p2text;
    String score;
    String[] pointNames = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String p1text, String p2text) {
        this.p1text = p1text;
        this.p2text = p2text;
    }

    public String getScore() {
        if (checkIfNotDeuce()) {
            score = pointNames[p1points];
            return checkIfTied();
        } else {
            if (tied())
                return "Deuce";
            score = playerOnTheLead();
            return handleDeuceAftermath();
        }
    }

    public String playerOnTheLead() {
        return p1points > p2points ? p1text : p2text;
    }

    public boolean tied () {
        return p1points == p2points;
    }

    public boolean deuce() {
        return p1points + p2points == 6;
    }

    public boolean checkIfNotDeuce() {
        return playerScoreUnderFour() && !deuce();
    }

    public boolean playerScoreUnderFour() {
        return p1points < 4 && p2points < 4;
    }

    public String checkIfTied() {
        return (p1points == p2points) ? score + "-All" : score + "-" + pointNames[p2points];
    }

    public String handleDeuceAftermath() {
        return (scoreDifference()) ? "Advantage " + score : "Win for " + score;
    }

    public boolean scoreDifference() {
        return (p1points - p2points) * (p1points - p2points) == 1;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1points += 1;
        else
            this.p2points += 1;

    }

}
