import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReadingAFile {

    private ReadingAFile() {
    }

    public static List<Student> readFromExcelStudents() {

        List<Student> collectionStudents = new ArrayList<>();

        try {
            XSSFWorkbook myExcelBookStudents = new XSSFWorkbook(
                    new FileInputStream("D:\\Флешка\\Перенос на новый комп\\idea\\.gradle\\module_gradle\\universitet\\src\\main\\resources\\universityInfo.xlsx"));
            XSSFSheet myExcelSheet = myExcelBookStudents.getSheet("Студенты");

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
            System.out.println("Ошибка " + exception);
        }
        return collectionStudents;
    }


    public static List<University> readFromExcelUniversitets() {

        List<University> collectionUniversity = new ArrayList<>();

        try {
            XSSFWorkbook myExcelBookUniversity = new XSSFWorkbook(
                    new FileInputStream("D:\\Флешка\\Перенос на новый комп\\idea\\.gradle\\module_gradle\\universitet\\src\\main\\resources\\universityInfo.xlsx"));
            XSSFSheet myExcelSheet = myExcelBookUniversity.getSheet("Университеты");

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
                                System.out.println("Неизвестный тип StudyProfile для " + university.getFullName());
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
            System.out.println("Ошибка " + exception);
        }
        return collectionUniversity;
    }
}




