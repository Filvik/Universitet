import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class WritingJSONFilesFromJava implements WritingFiles {
    private static final Logger log = Logger.getLogger(WritingXMLFilesFromJava.class.getName());
    private static final String path = "D:/Flash drive/new Computer/idea/.gradle/module_gradle/universitet/src/main/jsonReqs";

    @Override
    public String convertObject(ObjectWrappers wrapper){

        log.info("Запись JSON-файлов для Java-класса ObjectWrappers");

        try {
            //Создаем директорию.
            Files.createDirectories(Paths.get(path));
        } catch (IOException exception) {
            log.severe("Ошибка " + exception);
        }
        //Генерируем json строку.
        String jsonString = JsonUtil.serializationForObjectWrappers(wrapper);

        // Пишем её в файл.
        try (PrintWriter out = new PrintWriter(new FileWriter(path + "/req.json"))) {
            out.write(jsonString);
            //Пишем её в консоль.
            //System.out.println(jsonString);
        } catch (Exception exception) {
            log.severe("Ошибка " + exception);
        }
        return jsonString;
    }
}
