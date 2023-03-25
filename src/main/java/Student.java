import com.fasterxml.jackson.annotation.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "studentEntry")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fullName", "universityId","avgExamScore"})

@JsonRootName(value = "studentEntry")
@JsonPropertyOrder({"fullName", "universityId","avgExamScore"})
public class Student {
    @XmlElement(name = "studentName")
    private String fullName;
    @XmlElement(name = "universityId")
    private String universityId;
    @XmlTransient
    @JsonIgnore
    private  int currentCourseNumber;
    @XmlElement(name = "avgScore")
    private float avgExamScore;

    public Student(){
    }

    @JsonIgnore
    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }
    @JsonGetter("studentName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @JsonGetter("universityId")
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
    @JsonGetter("avgScore")
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
