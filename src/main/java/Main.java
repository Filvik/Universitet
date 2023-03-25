import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.*;

public class Main {
    private static final String file = "GenerationExcel.xlsx";
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
//
//        //======================
//        //Сортировка коллекций разных классов с использованием компараторов.

//        List<StudentComparator> studentList = new ArrayList<>();
//        log.info("Добавление компараторов в коллекцию.");
//        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorFullName));
//        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorAvgExamScore));
//        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorUniversityId));
//        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorCurrentCorseNumber));
//        log.info("Коллекция компараторов заполнена.");
//
//        List<Student> students = ReadingAFile.readFromExcelStudents();
//        studentList.forEach(c -> {
//            log.info("Сортировка с использованием класса компаратора: " + c.toString());
//            students.sort(c);
//            log.fine("Сортировка выполнена успешно!");
//        });
//
//        List<UniversityComparator> universityList = new ArrayList<>();
//        log.info("Добавление компараторов в коллекцию.");
//        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorId));
//        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorYearOfFoundation));
//        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorFullName));
//        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorShortName));
//        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorMainProfile));
//        log.info("Коллекция компараторов заполнена.");
//
//        List<University> universities = ReadingAFile.readFromExcelUniversitets();
//        universityList.forEach(c -> {
//            log.info("Сортировка с использованием класса компаратора: " + c.toString());
//            universities.sort(c);
//            log.fine("Сортировка выполнена успешно!");
//        });
          //======================
//
//        //======================
        //Создание классов для преобразования.
        WritingXMLFilesFromJava writingXMLFilesFromJava = new WritingXMLFilesFromJava();
        WritingJSONFilesFromJava writingJSONFilesFromJava = new WritingJSONFilesFromJava();
        //Создание класса с необходимой классовой структурой.
        ObjectWrappers objectWrappers = new ObjectWrappers();
        //Создание классов обёрток.
        StudentWrapper studentWrapper = new StudentWrapper();
        UniversityWrapper universityWrapper = new UniversityWrapper();
        StatisticsWrapper statisticsWrapper = new StatisticsWrapper();
        //Установка коллекций для классов.
        studentWrapper.setWrapper(ReadingAFile.readFromExcelStudents());
        universityWrapper.setWrapper(ReadingAFile.readFromExcelUniversitets());
        statisticsWrapper.setWrapper(ProcessingCollectionStudentsAndUniversities.statisticsConverter(ReadingAFile.readFromExcelStudents(),
                ReadingAFile.readFromExcelUniversitets()));
        //Установка значений для класса ObjectWrappers.
        objectWrappers.union(studentWrapper, universityWrapper, statisticsWrapper, new Date());

        //Запись XML-файлов из Java-класса.
        writingXMLFilesFromJava.convertObject(objectWrappers);
        //Запись JSON-файлов из Java-классов.
        String string = writingJSONFilesFromJava.convertObject(objectWrappers);

        //Десериализация объекта класса ObjectWrappers из JSON.
        ObjectWrappers objectWrappers1 = JsonUtil.deserializationForObjectWrappers(string);
        //Проверка корректности десериализации.Ещё раз сериализуем результат десериализации и сравниваем получившиеся
        //строки первой и второй сериализации.
        String stringObject = writingJSONFilesFromJava.convertObject(objectWrappers1);
        if (Objects.equals(string, stringObject)) {
            log.info("Its good");
        }
          //======================

//        //======================
//        //Коллекция для проверки сериализации объекта класса Statistics.
//        ArrayList<String> fullName = new ArrayList<>();
//        fullName.add("MGU");
//        fullName.add("MWU");
//
//        //Сериализация объекта любого класса.
//        Statistics statistics = new Statistics(StudyProfile.MEDICINE, 3.45, fullName, 5, 6);
//        String jsonobject = JsonUtil.serializationObject(statistics);
//        //Десериализация объекта любого класса.
//        Object object = JsonUtil.deserializationObject(jsonobject);
//        //Определение класса получившегося объекта.
//        System.out.println(object.getClass());
//        //Проверка корректности десериализации.Ещё раз сериализуем результат десериализации и сравниваем получившиеся
//        //строки первой и второй сериализации.
//        String string = JsonUtil.serializationObject(object);
//        System.out.println(string);
//        if (Objects.equals(string, jsonobject)) {
//            log.info("Its good");
//        }
//        //======================
//
          //======================
//        //Сериализация коллекции.
//        List<Statistics> statistics = ProcessingCollectionStudentsAndUniversities.statisticsConverter(ReadingAFile.readFromExcelStudents(),
//        ReadingAFile.readFromExcelUniversitets());
//        assert statistics != null;
//        String json = JsonUtil.serializationForObjectCollection(statistics);
//        System.out.println(json);
//        //Десериализация коллекции.
//        ArrayList<?> collection = JsonUtil.deserializationForObjectCollection(json);
//        //Определение коллекция какого класса получилась после десериализации.
//        System.out.println(collection != null ? collection.get(0).getClass() : null);
//        //Проверка корректности десериализации.Ещё раз сериализуем результат десериализации и сравниваем получившиеся
//        //строки первой и второй сериализации.
//        assert collection != null;
//        String jsonobject = JsonUtil.serializationForObjectCollection(collection);
//        if(Objects.equals(json, jsonobject)){
//            log.info("Its good");
//        }
          //======================
    }
}


