import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String file = "GenerationExcel.xlsx";
    private static final Logger log = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {

        List<StudentComparator> studentList = new ArrayList<>();
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorFullName));
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorAvgExamScore));
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorUniversityId));
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorCurrentCorseNumber));

        List<Student> students = ReadingAFile.readFromExcelStudents();
        studentList.forEach(c -> {
            log.info("Сортировка с использованием класса компаратора: "+ c.toString());
            students.sort(c);
            students.forEach(System.out::println);
            log.info("Сортировка выполнена успешно!");
        });


        List<UniversityComparator> universityList = new ArrayList<>();
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorId));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorYearOfFoundation));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorFullName));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorShortName));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorMainProfile));

        List<University> universities  = ReadingAFile.readFromExcelUniversitets();
        universityList.forEach(c -> {
            log.info("Сортировка с использованием класса компаратора: "+ c.toString());
            universities.sort(c);
            universities.forEach(System.out::println);
            log.info("Сортировка выполнена успешно!");
        });


        ProcessingCollectionStudentsAndUniversities processingCollectionStudentsAndUniversities = new ProcessingCollectionStudentsAndUniversities();
        List<Statistics>statistics = processingCollectionStudentsAndUniversities.statisticsConverter(ReadingAFile.readFromExcelStudents(), ReadingAFile.readFromExcelUniversitets());

        XlsWriter xlsWriter = new XlsWriter();
        xlsWriter.assemblyGenerationMethod(statistics, file);
    }
}


