package indexOfWordsGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class provides a method to read multiple text files (pages) and map words to the pages
 * in which they appear. It excludes certain words based on the provided exclude list
 * and uses allowed characters to split the content into words.
 */
public class PageReader {

    /**
     * Reads the content of multiple pages, splits the text into words, and maps each word
     * to the pages where it appears. Excludes specific words from the mapping based on
     * a given set of words to exclude.
     *
     * @param pages        An array of file paths representing pages to be read.
     * @param excludeWords A set of words to be excluded from the mapping.
     * @param allowed      A regular expression defining the allowed delimiters for splitting words.
     * @return             A TreeMap where each key is a word (String) and the value is a set of
     *                     integers representing the page numbers where the word appears.
     */
 public Map<String, Set<Integer>> readPages(String[] pages, Set<String> excludeWords, String allowed) {
     Map<String, Set<Integer>> wordPageMap = new TreeMap<>();

     for (int i = 0; i < pages.length; i++) {
         String page = pages[i];
         Integer pageNo = i + 1;
         try (BufferedReader br = new BufferedReader(new FileReader(page))) {
             String line;
             while ((line = br.readLine()) != null) {

                 String[] words = line.toLowerCase().split(allowed);

                 for (String word : words) {

                     if (!excludeWords.contains(word) && !word.trim().isEmpty()) {
                         wordPageMap.computeIfAbsent(word.trim(), k -> new HashSet<>()).add(pageNo);
                     }
                 }
             }
         } catch (IOException e) {
             System.out.println("An error occurred: Exception occurred in the readPages(), Class: PageReader");
             System.out.println("Actual error: " + e.getMessage());
         }
     }

     return wordPageMap;
 }




}
