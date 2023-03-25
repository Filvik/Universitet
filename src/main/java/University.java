import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "universityEntry")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "fullName","mainProfile" })
@JsonPropertyOrder({"id", "fullName","mainProfile"})
public class University {
    @XmlElement(name = "universityId")
    private String id;
    @XmlElement(name = "universityName")
    private String fullName;
    @XmlTransient
    @JsonIgnore
    private String shortName;
    @XmlTransient
    @JsonIgnore
    private int yearOfFoundation;
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    @JsonGetter("universityId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonGetter("universityName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }
    @JsonGetter("universityProfile")
    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University {\n" +
                "id = " + id + "\n" +
                "fullName = " + fullName + '\n' +
                "shortName = " + shortName + '\n' +
                "yearOfFoundation = " + yearOfFoundation + '\n' +
                "mainProfile = " + mainProfile + '\n' +
                "}\n";
    }
}
