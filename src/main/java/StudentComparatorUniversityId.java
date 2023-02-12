import org.apache.commons.lang3.StringUtils;

public class StudentComparatorUniversityId implements StudentComparator {
    @Override
    public String toString() {
        return "StudentComparatorUniversityId";
    }

    @Override
    public int compare(Student student1,Student student2) {
        return StringUtils.compare(student1.getUniversityId(),student2.getUniversityId());
    }
}
