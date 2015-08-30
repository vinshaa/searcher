package my.project.bagOfWords;

/**
 * Created by Justyna on 2015-08-29.
 */
public class Main {

    public static void main(String[] args) {

        /*WordsMapper wordsMapper = new WordsMapper();
        wordsMapper.iterateOverFiles("./txts/");*/
        //wordsMapper.getWord("CXF");
        VectorsCreator vectorsCreator = new VectorsCreator();
        vectorsCreator.iterateOverFiles("./stemmed/");

    }

}
