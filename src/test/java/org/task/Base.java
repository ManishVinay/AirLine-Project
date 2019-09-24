package org.task;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import com.google.common.io.Files;

public class Base {

		public static WebDriver driver;
	public static WebDriver browserLaunch() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\Downloads\\eclipse\\project\\AirLine\\driver\\chromedriver.exe");
			
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
			}
	    public static void webPage(String n) {
			driver.get(n);}
	    public static void endPage() {
			driver.quit();}
	    public static WebElement findIdBath(String value) {
			WebElement loc1 = driver.findElement(By.id(value));
			return loc1;}
	    public static WebElement findClassBath(String value) {
			WebElement loc2 = driver.findElement(By.className(value));
			return loc2;}
		public static WebElement findXpath(String value) {
			WebElement loc3 = driver.findElement(By.xpath(value));
			return loc3;}
		public static void textValue(WebElement e, String value) {
			e.sendKeys(value);}
		public static void btnClick(WebElement e) {
			e.click();}
		public static void scrShot(String path) throws IOException {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File s = tk.getScreenshotAs(OutputType.FILE);
			File d = new File(path);
			FileUtils.copyFile(s, d);
			}
		public static String parentWindow() {
			String pw = driver.getWindowHandle();
			return pw;}
		public static Set<String> allWindow() {
			Set<String> aw = driver.getWindowHandles();
			return aw;}
		public static String getData(int rowNo, int cellNo) throws Throwable {
			String name=null;
			File loc = new File("C:\\Users\\Admin\\Downloads\\eclipse\\project\\AirLine\\testdata\\Book1 (Autosaved).xlsx");
			FileInputStream stream = new FileInputStream(loc);
			Workbook w = new XSSFWorkbook(stream);
			Sheet s = w.getSheet("Manish");
			Row row = s.getRow(rowNo);
			Cell cell = row.getCell(cellNo);
			int type = cell.getCellType();
			if (type==1) {
				 name = cell.getStringCellValue();
			}
			else if (type==0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yy");
					  name = sim.format(dateCellValue);
					}
				else {
					double d = cell.getNumericCellValue();
					long u = (long) d;
					 name = String.valueOf(u);
				}
			}

			return name;
			
		
		}
}