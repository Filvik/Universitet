import org.apache.commons.lang3.StringUtils;

public class UniversityComparatorMainProfile implements UniversityComparator{
    @Override
    public String toString() {
        return "UniversityComparatorMainProfile";
    }

    @Override
    public int compare(University university1, University university2) {
        return StringUtils.compare(university1.getMainProfile().getProfileName(),university2.getMainProfile().getProfileName());
    }
}
