import com.fasterxml.jackson.annotation.JsonGetter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "universitiesInfo")
public class UniversityWrapper implements Wrappers {

    private ArrayList<University> wrapper = null;
    @XmlElement(name = "universityEntry")
    @JsonGetter("University")
    public ArrayList<University> getWrapper() {
        return wrapper;
    }

    public void setWrapper(ArrayList<University> wrapper) {
        this.wrapper = wrapper;
    }
}
