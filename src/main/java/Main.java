import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections4.IteratorUtils.forEach;

public class Main {
    public static void main(String[] args) throws Exception {

        //Сериализация и десериализация объекта студент.
//        String json = JsonUtil.serializationForStudent(new Student("Nikachka", "124", 4, 4.96f));
//        System.out.println("Converting Person object to JSON string:\n" + json);
//        Student student = JsonUtil.deserializationForStudent(json);
//        System.out.println("\nConverting JSON string to Person object:\n" + student.toString());

        //Сериализация и десериализация объекта университет.
//        String json = JsonUtil.serializationForUniversity(new University("0001-high","Московский Выдуманный Университет","МВУ",1990, StudyProfile.PHYSICS));
//        System.out.println("Converting Person object to JSON string:\n" + json);
//        University university = JsonUtil.deserializationForUniversity(json);
//        System.out.println("\nConverting JSON string to Person object:\n" + university.toString());

        //Сериализация и десериализация коллекции студентов.
//        List<Student> studentsCollection = ReadingAFile.readFromExcelStudents();
//        String json = JsonUtil.serializationForStudentsCollection(studentsCollection);
//        System.out.println("Converting Person object to JSON string:\n" + json);
//        ArrayList<Student> students = JsonUtil.deserializationForStudentsCollection(json);
//        System.out.println("\nConverting JSON string to Person object:\n" + students.toString());
//        if (students.size() != studentsCollection.size()){
//            throw new Exception("Ошибка при сериализации/десериализации коллекции");
//        }
//
        //Сериализация и десериализация коллекции университетов.
//        List<University> universitiesCollection = ReadingAFile.readFromExcelUniversitets();
//        String json = JsonUtil.serializationForUniversityCollection(universitiesCollection);
//        System.out.println("Converting Person object to JSON string:\n" + json);
//        ArrayList<University> universities = JsonUtil.deserializationForUniversityCollection(json);
//        System.out.println("\nConverting JSON string to Person object:\n" + universities.toString());
//        if (universities.size() != universitiesCollection.size()){
//            throw new Exception("Ошибка при сериализации/десериализации коллекции");
//        }


        //Сериализация и десериализация коллекции студентов c помощью Java Stream API.
        List<Student> students = ReadingAFile.readFromExcelStudents();
        students.stream()
                .map(JsonUtil::serializationForStudent)
                .peek(System.out::println)
                .map(JsonUtil::deserializationForStudent)
                .forEach(System.out::println);

        //Сериализация и десериализация коллекции университетов c помощью Java Stream API.
        List<University> universities = ReadingAFile.readFromExcelUniversitets();
        universities.stream()
                .map(JsonUtil::serializationForUniversity)
                .peek(System.out::println)
                .map(JsonUtil::deserializationForUniversity)
                .forEach(System.out::println);
    }
}


