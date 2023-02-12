import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<StudentComparator> studentList = new ArrayList<>();
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorFullName));
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorAvgExamScore));
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorUniversityId));
        studentList.add(SelectCompar.getMyComparatorForStudents(OptionsStudentCompar.StudentComparatorCurrentCorseNumber));

        List<Student> students = ReadingAFile.readFromExcelStudents();
        studentList.forEach(c -> {
            System.out.println("------------------------------------------------" + c.toString());
            students.sort(c);
            students.forEach(System.out::println);
        });


        List<UniversityComparator> universityList = new ArrayList<>();
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorId));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorYearOfFoundation));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorFullName));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorShortName));
        universityList.add(SelectCompar.getMyComparatorForUniversity(OptionsUniversityCompar.UniversityComparatorMainProfile));

        List<University> universities  = ReadingAFile.readFromExcelUniversitets();
        universityList.forEach(c -> {
            System.out.println("-------------------------------------------------" + c.toString());
            universities.sort(c);
            universities.forEach(System.out::println);
        });
    }
}

