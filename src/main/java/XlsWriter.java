import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.logging.Logger;

public class XlsWriter {

    private static final Logger log = Logger.getLogger(XlsWriter.class.getName());

    void assemblyGenerationMethod(List<Statistics> collection, String thePathToTheFile) {

        log.info("Получена коллекция из " + collection.size() + " элементов для заполнения нового файла.");

        try (OutputStream fileOut = new FileOutputStream(thePathToTheFile)) {

            //Создание книги.
            XSSFWorkbook workbook = new XSSFWorkbook();

            // Создание листа.
            Sheet sheet = workbook.createSheet("Statistics");

            // Создание строки для заголовков таблицы.
            Row row = sheet.createRow(0);

            // Создание ячеек для заголовков таблицы.
            Cell cellA1 = row.createCell(0);
            Cell cellB1 = row.createCell(1);
            Cell cellC1 = row.createCell(2);
            Cell cellD1 = row.createCell(3);
            Cell cellE1 = row.createCell(4);

            // Создание стиля.
            CellStyle style = workbook.createCellStyle();

            cellA1.setCellValue("Профиль обучения");
            cellB1.setCellValue("Средний балл за экзамен");
            cellC1.setCellValue("Названия университетов");
            cellD1.setCellValue("Количество студентов по профилю");
            cellE1.setCellValue("Количество университетов по профилю");

            // Задание шрифта и его настройка.
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 12);
            font.setFontName("Times new roman");
            font.setItalic(true);
            font.setBold(true);

            // Применение шрифта к стилю.
            style.setFont(font);

            // Применение стиля к ячейкам.
            cellA1.setCellStyle(style);
            cellB1.setCellStyle(style);
            cellC1.setCellStyle(style);
            cellD1.setCellStyle(style);
            cellE1.setCellStyle(style);


            //Заполнение файла значениями коллекции.
            populatingCollection(collection,sheet);

            // Создание файла по сгенерированной книге.
            workbook.write(fileOut);
            log.fine("Сгенерирован файл " + thePathToTheFile);

        } catch (Exception e) {
            log.severe("Ошибка " + e);
        }
    }

    //Метод заполнения коллекции.
    void populatingCollection(List<Statistics> collection,Sheet sheet) {

        log.info("Заполнение значениями файла из коллекции.");

        int i = 1;
        for (Statistics statistic : collection) {
            int j = 0;
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(j);
            cell.setCellValue(String.valueOf(statistic.getMainProfile()));
            cell = row.createCell(++j);
            cell.setCellValue(String.valueOf(statistic.getAvgExamScore()));
            cell = row.createCell(++j);
            cell.setCellValue(statistic.getFullNameUniversity().toString());
            cell = row.createCell(++j);
            cell.setCellValue(statistic.getNumberOfStudentsByProfile());
            cell = row.createCell(++j);
            cell.setCellValue(statistic.getNumberOfUniversityByProfile());
            i++;
        }
        log.fine("Файл заполнен значениями!");
    }
}
