import java.util.LinkedList;

public class Board implements BoardADT {

    // initialize fields for constructor
    public int board_size; 
    public char[][] theBoard;  


    public Board (int board_size, int empty_positions, int max_levels){ // Class constructor

        this.board_size = board_size; 

    }



    public HashDictionary makeDictionary(){

        HashDictionary hash_Dictionary = new HashDictionary(board_size); 

        return hash_Dictionary; 
    }


    /*This method first represents the content of the 2-dimensional array theBoard as a String s as described in Section 2.1; then it
    checks whether there is a data item in the dictionary referenced by dict with key s: If there is
    such a data item, this method returns the associated score; otherwise it returns the value -1. */

    private String contentOf2dArray (){ // private method to convert game board to String
        String contentOf2dArray = ""; 

        for (int col = 0; col < theBoard[0].length; col++) { // Outer loop iterates through columns
            for (int row = 0; row < theBoard.length; row++) { // Inner loop iterates through rows
                contentOf2dArray = contentOf2dArray + String.valueOf(theBoard[row][col]); 
            }
        }

        return contentOf2dArray;

    }

    public int repeatedLayout(HashDictionary dict){
 

        String contentOf2dArray = this.contentOf2dArray(); // contentOf2DArray instead of "s" as specified in instructions

        LinkedList<Layout>[] table = dict.getTable();

        // loop through the linked list layout then get boardlayout String from each layout and compare it 

        for(int i = 0; i < table.length; i++){
            // table[0] = one linked list in hashTable 
           for(int j = 0; i < table[i].size(); j++) {
             if(table[i].get(i).getBoardLayout().equalsIgnoreCase(contentOf2dArray)){
                return table[i].get(j).getScore();
             }
           }   
      }  

        return -1; 
    }


    public void storeLayout(HashDictionary dict, int score){

        String contentOf2dArray = this.contentOf2dArray(); // contentOf2DArray instead of "s" as specified in instructions
        Layout LayoutObject = new Layout(contentOf2dArray, score); 
        
        try { // exception handling for putting "s" and score in dict and it handles the exception itself 
            dict.put(LayoutObject); 
        } catch(DictionaryException e){
            System.out.println("Its not in Layout"); 
        }
        
    }

   

    public void saveTile(int row, int col, char symbol){ // method stores stores symbol in theBoard[row][col]
        theBoard[row][col] = symbol; 

    }

    public boolean positionIsEmpty (int row, int col){

        if(theBoard[row][col] == 'E'){
            return true;

        }

        return false; // otherwise if the position does not return 'E'
    }


    public boolean isComputerTile (int row, int col){
        if(theBoard[row][col] == 'R'){
            return true;

        }

        return false; // otherwise if the position does not return 'R'
    }

    public boolean isHumanTile (int row, int col){
        if(theBoard[row][col] == 'B'){
            return true;

        }

        return false; // otherwise if the position does not return 'B'
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



    /* Returns true if there are n adjacent tiles of type symbol in the same row, column, 
    or diagonal of theBoard, where n is the size of the game board. */

    public boolean winner (char symbol){

        boolean won = false; 
        // itterating though the columns
        for (int col = 0; col < theBoard[0].length; col++) { // outer loop iterate through columns
            String eachColumns = "";
            for (int row = 0; row < theBoard.length; row++) { // inner loop iterate through rows
                eachColumns = eachColumns + String.valueOf(theBoard[row][col]);
            }
            
            boolean eachColumnBoolean = false;
            char firstChar = eachColumns.charAt(0);

            if(firstChar == symbol){
                eachColumnBoolean = true;
                for (int i = 1; i < eachColumns.length(); i++) {
                    if (eachColumns.charAt(i) != firstChar) {
                       eachColumnBoolean = false; // found different character
                    }
                }
            }
            
            if (eachColumnBoolean == true){
                return true; 
            }    
    
        }

        // itterating through the rows
        for (int row = 0; row < theBoard.length; row++) { // outer loop for rows
            String eachRows = ""; 
            for (int col = 0; col < theBoard[row].length; col++) { // inner loop for columns
                eachRows = eachRows + String.valueOf(theBoard[row][col]);
            }
            
            boolean eachRowBoolean = false;
            char firstChar = eachRows.charAt(0);

            if(firstChar == symbol){
                eachRowBoolean = true;
                for (int i = 1; i < eachRows.length(); i++) {
                    if (eachRows.charAt(i) != firstChar) {
                       eachRowBoolean = false; // found different character
                    }
                }
            }
            
            if (eachRowBoolean == true){
                return true; 
            }  
        }

        String diagonal = this.diagonal(); 

        boolean eachDiagonalBoolean = false;
        char firstChar = diagonal.charAt(0);
        if(firstChar == symbol){
                eachDiagonalBoolean = true;
                for (int i = 1; i < diagonal.length(); i++) {
                    if (diagonal.charAt(i) != firstChar) {
                       eachDiagonalBoolean = false; // found different character
                    }
                }
            }

        
        return won;

    }


        /* Returns true if the game
    layout corresponding to theBoard is a draw assuming that the player that must perform the
    next move uses tiles of the type specified by symbol. The second parameter is the number of
    positions of the game-board that must remain empty.
    Remember that a game is a draw if no player has won and either:
    
    – empty positions = 0 and there are no empty positions left on the game board, or
    – empty positions > 0, the number of empty positions on the game-board is equal to
    empty positions and none of the empty positions on the game-board has a tile of the
    type specified by symbol adjacent to it. */



    public boolean isDraw(char symbol, int empty_positions){

        if(winner('R') || winner('B')){ // if Red or Blue is the winner its not a draw 
            return false;
        }

        if(empty_positions == 0 && contentOf2dArray().indexOf("E") != -1){
            return true; 
        }

        return false; 
    }


    public int evaluate(char symbol, int empty_positions){

        if(winner('R')){
            return 3;
        }
        if(winner('B')){
            return 0;
        }

        // TODO 2 if draw 

        return 1; // undecided assumption
    }



    
}
