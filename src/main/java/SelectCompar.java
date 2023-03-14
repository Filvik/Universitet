import java.util.logging.Logger;

public class SelectCompar {
    private SelectCompar() {
    }

    private static final Logger log = Logger.getLogger(SelectCompar.class.getName());

    public static StudentComparator getMyComparatorForStudents(OptionsStudentCompar optionsStudentCompar){

        log.info("Необходимо выбрать класс компаратора.");

        StudentComparator optionsCompar = null;
        switch (optionsStudentCompar) {

            case StudentComparatorAvgExamScore -> optionsCompar = new StudentComparatorAvgExamScore();

            case StudentComparatorCurrentCorseNumber -> optionsCompar = new StudentComparatorCurrentCorseNumber();

            case StudentComparatorFullName -> optionsCompar = new StudentComparatorFullName();

            case StudentComparatorUniversityId -> optionsCompar = new StudentComparatorUniversityId();

            default -> log.severe("Введен некорректный тип компаратора!");
        }
        log.info("Выбран класс компаратора: "+ optionsCompar);
        return optionsCompar;
    }
    public static UniversityComparator getMyComparatorForUniversity(OptionsUniversityCompar optionsUniversityCompar){

        log.info("Необходимо выбрать класс компаратора.");

        UniversityComparator optionsCompar = null;
        switch (optionsUniversityCompar) {

            case UniversityComparatorFullName -> optionsCompar = new UniversityComparatorFullName();

            case UniversityComparatorId -> optionsCompar = new UniversityComparatorId();

            case UniversityComparatorMainProfile -> optionsCompar = new UniversityComparatorMainProfile();

            case UniversityComparatorShortName -> optionsCompar = new UniversityComparatorShortName();

            case UniversityComparatorYearOfFoundation -> optionsCompar = new UniversityComparatorYearOfFoundation();

            default -> log.severe("Введен некорректный тип компаратора!");
        }
        log.info("Выбран класс компаратора: "+ optionsCompar);
        return optionsCompar;
    }
}
