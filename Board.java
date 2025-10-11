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
 

        String contentOf2dArray = this.contentOf2dArray(); 

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
        
    }

    public void saveTile(int row, int col, char symbol){

    }

    public boolean positionIsEmpty (int row, int col){
        return true; 
    }


    public boolean isComputerTile (int row, int col){
        return true;
    }

    public boolean isHumanTile (int row, int col){
        return true;
    }

    public boolean winner (char symbol){
        return true;
    }

    public boolean isDraw(char symbol, int empty_positions){
        return true; 
    }

    public int evaluate(char symbol, int empty_positions){
        return 0; 
    }



    
}
