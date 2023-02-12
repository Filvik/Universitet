import org.apache.commons.lang3.StringUtils;

public class UniversityComparatorShortName implements UniversityComparator{
    @Override
    public String toString() {
        return "UniversityComparatorShortName";
    }

    @Override
    public int compare(University university1, University university2) {
        return StringUtils.compare(university1.getShortName(),university2.getShortName());
    }
}
