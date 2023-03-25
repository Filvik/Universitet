import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "statisticsEntry")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "mainProfile", "avgExamScore" })
@JsonPropertyOrder({"mainProfile", "avgExamScore"})
public class Statistics{
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;
    @XmlElement(name = "avgScore")
    private double avgExamScore;
    @XmlTransient
    @JsonIgnore
    private List<String> fullNameUniversity;
    @XmlTransient
    @JsonIgnore
    private int numberOfStudentsByProfile;
    @XmlTransient
    @JsonIgnore
    private int numberOfUniversityByProfile;

    public Statistics() {
    }

    public Statistics(StudyProfile mainProfile, double avgExamScore, List<String> fullNameUniversity, int numberOfStudentsByProfile, int numberOfUniversitetsByProfile) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.fullNameUniversity = fullNameUniversity;
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        this.numberOfUniversityByProfile = numberOfUniversitetsByProfile;
    }
    @JsonGetter("universityProfile")
    public StudyProfile getMainProfile() {
        return mainProfile;
    }


    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }
    @JsonGetter("avgScore")
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

    @Override
    public String toString() {
        return "Statistics{" +
                "mainProfile=" + mainProfile +
                ", avgExamScore=" + avgExamScore +
                ", fullNameUniversity=" + fullNameUniversity +
                ", numberOfStudentsByProfile=" + numberOfStudentsByProfile +
                ", numberOfUniversityByProfile=" + numberOfUniversityByProfile +
                '}';
    }
}
