package my.project.bagOfWords;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by Justyna on 2015-08-29.
 */
public class ListOfWordsCreator {

    private List<String> listOfTterms;
    private Hashtable<String, Integer> terms;

    public WordsMapper getWordsMapper() {
        return wordsMapper;
    }

    private WordsMapper wordsMapper = new WordsMapper();

    ListOfWordsCreator(String dir){
        createListOfUniqueWords(dir);
        //wordsMapper.getWord("cxf");
    }

    public void createListOfUniqueWords(String dir) {
        wordsMapper.iterateOverFiles(dir);
        listOfTterms = wordsMapper.getListOfTerms();
        terms = wordsMapper.getTerms();
    }

    public List<String> getListOfTerms() {
        return listOfTterms;
    }

    public Hashtable<String, Integer> getTerms() {
        return terms;
    }

}
