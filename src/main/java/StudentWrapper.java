import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "studentsInfo")
@JsonRootName(value = "studentsInfo")
public class StudentWrapper implements Wrappers {

    private ArrayList<Student> wrapper = null;
    @XmlElement(name = "studentEntry")
    @JsonGetter("Student")
    public ArrayList<Student> getWrapper() {
        return wrapper;
    }

    public void setWrapper(ArrayList<Student> wrapper) {
        this.wrapper = wrapper;
    }
}
