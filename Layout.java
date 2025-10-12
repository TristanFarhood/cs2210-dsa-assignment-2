public class Layout {
    
    // instance variables for constructor
    private String boardLayout; // key 
    private int score; // value

    public Layout(String boardLayout, int score){ // class constructor 

        this.boardLayout = boardLayout;
        this.score = score;

    }

    // gettters and setters below for member variables

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
