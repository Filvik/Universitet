public class StudentComparatorAvgExamScore implements StudentComparator {
    @Override
    public String toString() {
        return "StudentComparatorAvgExamScore";
    }

    @Override
    public int compare(Student student1, Student student2) {
        return Float.compare(student1.getAvgExamScore(),student2.getAvgExamScore())*-1;
    }
}
