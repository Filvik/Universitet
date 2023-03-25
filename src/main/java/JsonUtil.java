import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class JsonUtil {

    public JsonUtil() {
    }

    private static Type type;
    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Logger log = Logger.getLogger(JsonUtil.class.getName());
    private static Class nameClass;

    //Сериализация объекта неопределенного класса.
    public static String serializationObject(Object object) {

        log.info("Сериализация объекта класса : " + object.getClass());

        return gson.toJson(object, nameClass = object.getClass());

    }

    //Десериализация объекта неопределенного класса.
    public static Object deserializationObject(String prettyJsonString) {

        log.info("Десериализация объекта класса : " + nameClass);

        return gson.fromJson(prettyJsonString, nameClass);
    }

    //Сериализация коллекции объктов неопределенного класса.
    public static String serializationForObjectCollection(List<?> objects) {

        log.info("Сериализация коллекции объектов класса : " + objects.get(0).getClass());

        if (objects.get(0).getClass() == Student.class) {
            type = new TypeToken<List<Student>>() {
            }.getType();

        } else if (objects.get(0).getClass() == University.class) {
            type = new TypeToken<List<University>>() {
            }.getType();

        } else if (objects.get(0).getClass() == Statistics.class) {
            type = new TypeToken<List<Statistics>>() {
            }.getType();

        } else {
            log.severe("Объект не может быть сериализован!");
            return null;
        }

        return gson.toJson(objects, type);
    }

    //Десериализация коллекции объктов неопределенного класса.
    public static ArrayList<?> deserializationForObjectCollection(String prettyJsonString) {

        log.info("Десериализация коллекции объектов типа : " + type);

        return gson.fromJson(prettyJsonString, type);
    }

    //Сериализация созданной классовой структуры.
    public static String serializationForObjectWrappers(ObjectWrappers wrapper) {

        log.info("Объект класса ObjectWrappers сериализуется.");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonString = null;
        try {
            jsonString = ow.writeValueAsString(wrapper);
        } catch (JsonProcessingException exception) {
            log.severe("Ошибка " + exception);
        }
        return jsonString;
    }

    //Десериализация созданной классовой структуры.
    public static ObjectWrappers deserializationForObjectWrappers(String prettyJsonString) {

        log.info("Объект класса ObjectWrappers десериализуется.");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return mapper.readValue(prettyJsonString, ObjectWrappers.class);
        } catch (JsonProcessingException exception) {
            log.severe("Ошибка " + exception);
            return null;
        }
    }
}
