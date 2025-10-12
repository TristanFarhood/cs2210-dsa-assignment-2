import java.util.LinkedList;

public class Board implements BoardADT {

    // initialize fields for constructor
    public int board_size; 
    public char[][] theBoard;  


    public Board (int board_size, int empty_positions, int max_levels){ // class constructor
        this.board_size = board_size; 
        this.theBoard = new char[board_size][board_size]; 

        // fill the board with 'E' (empty)
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                this.theBoard[i][j] = 'E';
            }
        }
    }


    // hashdictionary method of type HashDictionary 
    public HashDictionary makeDictionary(){
        HashDictionary hash_Dictionary = new HashDictionary(board_size); // instantiate an object of HashDictionary that takes board size as parameter
        return hash_Dictionary; 
    }


    private String contentOf2dArray (){ // private helper method to convert game board to String
        String contentOf2dArray = ""; // empty string to hold contents of the array in RRBBEEBB... format

        for (int row = 0; row < theBoard.length; row++) { 
            for (int col = 0; col < theBoard[row].length; col++) { 
                contentOf2dArray = contentOf2dArray + String.valueOf(theBoard[row][col]); 
            }
        }

        return contentOf2dArray;
    }


    public int repeatedLayout(HashDictionary dict){
        // refined simplified version uses dict.get instead of manual scanning
        String contentOf2dArray = this.contentOf2dArray(); 
        return dict.get(contentOf2dArray); 
    }


    public void storeLayout(HashDictionary dict, int score){
        String contentOf2dArray = this.contentOf2dArray(); // String variable invoking methos above with this.
        Layout LayoutObject = new Layout(contentOf2dArray, score); 
        
        try { 
            dict.put(LayoutObject); 
        } catch(DictionaryException e){
            // just ignore if it already exists * the assignment allows this *
        }
    }


    public void saveTile(int row, int col, char symbol){ 
        theBoard[row][col] = symbol; 
    }


    public boolean positionIsEmpty (int row, int col){
        if(theBoard[row][col] == 'E'){
            return true;
        }
        return false; 
    }


    public boolean isComputerTile (int row, int col){
        if(theBoard[row][col] == 'R'){
            return true;
        }
        return false; 
    }


    public boolean isHumanTile (int row, int col){
        if(theBoard[row][col] == 'B'){
            return true;
        }
        return false; 
    }


    private String diagonal() { // helper diagonal method 
        if (this.theBoard == null || this.theBoard.length == 0) {
            return "";
        }
        StringBuilder diagonalString = new StringBuilder();
        for (int i = 0; i < this.theBoard.length; i++) {
            diagonalString.append(this.theBoard[i][i]);
        }
        return diagonalString.toString();
    }



    // winner method by checking columns and rows then calls helped method above to check diagonal
    public boolean winner (char symbol){
        boolean won = false; 

        // check columns
        for (int col = 0; col < theBoard[0].length; col++) { 
            String eachColumns = "";
            for (int row = 0; row < theBoard.length; row++) { 
                eachColumns = eachColumns + String.valueOf(theBoard[row][col]);
            }
            
            boolean eachColumnBoolean = false;
            char firstChar = eachColumns.charAt(0);

            if(firstChar == symbol){
                eachColumnBoolean = true;
                for (int i = 1; i < eachColumns.length(); i++) {
                    if (eachColumns.charAt(i) != firstChar) {
                       eachColumnBoolean = false; 
                    }
                }
            }
            
            if (eachColumnBoolean == true){
                return true; 
            }    
        }

        // check rows
        for (int row = 0; row < theBoard.length; row++) { 
            String eachRows = ""; 
            for (int col = 0; col < theBoard[row].length; col++) { 
                eachRows = eachRows + String.valueOf(theBoard[row][col]);
            }
            
            boolean eachRowBoolean = false;
            char firstChar = eachRows.charAt(0);

            if(firstChar == symbol){
                eachRowBoolean = true;
                for (int i = 1; i < eachRows.length(); i++) {
                    if (eachRows.charAt(i) != firstChar) {
                       eachRowBoolean = false; 
                    }
                }
            }
            
            if (eachRowBoolean == true){
                return true; 
            }  
        }

        // check both diagonals 
        boolean diagonal1 = true;
        boolean diagonal2 = true;

        for (int i = 0; i < theBoard.length; i++) {
            if (theBoard[i][i] != symbol) diagonal1 = false;
            if (theBoard[i][theBoard.length - 1 - i] != symbol) diagonal2 = false;
        }

        if (diagonal1 || diagonal2) {
            return true;
        }

        return won;
    }


    // helper for adjacency check 
    private boolean hasAdjacent(int row, int col, char symbol) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && j >= 0 && i < board_size && j < board_size) {
                    if (theBoard[i][j] == symbol) return true;
                }
            }
        }
        return false;
    }


    public boolean isDraw(char symbol, int empty_positions){
        if(winner('R') || winner('B')){ 
            return false;
        }

        int emptyCount = 0;
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if (theBoard[i][j] == 'E') emptyCount++;
            }
        }

        if(empty_positions == 0 && emptyCount == 0){
            return true; 
        }

        if (empty_positions > 0 && emptyCount == empty_positions) {
            for (int i = 0; i < board_size; i++) {
                for (int j = 0; j < board_size; j++) {
                    if (theBoard[i][j] == 'E' && hasAdjacent(i, j, symbol)) {
                        return false;
                    }
                }
            }
            return true;
        }

        return false; 
    }


    // evaluate method 
    public int evaluate(char symbol, int empty_positions){
        if(winner('R')){
            return 3;
        }
        if(winner('B')){
            return 0;
        }
        if (isDraw(symbol, empty_positions)) {
            return 2;
        }

        return 1; 
    }

}
