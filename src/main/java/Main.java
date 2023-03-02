import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String file = "GenerationExcel.xlsx";

    public static void main(String[] args) {

        ProcessingCollectionStudentsAndUniversities processingCollectionStudentsAndUniversities = new ProcessingCollectionStudentsAndUniversities();
        List<Statistics>statistics = processingCollectionStudentsAndUniversities.statisticsConverter(ReadingAFile.readFromExcelStudents(), ReadingAFile.readFromExcelUniversitets());

        XlsWriter xlsWriter = new XlsWriter();
        xlsWriter.assemblyGenerationMethod(statistics, file);
    }
}


