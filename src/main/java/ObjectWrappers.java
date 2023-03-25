import com.fasterxml.jackson.annotation.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "root")
@XmlType(propOrder = {"studentsInfo", "universitiesInfo", "statisticalInfo", "processedAt"})
@JsonRootName(value = "root")
@JsonPropertyOrder({"studentsInfo", "universitiesInfo", "statisticalInfo", "processedAt"})
public class ObjectWrappers {

    StudentWrapper studentsInfo = new StudentWrapper();
    UniversityWrapper universitiesInfo = new UniversityWrapper();
    StatisticsWrapper statisticalInfo = new StatisticsWrapper();
    private Date processedAt;

    public void union(StudentWrapper studentWrapper, UniversityWrapper universityWrapper, StatisticsWrapper statisticsWrapper, Date date) {
        setStudentsInfo(studentWrapper);
        setUniversitiesInfo(universityWrapper);
        setStatisticalInfo(statisticsWrapper);
        setProcessedAt(date);
    }


    public Date getProcessedAt() {
        return processedAt;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setProcessedAt(Date processedAt) {
        this.processedAt = processedAt;
    }
    @JsonGetter("Students")
    public StudentWrapper getStudentsInfo() {
        return studentsInfo;
    }

    public void setStudentsInfo(StudentWrapper studentsInfo) {
        this.studentsInfo = studentsInfo;
    }
    @JsonGetter("Universities")
    public UniversityWrapper getUniversitiesInfo() {
        return universitiesInfo;
    }

    public void setUniversitiesInfo(UniversityWrapper universitiesInfo) {
        this.universitiesInfo = universitiesInfo;
    }
    @JsonGetter("Statistics")
    public StatisticsWrapper getStatisticalInfo() {
        return statisticalInfo;
    }

    public void setStatisticalInfo(StatisticsWrapper statisticalInfo) {
        this.statisticalInfo = statisticalInfo;
    }
}

