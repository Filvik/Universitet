import org.apache.commons.lang3.StringUtils;

public class UniversityComparatorId implements UniversityComparator{
    @Override
    public String toString() {
        return "UniversityComparatorId";
    }

    @Override
    public int compare(University university1, University university2) {
        return StringUtils.compare(university1.getId(),university2.getId());
    }
}
