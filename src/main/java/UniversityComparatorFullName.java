import org.apache.commons.lang3.StringUtils;

public class UniversityComparatorFullName implements UniversityComparator{
    @Override
    public String toString() {
        return "UniversityComparatorFullName";
    }

    @Override
    public int compare(University university1, University university2) {
        return StringUtils.compare(university1.getFullName(),university2.getFullName());
    }
}
