package indexOfWordsGenerator;
import java.util.Map;
import java.util.Set;

/**
 * The `Index` class serves as the coordinator for reading pages, excluding words,
 * and generating an index of words mapped to page numbers. It uses the
 * `PageReader`, `ExcludeWords`, and `IndexGenerator` classes to perform these tasks.
 */
public class Index {

    private PageReader pageReader;
    private ExcludeWords excludeWords;
    private IndexGenerator indexGenerator;

    /**
     * Constructor initializes the `PageReader`, `ExcludeWords`, and `IndexGenerator`
     * instances to manage the various processes involved in generating the word index.
     */
    public Index(){
        pageReader = new PageReader();
        excludeWords = new ExcludeWords();
        indexGenerator = new IndexGenerator();
    }

    /**
     * This method manages the overall process of generating a word-to-pages index. It:
     * - Reads the pages from the provided files.
     * - Excludes specified words based on an exclude words file.
     * - Generates and writes the word index to an output file.
     *
     * @param readFiles           An array of file paths containing the pages to be read.
     * @param excludeWordsFile    The file path containing words to be excluded from the index.
     * @param outputFile          The file path where the generated index should be written.
     * @param allowedSpecialChars  A string or regular expression defining the allowed special characters or delimiters for splitting words.
     */
    public void generateIndex(String [] readFiles,String excludeWordsFile, String outputFile, String allowedSpecialChars){

        // Read the exclude words file and generate the set of words to exclude
        Set<String> excludedWords = excludeWords.excludeWords(excludeWordsFile);

        // Read the pages, filter out the excluded words, and create the word-page number mapping
        Map<String, Set<Integer>> wordPageNoMapping = pageReader.readPages(readFiles, excludedWords, allowedSpecialChars);

        // Generate the index and write it to the specified output file
        indexGenerator.generateIndex(wordPageNoMapping, outputFile);

    }
}
