package utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData(String fileName, String sheetName) {

        List<Object[]> dataList = new ArrayList<>();

        try {
            InputStream is = ExcelUtils.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (is == null) {
                throw new RuntimeException(
                        "Excel file not found: " + fileName);
            }

            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet not found: " + sheetName);
            }

            DataFormatter formatter = new DataFormatter();

            int lastRow = sheet.getLastRowNum();

            // ✅ START FROM ROW 1 → SKIP HEADER
            for (int i = 1; i <= lastRow; i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                String name   = formatter.formatCellValue(row.getCell(0)).trim();
                String age    = formatter.formatCellValue(row.getCell(1)).trim();
                String mobile = formatter.formatCellValue(row.getCell(2)).trim();

                // ✅ SKIP EMPTY / INVALID ROWS
                if (name.isEmpty() || age.isEmpty() || mobile.isEmpty()) {
                    continue;
                }

                dataList.add(new Object[]{ name, age, mobile });
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ CONVERT LIST → ARRAY (NO EMPTY FIRST TEST)
        return dataList.toArray(new Object[0][0]);
    }
}
