import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import java.util.Arrays;
import java.util.Map;
import java.util.Vector;
import java.util.Scanner;

public class ASMT06 {
    public static void main(String[] args) {
        Program();
    }

    public static void Program() {
        ListMultimap<String, ListMultimap<String, String>> Dictionary = ArrayListMultimap.create();
        addDictionary(Dictionary);
        System.out.println("- DICTIONARY 220 JAVA Standard -----");
        System.out.println("----- powered by Google Guava -");
        Search(Dictionary);
    }

    public static <Dict> void Search(ListMultimap<String, ListMultimap<String, String>> Dict) {
        String searcher = null;
        boolean found;
        String[] arrOfStr;
        Scanner mySearch = new Scanner(System.in);
        while (searcher != "!q" ) {
            arrOfStr = null;
            found = false;
            System.out.println("Search :");
            searcher = mySearch.nextLine();
            searcher = searcher.toLowerCase();
            if( searcher == "" || searcher == " " ){
                continue;
            }
            if (searcher.equals("!q")) {
                System.out.println("-----THANK YOU-----");
                return;
            }

            arrOfStr = searcher.split("\\s");
            System.out.println("    |");
            for (Map.Entry<String, ListMultimap<String, String>> word : Dict.entries()) {
                /*
                switch (arrOfStr.length) {
                    case 1:
                        if (arrOfStr[0].equals(word.getKey())) {
                            //System.out.print(word + word.getKey() + word.getValue());
                            for (Map.Entry<String, String> speech : word.getValue().entries()) {
                                System.out.println(word.getKey() + " [" + speech.getKey() + "] : " + speech.getValue());
                            }
                            found = true;
                        }
                        break;
                    case 2:
                        if (arrOfStr[1].equals(word.getKey())) {
                            for (Map.Entry<String, String> speech : word.getValue().entries()) {
                                if (arrOfStr[1].equals(speech.getKey())) {
                                    System.out.println(word.getKey() + " [" + speech.getKey() + "] : " + speech.getValue());
                                    found = true;
                                }
                            }
                        }
                        break;
                }*/
                if(arrOfStr.length == 1){
                    if (arrOfStr[0].equals(word.getKey())) {
                        for (Map.Entry<String, String> speech : word.getValue().entries()) {
                            System.out.println(word.getKey() + " [" + speech.getKey() + "] : " + speech.getValue());
                        }
                        found = true;
                    }
                }
                if(arrOfStr.length == 2){
                    if (arrOfStr[0].equals(word.getKey())) {
                        for (Map.Entry<String, String> speech : word.getValue().entries()) {
                            if (arrOfStr[1].equals(speech.getKey())) {
                                System.out.println(word.getKey() + " [" + speech.getKey() + "] : " + speech.getValue());
                                found = true;
                            }
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("<Not found>");
            }
            System.out.println("    |");
        }
    }
    public static<K, V> void iterate(ListMultimap<K, V> multimap) {
        for (K key: multimap.keySet()) {
            System.out.println(key + ": " + multimap.get(key));
        }
    }

    public enum Dictionary {
        book, bookable, bookbinder, bookcase, CSC220
    }
    public static ListMultimap<String,ListMultimap<String, String>> addDictionary(ListMultimap<String,ListMultimap<String, String>> Dict){
        addWords();
        for (Dictionary word : Dictionary.values()) {
            if(String.valueOf(word).equals("book")) {
                Dict.put(String.valueOf(word), wordBook);
            }
            if(String.valueOf(word).equals("bookable")){
                Dict.put(String.valueOf(word), wordBookable);
            }
            if(String.valueOf(word).equals("bookbinder")){
                Dict.put(String.valueOf(word), wordBookbinder);
            }
            if(String.valueOf(word).equals("bookcase")){
                Dict.put(String.valueOf(word), wordBookcase);
            }
            if(String.valueOf(word).equals("CSC220")) {
                Dict.put(String.valueOf(word), wordCSC220);
            }
        }
        return Dict;
    }

    public static void addWords(){
        AddBook();
        AddBookable();
        AddBookcase();
        AddBookbinder();
        AddCSC220();
    }
    static ListMultimap<String,String> wordBook = ArrayListMultimap.create();
    static ListMultimap<String,String> wordBookable = ArrayListMultimap.create();
    static ListMultimap<String,String> wordBookbinder = ArrayListMultimap.create();
    static ListMultimap<String,String> wordBookcase = ArrayListMultimap.create();
    static ListMultimap<String,String> wordCSC220 = ArrayListMultimap.create();

    public static void AddBook(){
        wordBook.put("noun","A written work published in printed or electronic form");
        wordBook.put("verb","To arrange for someone to have a seat on a plane.");
    }
    public static void AddBookable(){
        wordBookable.put("adjective","Can be ordered in advance.");
    }
    public static void AddBookbinder(){
        wordBookbinder.put("adjective","A person who fastens the pages of books.");
    }
    public static void AddBookcase(){
        wordBookcase.put("noun","A piece of furniture with shelves.");
    }
    public static void AddCSC220(){
        wordCSC220.put("noun","Data Structures.");
        wordCSC220.put("adjective","Ready to create complex data structures.");
        wordCSC220.put("verb","To create data structures.");
    }

}
