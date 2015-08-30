package my.project.bagOfWords;

import my.project.stemmer.Stemmer;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.Hashtable;

/**
 * Created by Justyna on 2015-08-29.
 */
public class WordsMapper {


    private Hashtable<String,Integer> terms = new Hashtable<>();
    private List<String> listOfTerms;

    public void readFile(String fileName){

        //String fileName = "1.txt";
        /*try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = br.readLine();
            while(line != null){

                line = br.readLine();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }*/
        try (Scanner sc = new Scanner(new File(fileName))){
            while(sc.hasNext()){
                String word = sc.next().toLowerCase();
                if(terms.get(word) == null){
                    terms.put(word,1);
                }else {
                    terms.put(word, terms.get(word) + 1);
                }
            }
            hashtableToList();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void hashtableToList(){
        Set<String> keys = terms.keySet();
        List<String> listOfTerms = new ArrayList<>(terms.size());
        for(String key: keys){
            //System.out.println("Value of "+ key +" is: "+ terms.get(key));
            listOfTerms.add(key);
        }
        this.listOfTerms = listOfTerms;
    }

    public void iterateOverFiles(String dir){

        /*//Path dir;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry: stream) {
                readFile(stream.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        File directory = new File(dir);
        File[] directoryListing = directory.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                // Do something with child
                System.out.println(child.getName());
                readFile(dir + child.getName());
            }

        } else {
            // Handle the case where dir is not really a directory.
            // Checking dir.isDirectory() above would not be sufficient
            // to avoid race conditions with another process that deletes
            // directories.
        }

    }

    public void getWord(String word){
        System.out.println(word + " found times: " + terms.get(word.toLowerCase()));
        System.out.println("On 1000 index found word: " + listOfTerms.get(10999));
        System.out.println("TOTAL amount of UNIQUE words: " + terms.size());
    }

    public List<String> getListOfTerms(){
        return listOfTerms;
    }

    public Hashtable<String, Integer> getTerms() {
        return terms;
    }

}
