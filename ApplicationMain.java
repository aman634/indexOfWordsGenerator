package indexOfWordsGenerator;

/**
 * The ApplicationMain class is the entry point for the program that generates an index
 * of words and the corresponding page numbers across multiple files.
 */
public class ApplicationMain {

/**
 * The main method initializes the index generation process by:
 * - Reading input text files.
 * - Excluding certain words from an exclude words file.
 * - Generating an index and writing it to an output file.
 */
    public static void main(String[] args) {

        // Initialize the Index object that will coordinate the index generation
        Index index = new Index();

        // Path to the file containing the words to be excluded
        String excludeFile = "D:\\Java Containt\\Java Projects\\TQPrograms\\exclude-words.txt";

        // Array of file paths to be read and indexed
        String [] readFiles = {"D:\\Java Containt\\Java Projects\\TQPrograms\\Page1.txt",
                                "D:\\Java Containt\\Java Projects\\TQPrograms\\Page2.txt",
                                "D:\\Java Containt\\Java Projects\\TQPrograms\\Page3.txt"};

        // Output file path where the index will be written
        String outputFile = "D:\\Java Containt\\Java Projects\\TQPrograms\\index1.txt";

        // Regular expression to split words, allowing special characters such as '•', '?', '“', and '–'
        String regex = "[^\\p{L}'?•“–”]+";

        // Call the generateIndex method to create the index
        index.generateIndex(readFiles, excludeFile, outputFile, regex);

        // Notify the user that the index file has been successfully generated
        System.out.println("File generated Successfully.............................");

    }
}
