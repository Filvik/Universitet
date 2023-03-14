import java.util.logging.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String file = "GenerationExcel.xlsx";
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        List<StudentComparator> studentList = new ArrayList<>();
        log.info("Добавление компараторов в коллекцию.");
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorFullName));
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorAvgExamScore));
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorUniversityId));
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorCurrentCorseNumber));
        log.info("Коллекция компараторов заполнена.");

        List<Student> students = ReadingAFile.readFromExcelStudents();
        studentList.forEach(c -> {
            log.info("Сортировка с использованием класса компаратора: " + c.toString());
            students.sort(c);
            log.fine("Сортировка выполнена успешно!");
        });


        List<UniversityComparator> universityList = new ArrayList<>();
        log.info("Добавление компараторов в коллекцию.");
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorId));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorYearOfFoundation));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorFullName));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorShortName));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorMainProfile));
        log.info("Коллекция компараторов заполнена.");

        List<University> universities = ReadingAFile.readFromExcelUniversitets();
        universityList.forEach(c -> {
            log.info("Сортировка с использованием класса компаратора: " + c.toString());
            universities.sort(c);
            log.fine("Сортировка выполнена успешно!");
        });


        ProcessingCollectionStudentsAndUniversities processingCollectionStudentsAndUniversities = new ProcessingCollectionStudentsAndUniversities();
        List<Statistics> statistics = processingCollectionStudentsAndUniversities.statisticsConverter(ReadingAFile.readFromExcelStudents(), ReadingAFile.readFromExcelUniversitets());

        XlsWriter xlsWriter = new XlsWriter();
        xlsWriter.assemblyGenerationMethod(statistics, file);
        log.fine("Программа выполнена!");
    }
}


