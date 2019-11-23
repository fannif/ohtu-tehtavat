package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score++;
        } else if (playerName.equals(player2Name)) {
            player2Score++;
        }
    }
    
    public boolean hasWon() {
        if (player1Score > 3 && player1Score - player2Score > 1) {
            return true;
        }
        if (player2Score > 3 && player2Score - player1Score > 1) {
            return true;
        }
        return false;
    }
    
    public String higherScore() {
        if (player2Score > player1Score) {
            return "player2";
        } else if (player1Score > player2Score) {
            return "player1";
        }
        return "tie";
    }
    
    public boolean advantage() {
        if (player1Score>=4 || player2Score>=4) {
            if (Math.abs(player1Score - player2Score) == 1) {
                return true;
            }
        }    
        return false;        
    }
    
    public boolean deuce() {
        if (player1Score > 3 && player1Score == player2Score) {
            return true;
        }
        return false;
    }
    
    public String scoreString(int score) {
        if (score == 0) {
            return "Love";
        }
        if (score == 1) {
            return "Fifteen";
        }
        if (score == 2) {
            return "Thirty";
        }
        if (score == 3) {
            return "Forty";
        }
        return "Score not possible";
    }
    
    public String getScore() {
        
        if (hasWon()) {
            return "Win for " + higherScore();
        }
        
        if (advantage()) {
            return "Advantage " + higherScore();
        }
        
        if (deuce()) {
            return "Deuce";
        }
        
        if (player1Score==player2Score) {
            return scoreString(player1Score) + "-All";
            
        }

        return scoreString(player1Score) + "-" + scoreString(player2Score);
    }
}