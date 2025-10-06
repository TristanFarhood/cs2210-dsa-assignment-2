public class Layout {
    
    // instance variables for constructor
    private String boardLayout;
    private int score;

    public Layout(String boardLayout, int score){ // class constructor 

        this.boardLayout = boardLayout;
        this.score = score;

    }

    public String getBoardLayout() {
        return boardLayout;
    }

    public void setBoardLayout(String boardLayout) {
        this.boardLayout = boardLayout;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    

    

}
