import java.util.LinkedList;

public class HashDictionary implements DictionaryADT { // implements Dictionary ADT interface

    // initialize fields for constructor
    private int dictionarySize;
    private LinkedList<Layout>[] table; // table, array of linked lists that takes parameter Layout 
       

    @SuppressWarnings("unchecked")
    public HashDictionary(int size){ // class constructor 

        this.dictionarySize = size; // dictionary size must be under 10,000
        this.table = new LinkedList[this.dictionarySize]; 

    }


    // helper method to return a value from the String key
    private int hash(String key){  

        int hashesValue = 0; // the final hashvalue

        for(int i = 0; i < key.length(); i++){
            hashesValue = (hashesValue * 31 + key.charAt(i)) % this.dictionarySize; // updating hashesValue with each increment of key's characters, base 31
        }

        return hashesValue; 
    }


    // method to put the data into the hash table based on the hash value
    public int put(Layout data) throws DictionaryException {

        if (data == null || data.getBoardLayout() == null) {
            throw new DictionaryException("Data not valid");
        }

        int index = hash(data.getBoardLayout());
        int collisionReturnValue = 1; 

        if (table[index] == null) {
            table[index] = new LinkedList<>();
            collisionReturnValue = 0;
        }

        
        for (int i = 0; i < table[index].size(); i++) {
            Layout existing = table[index].get(i);
            if (existing.getBoardLayout().equals(data.getBoardLayout())) {
                throw new DictionaryException("Duplicate key: " + data.getBoardLayout());
            }
        }

        table[index].add(data);  
        return collisionReturnValue;
}




    // removes the object with key boardLayout from the dictionary
    public void remove(String boardLayout) throws DictionaryException {

        int index = hash(boardLayout); 
        if (table[index] == null){
            throw new DictionaryException("Key does not exist"); 
        } 

        LinkedList<Layout> toBeRemovedLinkedList = table[index]; 

        for(int i = 0; i < toBeRemovedLinkedList.size(); i++){
            if(toBeRemovedLinkedList.get(i).getBoardLayout().equalsIgnoreCase(boardLayout)){
                toBeRemovedLinkedList.remove(i); // removes unwanted key from index of the linked list
                return;
            }

        }
        throw new DictionaryException("key does not exist : " + boardLayout); // exception in case the key is not there

    }


    // method which returns the score stored inside object in the dictionary, if there is no object with that key -1 is returned
    public int get(String boardLayout){

        int index = hash(boardLayout); 
        if (table[index] == null){
            return -1; // no object in the dictionary with that key
        } 

        LinkedList<Layout> foundLinkedList = table[index]; 

        for(int i = 0; i < foundLinkedList.size(); i++){
            if(foundLinkedList.get(i).getBoardLayout().equalsIgnoreCase(boardLayout)){
                return foundLinkedList.get(i).getScore();
            }

        }
        return -1; // no object in the dictionary with that key

    }

    // getters and setters for table member variable

    public LinkedList<Layout>[] getTable() {
        return table;
    }


    public void setTable(LinkedList<Layout>[] table) {
        this.table = table;
    }



    
    


}
