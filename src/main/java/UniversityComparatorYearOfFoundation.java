public class UniversityComparatorYearOfFoundation implements UniversityComparator{
    @Override
    public String toString() {
        return "UniversityComparatorYearOfFoundation";
    }

    @Override
    public int compare(University university1, University university2) {
        return Integer.compare(university1.getYearOfFoundation(),university2.getYearOfFoundation());
    }
}
