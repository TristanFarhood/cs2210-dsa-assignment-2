public class Main {

     
    public static String getPrincipalDiagonal(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return "";
        }
        StringBuilder diagonalString = new StringBuilder();
        //int size = Math.min(matrix.length, matrix[0].length); // Handle non-square matrices
        for (int i = 0; i < matrix.length; i++) {
            diagonalString.append(matrix[i][i]);
        }
        return diagonalString.toString();
    }
    
    public static void main (String args[]){
        char[][] matrix = {
    {'A', 'E', 'R'},
    {'B', 'W', 'E'},
    {'E', 'E', 'C'}
    };
       String test = getPrincipalDiagonal(matrix);
       System.out.println(test); 




        


        

    //     char[][] theBoard = {
    // {'R', 'E', 'R'},
    // {'B', 'B', 'E'},
    // {'E', 'E', 'E'}
    // };

    //     // for (int col = 0; col < theBoard[0].length; col++) { // outer loop iterate through columns
    //     //     String eachColumns = "";
    //     //     for (int row = 0; row < theBoard.length; row++) { // inner loop iterate through rows
    //     //         eachColumns = eachColumns + String.valueOf(theBoard[row][col]);
    //     //     }
            
    //     //     boolean eachColumnBoolean = false;
    //     //     char firstChar = eachColumns.charAt(0);

    //     //     if(firstChar == 'B'){
    //     //         eachColumnBoolean = true;
    //     //         for (int i = 1; i < eachColumns.length(); i++) {
    //     //             if (eachColumns.charAt(i) != firstChar) {
    //     //                eachColumnBoolean = false; // found different character
    //     //             }
    //     //         }
    //     //     }
            
    //     //     if (eachColumnBoolean == true){
    //     //         System.out.println("Return true"); 
    //     //     }    
    
    //     // }




    //     for (int row = 0; row < theBoard.length; row++) { // outer loop for rows
    //         String eachRows = ""; 
    //         for (int col = 0; col < theBoard[row].length; col++) { // inner loop for columns
    //             eachRows = eachRows + String.valueOf(theBoard[row][col]);
    //         }
            
    //         boolean eachRowBoolean = false;
    //         char firstChar = eachRows.charAt(0);

    //         if(firstChar == 'E'){
    //             eachRowBoolean = true;
    //             for (int i = 1; i < eachRows.length(); i++) {
    //                 if (eachRows.charAt(i) != firstChar) {
    //                    eachRowBoolean = false; // found different character
    //                 }
    //             }
    //         }
            
    //         if (eachRowBoolean == true){
    //             System.out.println("True");  
    //         }  
    //     }

    }    

}
