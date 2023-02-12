import org.apache.commons.lang3.StringUtils;

public class StudentComparatorFullName implements StudentComparator {

    @Override
    public String toString() {
        return "StudentComparatorFullName";
    }

    @Override
    public int compare(Student student1,Student student2) {
        return StringUtils.compare(student1.getFullName(), student2.getFullName());
    }
}
