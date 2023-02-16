import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String serializationForStudent(Student student) {

        return gson.toJson(student);
    }

    public static Student deserializationForStudent(String prettyJsonString) {

        return gson.fromJson(prettyJsonString, Student.class);
    }

    public static String serializationForUniversity(University university) {

        return gson.toJson(university);
    }

    public static University deserializationForUniversity(String prettyJsonString) {

        return gson.fromJson(prettyJsonString, University.class);
    }


    public static String serializationForStudentsCollection(List<Student> student) {

        return gson.toJson(student);
    }

    public static ArrayList<Student> deserializationForStudentsCollection(String prettyJsonString) {

        return gson.fromJson(prettyJsonString, new TypeToken<ArrayList<Student>>() {
        }.getType());
    }

    public static String serializationForUniversityCollection(List<University> university) {

        return gson.toJson(university);
    }

    public static ArrayList<University> deserializationForUniversityCollection(String prettyJsonString) {

        return gson.fromJson(prettyJsonString, new TypeToken<ArrayList<University>>() {
        }.getType());
    }
}
