public class StudentComparatorCurrentCorseNumber implements StudentComparator {

    @Override
    public String toString() {
        return "StudentComparatorCurrentCorseNumber";
    }

    @Override
    public int compare(Student student1,Student student2) {
        return Integer.compare(student1.getCurrentCourseNumber(),student2.getCurrentCourseNumber());
    }
}
