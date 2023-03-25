import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class DateAdapter extends XmlAdapter<String, Date>{
    private final String pattern = "yyyy-MM-dd HH:mm:ss";
    private static final Logger log = Logger.getLogger(DateAdapter.class.getName());

    @Override
    public Date unmarshal(String dateStr) {
        try {
            return new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            log.severe("Ошибка " + e);
            return null;
        }
    }
    @Override
    public String marshal(Date date) {
        return new SimpleDateFormat(pattern).format(date);
    }

}