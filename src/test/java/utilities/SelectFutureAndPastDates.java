package utilities;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.TestAutomationWebsite;

public class SelectFutureAndPastDates extends BaseClass {

	public static void compare_convertToDateFormat(String date, WebDriver driver){

		LocalDate date1 = LocalDate.now();
		//int sampleDate=2025-06-23;
		LocalDate date2 = LocalDate.parse(date);
/*
		System.out.println(date1.isBefore(date2));
		System.out.println(date1.isEqual(date2));
		System.out.println(date1.isAfter(date2));*/

		if(date1.isBefore(date2)) {
			// Get day from date
			int day = date2.getDayOfMonth();
			String dayString = Integer.toString(day);
			//System.out.println(dayString);

			// Get month from date
			Month month = date2.getMonth();
			String monthString = month.toString();
			//System.out.println(monthString);

			String monthString2 = monthString.toLowerCase();
			String monthString3 = monthString2.substring(0, 1).toUpperCase() + monthString2.substring(1);
			//System.out.println("monthString2 : "+ monthString2);

			// Get year from date
			int year = date2.getYear();
			String YearString = Integer.toString(year);
			//System.out.println(YearString);

			SelectFutureAndPastDates.selectFutureDate(driver, monthString3, dayString, YearString);
		}
		else {

			// Get day from date
			int day = date2.getDayOfMonth();
			String dayString = Integer.toString(day);

			// Get month from date
			Month month = date2.getMonth();
			String monthString = month.toString();

			// Get year from date
			int year = date2.getYear();
			String YearString = Integer.toString(year);


			// Print the day, month, and year
			System.out.println("Day: " + day);
			System.out.println("Month: " + month);
			System.out.println("Year: " + year);
			SelectFutureAndPastDates.selectPastDate(driver, monthString, dayString, YearString);
		}


	}
	
	static void selectFutureDate(WebDriver driver, String month, String date, String year) {
		//driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		while(true) {
	/*		String currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();*/
			TestAutomationWebsite testautomation = new TestAutomationWebsite(driver);
			String currentmonth = testautomation.getMonth();
			String currentyear = testautomation.getYear();
			
			if(currentmonth.equals(month) && currentyear.equals(year)) {
				break;
			}
			
			//Selecting future date
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();	

		}
		
		//selecting date
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		
		for(WebElement dt:alldates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
		
	}
	
	static void selectPastDate(WebDriver driver, String month, String date, String year) {
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		while(true) {
			String currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(currentmonth.equals(month) && currentyear.equals(year)) {
				break;
			}
	
			
			//Selecting past date
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();	
		}
		
		//selecting date
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		
		for(WebElement dt:alldates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}
	
	static Month convertMonth(String month) {
		
		HashMap<String, Month> monthmap = new HashMap<String, Month>();
		monthmap.put("January", Month.JANUARY);
		monthmap.put("February", Month.FEBRUARY);
		monthmap.put("March", Month.MARCH);
		monthmap.put("April", Month.APRIL);
		monthmap.put("May", Month.MAY);
		monthmap.put("June", Month.JUNE);
		monthmap.put("July", Month.JULY);
		monthmap.put("August", Month.AUGUST);
		monthmap.put("September", Month.SEPTEMBER);
		monthmap.put("October", Month.OCTOBER);
		monthmap.put("November", Month.NOVEMBER);
		monthmap.put("December", Month.AUGUST);
		
		Month vmonth = monthmap.get(month);
		
		if(vmonth == null) {
			System.out.println("Invalid Month....");
			
		}
		
		return vmonth;
		
	}
	
	static Month convertMonthshortform(String month) {
		
		HashMap<String, Month> monthmap = new HashMap<String, Month>();
		monthmap.put("Jan", Month.JANUARY);
		monthmap.put("Feb", Month.FEBRUARY);
		monthmap.put("Mar", Month.MARCH);
		monthmap.put("Apr", Month.APRIL);
		monthmap.put("May", Month.MAY);
		monthmap.put("Jun", Month.JUNE);
		monthmap.put("Jul", Month.JULY);
		monthmap.put("Aug", Month.AUGUST);
		monthmap.put("Sep", Month.SEPTEMBER);
		monthmap.put("Oct", Month.OCTOBER);
		monthmap.put("Nov", Month.NOVEMBER);
		monthmap.put("Dec", Month.AUGUST);
		
		Month vmonth = monthmap.get(month);
		
		if(vmonth == null) {
			System.out.println("Invalid Month....");
			
		}
		
		return vmonth;
		
	}

}
