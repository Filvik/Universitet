import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("fullNameStudent")
    private String fullName;
    @SerializedName("universityIdStudent")
    private String universityId;
    @SerializedName("currentCourseNumberStudent")
    private  int currentCourseNumber;
    @SerializedName("avgExamScoreStudent")
    private float avgExamScore;

    public Student(){

    };
    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "Student {\n" +
                "fullName = " + fullName + '\n' +
                "universityId = " + universityId + "\n" +
                "currentCourseNumber = " + currentCourseNumber + '\n' +
                "avgExamScore = " + avgExamScore + '\n' +
                "}\n";
    }
}
