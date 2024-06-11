package helpers;

public class PGN {
    private String pgn;
    

    public PGN(String pgn) {
        this.pgn = pgn;
    }

    public void setPGN(String pgn) {
        this.pgn = pgn;
    }

    public String getPGN() {
        return this.pgn;
    }

    public void parsePGN() {
        
    }

    public String getFormattedPGN() {
        if (pgn == null)
            return "";
        String regex = "(\\d+\\.)";
        return pgn.replaceAll(regex, "\n$1");
    }
}
