import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.junit.jupiter.api.Test;
import org.recap.Summarizer;
import org.recap.graph.Graph;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class AppTest {
    @Test
    public void test() {
        // file path
        String filePath = "C:\\Users\\chs\\Desktop\\data\\mju\\mju4_2\\RPA\\final_team\\final_project\\review.txt";
        String outputPath = "C:\\Users\\chs\\Desktop\\data\\mju\\mju4_2\\RPA\\final_team\\final_project\\review2.txt";

        try {
            // read txt
            String text = readFile(filePath);

            // Summarizer create instance and summarize call method
            Summarizer summarizer = new Summarizer();
            List<String> summarizedTextList = summarizer.summarize(text, Graph.SimilarityMethods.COSINE_SIMILARITY);

            // List<String> String save file
            String summarizedText = String.join("\n", summarizedTextList);
            writeFile(outputPath, summarizedText);


            System.out.println("save file!: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read txt
    private String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    // write txt
    private void writeFile(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
