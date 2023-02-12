public class SelectCompar {
    private SelectCompar() {
    }

    public static StudentComparator getMyComparatorForStudents(OptionsStudentCompar optionsStudentCompar){

        StudentComparator optionsCompar = null;
        switch (optionsStudentCompar) {

            case StudentComparatorAvgExamScore -> optionsCompar = new StudentComparatorAvgExamScore();

            case StudentComparatorCurrentCorseNumber -> optionsCompar = new StudentComparatorCurrentCorseNumber();

            case StudentComparatorFullName -> optionsCompar = new StudentComparatorFullName();

            case StudentComparatorUniversityId -> optionsCompar = new StudentComparatorUniversityId();

            default -> System.out.println("Введен некорректный тип компаратора!");
        }
        return optionsCompar;
    }
    public static UniversityComparator getMyComparatorForUniversity(OptionsUniversityCompar optionsUniversityCompar){

        UniversityComparator optionsCompar = null;
        switch (optionsUniversityCompar) {

            case UniversityComparatorFullName -> optionsCompar = new UniversityComparatorFullName();

            case UniversityComparatorId -> optionsCompar = new UniversityComparatorId();

            case UniversityComparatorMainProfile -> optionsCompar = new UniversityComparatorMainProfile();

            case UniversityComparatorShortName -> optionsCompar = new UniversityComparatorShortName();

            case UniversityComparatorYearOfFoundation -> optionsCompar = new UniversityComparatorYearOfFoundation();

            default -> System.out.println("Введен некорректный тип компаратора!");
        }
        return optionsCompar;
    }
}
