package selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FuelTestCalculator {
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/fuel-cost-calculator.html");
    }

    @Before
    public void clear(){
        driver.findElement(By.className("clearbtn")).click();
    }

    @Test
    public void fuelTest1(){
        String actualResult = calculateFuel("400", "8", "2");
        String expectedResult = "This trip will require 32 liters of fuel, which amounts to a fuel cost of $64.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void fuelTripToPjatk(){
        String actualResult = calculateFuel("344", "5.5", "1.7");
        String expectedResult = "This trip will require 18.9 liters of fuel, which amounts to a fuel cost of $32.16.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void fuelTripPjatkToPjatk(){
        String actualResult = calculateFuel("344", "5.5", "1.8");
        String expectedResult = "This trip will require 18.9 liters of fuel, which amounts to a fuel cost of $34.06.";
        Assert.assertEquals(expectedResult, actualResult);
    }







    private String calculateFuel(String distance, String efficiency, String price){
        driver.findElement(By.name("tripdistance")).sendKeys(distance);//400,8,2
        driver.findElement(By.name("fuelefficiency")).sendKeys(efficiency);
        driver.findElement(By.name("gasprice")).sendKeys(price);
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        return driver.findElement(By.className("verybigtext")).getText();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
