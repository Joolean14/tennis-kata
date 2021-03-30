
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1render;
    private String p2render;
        String score;
            String[] pointNames = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String p1render, String p2render) {
        this.p1render = p1render;
        this.p2render = p2render;
    }

    public String getScore() {
        if (checkDeuce()) {
            score = pointNames[p1];
            return tieOrDiff();
        } else {
            if (p1 == p2)
                return "Deuce";
            score = p1 > p2 ? p1render : p2render;
            return advantageOrWin();
        }
    }

    public String tieOrDiff() {
        return (p1 == p2) ? score + "-All" : score + "-" + pointNames[p2];
    }

    public String advantageOrWin() {
        return ((p1-p2)*(p1-p2) == 1) ? "Advantage " + score : "Win for " + score;
    }

    public boolean checkDeuce() {
       return p1 < 4 && p2 < 4 && !(p1 + p2 == 6);
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
