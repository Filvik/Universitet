import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class ReadingAFile {

    private static final String file = "D:\\Flash drive\\new Computer\\idea\\.gradle\\module_gradle\\universitet\\src\\main\\resources\\universityInfo.xlsx";
    private static final String nameSheetStudents = "Студенты";
    private static final String nameSheetUniversitets = "Университеты";

    private ReadingAFile() {
    }

    private static final Logger log = LoggerFactory.getLogger(ReadingAFile.class.getName());


    public static List<Student> readFromExcelStudents() {

        log.info("Получение коллекции студентов из файла.");

        List<Student> collectionStudents = new ArrayList<>();

        try {
            XSSFWorkbook myExcelBookStudents = new XSSFWorkbook(
                    new FileInputStream(file));
            log.info("Читаем данные из файла " + file);
            XSSFSheet myExcelSheet = myExcelBookStudents.getSheet(nameSheetStudents);
            log.info("Читаем данные с листа " + nameSheetStudents);
            //Итератор по строке.
            Iterator<Row> rowIterator = myExcelSheet.iterator();
            //Пропускаем заголовок таблицы.
            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //Итератор по всем ячейкам в строке.
                Iterator<Cell> cellIterator = row.cellIterator();

                Student student = new Student();
                int i = 0;

                // Для каждой строки все столбцы.
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    //Заполнение полей данных студентов.
                    switch (i) {

                        case 0 -> student.setUniversityId(cell.getStringCellValue());

                        case 1 -> student.setFullName(cell.getStringCellValue());

                        case 2 -> student.setCurrentCourseNumber((int) cell.getNumericCellValue());

                        case 3 -> student.setAvgExamScore((float) cell.getNumericCellValue());
                    }
                    i++;
                }
                collectionStudents.add(student);
            }
            //Закрываем чтение файла.
            myExcelBookStudents.close();
        } catch (IOException exception) {
            log.error("Ошибка " + exception);
        }
        log.info("Возвращаем получившуюся коллекцию студентов.");
        return collectionStudents;
    }


    public static List<University> readFromExcelUniversitets() {

        log.info("Получение коллекции университетов из файла.");

        List<University> collectionUniversity = new ArrayList<>();

        try {
            XSSFWorkbook myExcelBookUniversity = new XSSFWorkbook(
                    new FileInputStream(file));
            log.info("Читаем данные из файла " + file);
            XSSFSheet myExcelSheet = myExcelBookUniversity.getSheet(nameSheetUniversitets);
            log.info("Читаем данные с листа " + nameSheetUniversitets);
            //Итератор по строке.
            Iterator<Row> rowIterator = myExcelSheet.iterator();
            //Пропускаем заголовок таблицы.
            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //Итератор по всем ячейкам в строке.
                Iterator<Cell> cellIterator = row.cellIterator();

                University university = new University();
                int i = 0;

                // Для каждой строки все столбцы.
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    //Заполнение полей данных студентов.
                    switch (i) {

                        case 0 -> university.setId(cell.getStringCellValue());

                        case 1 -> university.setFullName(cell.getStringCellValue());

                        case 2 -> university.setShortName(cell.getStringCellValue());

                        case 3 -> university.setYearOfFoundation((int) cell.getNumericCellValue());

                        case 4 -> {
                            try {
                                university.setMainProfile(StudyProfile.valueOf(cell.getStringCellValue()));
                            } catch (IllegalArgumentException exception) {
                                log.error("Ошибка " + exception);
                            }
                        }
                    }
                    i++;
                }
                collectionUniversity.add(university);
            }
            //Закрываем чтение файла.
            myExcelBookUniversity.close();
        } catch (IOException exception) {
            log.error("Ошибка " + exception);
        }
        log.info("Возвращаем получившуюся коллекцию университетов.");
        return collectionUniversity;
    }
}




