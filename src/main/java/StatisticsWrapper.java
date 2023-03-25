import com.fasterxml.jackson.annotation.JsonGetter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "statisticalInfo")
public class StatisticsWrapper implements Wrappers {
    private List<Statistics> wrapper = null;
    @XmlElement(name = "statisticsEntry")
    @JsonGetter("Statistic")
    public List<Statistics> getWrapper() {
        return wrapper;
    }

    public void setWrapper(List<Statistics> wrapper) {
        this.wrapper = wrapper;
    }
}
