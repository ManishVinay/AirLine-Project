package org.task;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TuiAirLine extends Base {
public static void main(String[] args) throws Throwable {

	browserLaunch();
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	webPage("https://en.tuifly.com");
	

WebElement from = findXpath("(//input[@type='text'])[6]");
	textValue(from, getData(1, 0));
	
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	
	WebElement to = findXpath("(//input[@type='text'])[7]");
	textValue(to, getData(1, 1));
	
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	
	Thread.sleep(2000);
	
	
	WebElement depart = findXpath("(//input[@type='text'])[8]");
	btnClick(depart);

	
	WebElement trip = findXpath("(//label[text()='One-way flight'])[5]");
	btnClick(trip);
	
	WebElement date = findXpath("(//li[@data-date='2019-10-02'])[2]");
	btnClick(date);
	
	WebElement search = findXpath("//span[text()=' Search']");
	btnClick(search);
	
	Thread.sleep(4000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	WebElement contnue = findXpath("//span[text()='Continue']");
	js.executeScript("arguments[0].click()", contnue);
	
		Thread.sleep(4000);
		
		WebElement next = findXpath("//font[text()='Next']");
		js.executeScript("arguments[0].click()", next);
	
		WebElement noLuggage = findXpath("(//button[@type='button'])[1]");
		js.executeScript("arguments[0].click()", noLuggage);
		
			Thread.sleep(4000);
	
			WebElement mr = findXpath("//select[@class='textS2'][1]");
			
			
	Select s = new Select(mr);
	s.selectByVisibleText("Mrs.");
	
	
	WebElement firstName = findXpath("(//input[@type='text'])[2]");
	textValue(firstName, getData(1, 2));
	
	WebElement lastName = findXpath("(//input[@type='text'])[3]");
	textValue(lastName, getData(1, 3));
	
	
	WebElement address = findXpath("(//input[@type='text'])[5]");
	textValue(address, getData(1, 4));
	
	WebElement pCode = findXpath("(//input[@type='text'])[7]");
	textValue(pCode, getData(1, 5));
	
	WebElement location = findXpath("(//input[@type='text'])[8]");
	textValue(location, getData(1, 6));
	
	
	WebElement phone = findXpath("(//input[@type='text'])[9]");
	textValue(phone, getData(1, 7));
	
	
	WebElement eMail = findXpath("(//input[@type='text'])[10]");
	textValue(eMail, getData(1, 8));
	
	WebElement Contry = findXpath("//select[@requirederror='Country is required.']");
	Select c=new Select(Contry);
	c.selectByVisibleText("India, Republic of");
	
	WebElement mr1 = findXpath("(//select[@class='textS2'])[2]");
Select m=new Select(mr1);

Thread.sleep(8000);

WebElement fName = findXpath("(//input[@type='text'])[12]");
textValue(fName, getData(1, 9));

WebElement lName = findXpath("(//input[@type='text'])[14])");
textValue(lName, getData(1, 10));

WebElement visa = findXpath("(//input[@type='radio'])[6]");
js.executeScript("arguments[0].click()", visa);

WebElement ccNo = findXpath("(//input[@type='text'])[16]");
ccNo.sendKeys("5172527315024797");



Thread.sleep(4000);

WebElement ccName = findXpath("(//input[@type='text'])[17]");
textValue(ccName, getData(1, 11));

WebElement mnth =findXpath ("(//select[@class='lowMid3'])[1]");
Select k = new Select(mnth);
k.selectByVisibleText("02");


WebElement year = findXpath("(//select[@class='lowMid3'])[2]");
Select h = new Select(year);
h.selectByVisibleText("2020");


WebElement cvv = findXpath("(//input[@type='text'])[18]");
textValue(cvv, getData(1, 12));


WebElement check = findXpath("(//input[@type='checkbox'])[5]");
js.executeScript("arguments[0].click()", check);

Thread.sleep(3000);

WebElement pay = findXpath("//span[text()='Book and pay']");
Thread.sleep(2000);
js.executeScript("arguments[0].click()", pay);


}
}
