package indexOfWordsGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * This class generates an index of words and the corresponding page numbers
 * where each word appears. The index is written to a specified output file.
 */
public class IndexGenerator {

    /**
     * Generates an index from the provided word-to-pages mapping and writes it to an output file.
     * Each entry in the output file lists a word and the page numbers where it appears, sorted in ascending order.
     *
     * @param wordPageMap A map where the key is a word (String) and the value is a set of page numbers (Set<Integer>)
     *                    where the word appears.
     * @param outputFile  The file path where the generated index will be written.
     */
    public void generateIndex(Map<String, Set<Integer>> wordPageMap, String outputFile){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Word : Page Numbers");
            bw.newLine();
            bw.write("-------------------");
            bw.newLine();

            for (Map.Entry<String, Set<Integer>> entry : wordPageMap.entrySet()) {

                String word = entry.getKey();
                String pages = String.join(",",
                        entry.getValue()
                                .stream()
                                .sorted()
                                .map(String::valueOf)
                                .toArray(String[]::new)
                );
                bw.write(word+" : "+pages);
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("An error occurred: Exception occurred in the generateIndex(), Class: IndexGenerator");
            System.out.println("Actual error: " + e.getMessage());
        }
    }

}
