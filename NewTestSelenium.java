package Core.java.topics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTestSelenium {
	public File f;
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public String expval,acval;
	WebDriver driver;
@Test
  public void f() throws IOException, InterruptedException {
	  f=new File("C://Softwares//locators.xlsx");
	  fi=new FileInputStream(f);
	  wb=new XSSFWorkbook(fi);
	  ws=wb.getSheetAt(0);
	  int rowcount=ws.getLastRowNum();
	  for(int i=1;i<=rowcount;i++){
		  System.setProperty("webdriver.gecko.driver","D://Maithri Vedios//geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			driver.get("https://hub.docker.com/search");
			driver.manage().window().maximize();
			expval="https://hub.docker.com/search?type=image";
			acval=driver.getCurrentUrl();
			if(expval.equals(acval)){
				ws.getRow(0).createCell(1).setCellValue("user landed in the Containers tab by default");
			}
			Thread.sleep(3000);
			String loc=ws.getRow(i).createCell(1).getStringCellValue();
			boolean flag=driver.findElement(By.xpath(loc)).isDisplayed();
			Thread.sleep(5000);
			if(flag!=true){
				ws.getRow(i).createCell(1).setCellValue("available");
				System.out.println("success");
			}else{
				ws.getRow(i).createCell(1).setCellValue("unavailable");
				System.out.println("failure");
			}
			driver.quit();
			
	  }
	  fo=new FileOutputStream(f);
	  wb.write(fo);
	  wb.close();
	  fo.close();
	}
@Test
public void f1() throws IOException, InterruptedException{
	  System.setProperty("webdriver.gecko.driver","D://Maithri Vedios//geckodriver.exe");
	  WebDriver driver=new FirefoxDriver();
	  driver.get("https://hub.docker.com/search");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@id='imageFilterList']//input[@value='store']")).click();
	  boolean flag=driver.findElement(By.xpath("//div[@class='dChip styles__chip___3ZtYi styles__clickable___1fzXr styles__withIcon___2uxjQ styles__closeFilter___1OZwH']"
)).isDisplayed();
	  if(flag==true){
		  System.out.println("Filter Publisher Content is shown at the top of the content ");
		}else{
			System.out.println("Not displayed");
		}
		driver.quit();
		
}
@Test
public void f2() throws InterruptedException, IOException{
	  System.setProperty("webdriver.gecko.driver","D://Maithri Vedios//geckodriver.exe");
      WebDriver driver=new FirefoxDriver();
      driver.get("https://hub.docker.com/search");
      driver.manage().window().maximize();
      Thread.sleep(3000); 
      driver.findElement(By.xpath("//div[@id='categoriesFilterList']//input[@value='base']"
)).click();
      driver.findElement(By.xpath("//div[@id='categoriesFilterList']//input[@value='database']")).click();
      System.out.println("clicked");
     int length=driver.findElements(By.xpath("//div[@class='dChip styles__chip___3ZtYi styles__clickable___1fzXr styles__withIcon___2uxjQ styles__closeFilter___1OZwH']")).size();
     System.out.println(length);
     if(length>2){
    	 System.out.println("Additional filters are shown at the top of the content");
     }
     else{
    	 System.out.println("There are no additional filters other than base images and databases");
     }
     driver.quit();
}
@Test
public void f3() throws InterruptedException{
	System.setProperty("webdriver.gecko.driver","D://Maithri Vedios//geckodriver.exe");
    WebDriver driver=new FirefoxDriver();
    driver.get("https://hub.docker.com/search");
    driver.manage().window().maximize();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//div[@id='categoriesFilterList']//input[@value='database']")).click();
     driver.findElement(By.xpath("//div[@class='styles__currentFilterGroup___1awKt']//div[text()='Databases']")).click();
     boolean flag=driver.findElement(By.xpath("//div[@id='categoriesFilterList']//input[@value='database']")).isSelected();
     if(flag!=true){
    	 System.out.println("checkbox of database in filter pane is also unchecked.");
     }else{
    	 System.out.println("checkbox of database in filter pane is checked.");
     }
     driver.quit();
	}
}
