import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;
public class WritingXMLFilesFromJava implements WritingFiles {
    private static final Logger log = Logger.getLogger(WritingXMLFilesFromJava.class.getName());
    private static final String path = "D:/Flash drive/new Computer/idea/.gradle/module_gradle/universitet/src/main/xmlReqs";

    public String convertObject(ObjectWrappers wrapper) {

        log.info("Запись XML-файлов для Java-класса ObjectWrappers");

        try {
            //Создаем директорию.
            Files.createDirectories(Paths.get(path));
            // Создаем объект JAXBContext - точку входа для JAXB
            JAXBContext context = JAXBContext.newInstance(ObjectWrappers.class);
            Marshaller marshaller = context.createMarshaller();
            // Устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Маршаллинг объекта в файл.
            marshaller.marshal(wrapper, new File(path + "/req.xml"));
            // Маршаллинг объекта в консоль.
            //marshaller.marshal(wrapper, System.out);
        } catch (JAXBException | IOException exception) {
            log.severe("Ошибка " + exception);
        }
        return null;
    }
}
