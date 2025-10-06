public class DictionaryException extends Exception{


    public DictionaryException(String message) { // Constructor
        super(message); 
    }

    public DictionaryException() {
        super("For now this is a messsage in dictionary exception");
    }
    
    
}
