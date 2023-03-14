import java.util.List;

public class Statistics {
    private StudyProfile mainProfile;
    private double avgExamScore;
    private List<String> fullNameUniversity;
    private int numberOfStudentsByProfile;
    private int numberOfUniversityByProfile;

    public Statistics(StudyProfile mainProfile, double avgExamScore, List<String> fullNameUniversity, int numberOfStudentsByProfile, int numberOfUniversitetsByProfile) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.fullNameUniversity = fullNameUniversity;
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        this.numberOfUniversityByProfile = numberOfUniversitetsByProfile;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }


    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public List<String> getFullNameUniversity() {
        return fullNameUniversity;
    }

    public void setFullNameUniversity(List<String> fullNameUniversity) {
        this.fullNameUniversity = fullNameUniversity;
    }

    public int getNumberOfStudentsByProfile() {
        return numberOfStudentsByProfile;
    }

    public void setNumberOfStudentsByProfile(int numberOfStudentsByProfile) {
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
    }

    public int getNumberOfUniversityByProfile() {
        return numberOfUniversityByProfile;
    }

    public void setNumberOfUniversityByProfile(int numberOfUniversityByProfile) {
        this.numberOfUniversityByProfile = numberOfUniversityByProfile;
    }
}
