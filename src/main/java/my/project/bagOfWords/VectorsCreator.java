package my.project.bagOfWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Justyna on 2015-08-29.
 */
public class VectorsCreator {

        private ListOfWordsCreator listOfWordsCreator = new ListOfWordsCreator("./stemmed/");
        private File file = new File("bagOfWordsVectors.txt");
        WordsMapper wordsMapper = listOfWordsCreator.getWordsMapper();


    public void iterateOverFiles(String dir) {

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

    public void readFile(String fileName) {

        Hashtable<String, Integer> terms = new Hashtable<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNext()) {
                String word = sc.next().toLowerCase();
                if (terms.get(word) == null) {
                    terms.put(word, 1);
                } else {
                    terms.put(word, terms.get(word) + 1);
                }
            }

            //System.out.println("slowo 'a' wystepuje razy: " + terms.get("a"));
            saveVectorToFile(terms);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void saveVectorToFile(Hashtable<String, Integer> terms) {

        try (FileWriter fw = new FileWriter(file, true)) {

            Set<String> keys = listOfWordsCreator.getTerms().keySet();
            for (String key : keys) {
                if (terms.get(key) != null) {
                    //System.out.println(terms.get(key).toString() + " ");
                    fw.append(terms.get(key).toString() + "\t");
                } else {
                    //System.out.println("---------------");
                    fw.append("0\t");
                }
            }
            fw.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
