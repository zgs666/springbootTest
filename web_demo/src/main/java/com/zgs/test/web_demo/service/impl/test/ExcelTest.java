package com.zgs.test.web_demo.service.impl.test;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author zgs
 * @date 2021年10月29日 12:42:00
 */
public class ExcelTest {
    public static void main(String[] args) throws Exception {
        createExport();
    }
    public static void createExport() throws Exception{
        File localObject = new File("C:\\zhangguisong");
        FileOutputStream localFileOutputStream = new FileOutputStream(localObject);
        try {
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet  sheet = workBook.createSheet("test");
            HSSFCellStyle  cellStyle = workBook.createCellStyle();
            HSSFCellStyle  cellStyle1 = workBook.createCellStyle();
            HSSFCellStyle  cellStyle2 = workBook.createCellStyle();
            cellStyle.setFillBackgroundColor(HSSFColor.GREY_40_PERCENT.index);
            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            HSSFFont font2 = workBook.createFont();
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font2.setFontHeightInPoints((short) 12);
            cellStyle2.setFont(font2);
            cellStyle1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cellStyle1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyle1.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyle1.setBorderRight(HSSFCellStyle.BORDER_THIN);

            HSSFRow  row = sheet.createRow(0);
            row.createCell(0).setCellValue("\u5c42\u6b21");
            row.createCell(0).setCellStyle(cellStyle1);
            row.createCell(0).setCellStyle(cellStyle2);
            row.createCell(1).setCellValue("\u96f6\u7ec4\u4ef6\u7f16\u53f7");
            row.createCell(1).setCellStyle(cellStyle1);
            row.createCell(1).setCellStyle(cellStyle2);
            row.createCell(2).setCellValue("\u7248\u6b21");
            row.createCell(2).setCellStyle(cellStyle1);
            row.createCell(2).setCellStyle(cellStyle2);
            row.createCell(3).setCellValue("\u96f6\u7ec4\u4ef6\u540d\u79f0");
            row.createCell(3).setCellStyle(cellStyle1);
            row.createCell(3).setCellStyle(cellStyle2);
            row.createCell(4).setCellValue("\u6570\u91cf");
            row.createCell(4).setCellStyle(cellStyle1);
            row.createCell(4).setCellStyle(cellStyle2);
            row.createCell(5).setCellValue("\u4e0b\u7ea7\u5de5\u7a0b\u7ec4\u4ef6");
            row.createCell(5).setCellStyle(cellStyle1);
            row.createCell(5).setCellStyle(cellStyle2);
            row.createCell(6).setCellValue("\u96f6\u4ef6\u4ee3\u7801");
            row.createCell(6).setCellStyle(cellStyle1);
            row.createCell(6).setCellStyle(cellStyle2);
            row.createCell(7).setCellValue("\u5236\u9020\u5355\u4f4d");
            row.createCell(7).setCellStyle(cellStyle1);
            row.createCell(7).setCellStyle(cellStyle2);
            row.createCell(8).setCellValue("\u4f7f\u7528\u5355\u4f4d");
            row.createCell(8).setCellStyle(cellStyle1);
            row.createCell(8).setCellStyle(cellStyle2);
            row.createCell(9).setCellValue("\u5907\u6ce8");
            row.createCell(9).setCellStyle(cellStyle1);
            row.createCell(9).setCellStyle(cellStyle2);
            HSSFRow  row1 = sheet.createRow(2);
            row1.createCell(0).setCellValue("");
            row1.createCell(0).setCellStyle(cellStyle);
            row1.createCell(0).setCellStyle(cellStyle1);
            row1.createCell(1).setCellValue("");
            row1.createCell(1).setCellStyle(cellStyle1);
            row1.createCell(1).setCellStyle(cellStyle);
            row1.createCell(2).setCellValue("");
            row1.createCell(2).setCellStyle(cellStyle1);
            row1.createCell(2).setCellStyle(cellStyle);
            row1.createCell(3).setCellValue("");
            row1.createCell(3).setCellStyle(cellStyle1);
            row1.createCell(3).setCellStyle(cellStyle);
            row1.createCell(4).setCellValue("");
            row1.createCell(4).setCellStyle(cellStyle1);
            row1.createCell(4).setCellStyle(cellStyle);
            row1.createCell(5).setCellValue("");
            row1.createCell(5).setCellStyle(cellStyle1);
            row1.createCell(5).setCellStyle(cellStyle);
            row1.createCell(6).setCellValue("");
            row1.createCell(6).setCellStyle(cellStyle1);
            row1.createCell(6).setCellStyle(cellStyle);
            row1.createCell(7).setCellValue("");
            row1.createCell(7).setCellStyle(cellStyle1);
            row1.createCell(7).setCellStyle(cellStyle);
            row1.createCell(8).setCellValue("");
            row1.createCell(8).setCellStyle(cellStyle1);
            row1.createCell(8).setCellStyle(cellStyle);
            row1.createCell(9).setCellValue("\u5236\u9020\u90e8\u6bb5");
            row1.createCell(9).setCellStyle(cellStyle);
            row1.createCell(9).setCellStyle(cellStyle1);

            workBook.write(localFileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            localFileOutputStream.close();
        }
    }
}
