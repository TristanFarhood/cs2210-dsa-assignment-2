import java.util.LinkedList;

public class HashDictionary implements DictionaryADT { // implements Dictionary ADT interface

    // initialize fields for constructor
    private int dictionarySize;
    private LinkedList<Layout>[] table; // table, array of linked lists that takes parameter Layout 
       

    public HashDictionary(int size){ // class constructor 

        dictionarySize = size; // dictionary size must be under 10,000 

    }


    /* To determine how good your design is, we will count the number of collisions produced by your
    hash function. Method put must return the value 1 if the insertion of the object referenced
    by data into the hash table produces a collision, and it must return the value 0 otherwise.
    In other words, if for example your hash function is h(key) and the name of your table is T,
    this method will return the value 1 if the list stored in T[h(data.getBoardLayout())] already
    stores at least one element; it will return 0 if T[h(data.getBoardLayout())] is null or an empty
    list. */


    // 1 means collision in the hash 
    // 0 menas no collision in the hash 


    /* We pass a layout l1 : RBBREE, score as 2 key is RBBREE value is 2
     * Our hash method takes the key RBREE returns 5 to be indexed in the array
     * T[5] now holds value RBBREE and score 2
     * 
     * Now layout l2 : RBBERE, score as 1 key is RBBERE value is 1
     * Our hash method takes the key RBBERE returns 5 to be indexed in the array
     * T[5] with implemented linked list expands by 1 
     */

    // has method hash "h" - consistent in the assignment pdf
    private int hash(String key){ // key is data.getboardlayout()
        return 0;  

    }


    public int put(Layout data) throws DictionaryException { 

        // data.getBoardLayout();



        return 0; // temp return   

    }

    
    public void remove(String boardLayout) throws DictionaryException {

    }


    public int get(String boardLayout){
        return 0; // temp return
    }


}
