import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.Map;
import java.util.Vector;
import java.util.Scanner;

public class AMST05 {
    public static void main(String[] args)
    {
        Program();
    }
    public static void Program(){
        //ListMultimap<String, Vector<String>> Dictionary = ArrayListMultimap.create();
        ListMultimap<String, String> Dictionary = ArrayListMultimap.create();
        addDictionary(Dictionary);
        //iterate(Dictionary);
        Search(Dictionary);
    }

    public static <Dict> void Search(ListMultimap<String, String> Dict){
        String searcher = null;
        boolean found = false;
        Scanner myObj = new Scanner(System.in);
        System.out.println("- DICTIONARY 220 JAVA Standard -----");
        System.out.println("----- powered by Google Guava -");
        while(searcher != "!q") {
            found = false;
            System.out.println("Search :");
            searcher = myObj.nextLine();
            searcher = searcher.toLowerCase();
            System.out.println("    |");
            if (searcher.equals("!q")) {
                System.out.println("-----THANK YOU-----");
                return;
            }
            /*
            for (String word : Dict.keySet()) {
                if (searcher.equals(String.valueOf(word))) {
                    System.out.println("    |");
                    System.out.println("    " + word + ": " + Dict.get(word));
                    found = true;
                }
            }
            */
            for (Map.Entry<String, String> word: Dict.entries()) {
                if (searcher.equals(word.getKey())) {
                    System.out.println(word.getKey() + ": " + word.getValue());
                }
                found = true;
            }
            if(found == false) {
                System.out.println("<Not found>");
            }
            System.out.println("    |");
        }
    }
    public static String printDef(ListMultimap<String, String> Dict){
        return null;
    }
    public static<K, V> void iterate(ListMultimap<K, V> multimap)
    {
        for (K key: multimap.keySet()) {
            System.out.println(key + ": " + multimap.get(key));
        }
    }

    public enum Dictionary {
        book, bookable, bookbinder, bookcase, CSC220
    }
    public static ListMultimap<String, String> addDictionary(ListMultimap<String, String> Dict){
        addWords();
        for (Dictionary word : Dictionary.values()) {
            if(String.valueOf(word).equals("book")) {
                for (String def : wordBook) {
                    Dict.put(String.valueOf(word), def);
                }
            }
            if(String.valueOf(word).equals("bookable")){
                for (String def : wordBookable) {
                    Dict.put(String.valueOf(word), def);
                }
            }
            if(String.valueOf(word).equals("bookbinder")){
                for (String def : wordBook) {
                    Dict.put(String.valueOf(word), def);
                }
            }
            if(String.valueOf(word).equals("bookcase")){
                for (String def : wordBookcase) {
                    Dict.put(String.valueOf(word), def);
                }
            }
            if(String.valueOf(word).equals("CSC220")){
                for (String def : wordCSC220) {
                    Dict.put(String.valueOf(word), def);
                }
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
    static Vector<String> wordBook = new Vector<String>();
    static Vector<String> wordBookable = new Vector<String>();
    static Vector<String> wordBookbinder = new Vector<String>();
    static Vector<String> wordBookcase = new Vector<String>();
    static Vector<String> wordCSC220 = new Vector<String>();

    public static void AddBook(){
        wordBook.add("A written work published in printed or electronic form");
        wordBook.add("To arrange for someone to have a seat on a plane.");
    }
    public static void AddBookable(){
        wordBookable.add("Can be ordered in advance.");
    }
    public static void AddBookbinder(){
        wordBookbinder.add("A person who fastens the pages of books.");
    }
    public static void AddBookcase(){
        wordBookcase.add("A piece of furniture with shelves.");
    }
    public static void AddCSC220(){
        wordCSC220.add(" Data Structures.");
        wordCSC220.add("Ready to create complex data structures.");
        wordCSC220.add("To create data structures.");
    }

}
