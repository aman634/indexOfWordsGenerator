package indexOfWordsGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is responsible for reading a file that contains words to be excluded
 * and generating a set of these words, which can be used to filter out unwanted words
 * from text processing operations.
 */
public class ExcludeWords {

    /**
     * Reads a file containing words to exclude, processes the file to extract words,
     * and returns them in a set. Each word is converted to lowercase and trimmed.
     *
     * @param excludeWordsFile The file path that contains words to be excluded, where
     *                         each word is separated by non-word characters (e.g., punctuation).
     * @return                 A set of words (in lowercase and without leading/trailing spaces) to exclude.
     */
    public Set<String> excludeWords(String excludeWordsFile)
    {
       Set<String> excludedWordsSet = new HashSet<>();

        try(BufferedReader br = new BufferedReader(new FileReader(excludeWordsFile))){

            String line;
            while((line = br.readLine()) != null){
                String [] words = line.split("\\W+");
                for(String word: words){
                    excludedWordsSet.add(word.toLowerCase().trim());
                }
            }
        }catch (IOException e){
            System.out.println("An error occurred: Exception occurred in the excludeWord(), Class: ExcludeWords");
            System.out.println("Actual error: " + e.getMessage());
        }
        return excludedWordsSet;
    }
}
