package my.project.stemmer;

import java.io.File;

/**
 * Created by Justyna on 2015-08-30.
 */
public class MainStem {

    public static void main(String[] args) {
        Stemmer stemmer = new Stemmer();

        File directory = new File("./txts/");
        File[] directoryListing = directory.listFiles();
        stemmer.stem(directoryListing);
    }

}
