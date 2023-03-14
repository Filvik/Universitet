

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class ProcessingCollectionStudentsAndUniversities {

    private static final Logger log = LoggerFactory.getLogger(ProcessingCollectionStudentsAndUniversities.class.getName());

    //Метод преобразующий коллекции студентов и университетов в коллекцию класса Statistics.
    List<Statistics> statisticsConverter(List<Student> students, List<University> universities) {

        log.info("Получаем из коллекции студентов и университетов коллекцию статистики.");

        try {
            return Arrays.stream(StudyProfile.values())
                    //Фильтрация профиля обучения,по которому есть хотя бы один университет.
                    .filter(profile -> universities.stream().anyMatch(university -> university.getMainProfile() == profile))
                    .map(profile -> {

                        //Рассчитываем статистику для каждого профиля:
                        // Средний бал студентов.
                        float[] avgExamScore = new float[1];
                        // Количество студентов по профилю.
                        int[] counter = new int[1];
                        // Коллекция университетов с одинаковым профилем обучения.

                        List<String> fullName = universities.stream()
                                .filter(prof -> (prof.getMainProfile() == profile)) // Оставляем только университеты используемого профиля.
                                .peek(univ -> { // По каждому из университетов, отфильтрованных по профилю.
                                    students.stream()
                                            .filter(stud -> univ.getId().equals(stud.getUniversityId())) // Фильтруем студентов, относящихся к университету из фильтра.
                                            .forEach(st -> { // Суммируем средний балл и количество.
                                                avgExamScore[0] += st.getAvgExamScore();
                                                counter[0]++;
                                            });
                                })
                                .map(University::getFullName)// Cобираем названия отфильтрованных университетов в коллекцию.
                                .collect(Collectors.toList());

                        //Расчитываем средний бал.
                        BigDecimal decimal;
                        if (counter[0] == 0) {
                            decimal = BigDecimal.valueOf(0);
                        } else {
                            decimal = BigDecimal.valueOf(avgExamScore[0] / counter[0]).setScale(3, RoundingMode.CEILING);
                        }
                        log.info("Добавляем получившийся элемент статистики.");
                        return new Statistics(profile, decimal.doubleValue(), fullName, counter[0], fullName.size());
                    }).toList();
        }
        catch (Exception exception){
            log.error("Ошибка " + exception);
            return null;
        }
    }
}
