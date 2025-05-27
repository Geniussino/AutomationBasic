package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WidowsTest extends BaseTest {


    @Test
    public void WindowsTest() {
        choseMenu();
        choseSubMenu();
        interactWithNewTab();
        interactWithNewWindow();
        interactWithNewWindowMessage();

    }
    // Metoda care deschide browserul
//    public void openBrowser() {
//        driver = new ChromeDriver(); // Navigam catre pagina website-ului
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize(); // Facem fereastra maxima
//    }

    // Identificam meniul dorit si facem click pe el
    public void choseMenu() {
        WebElement alertsWindowsAndFramesMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        scrollToElement(alertsWindowsAndFramesMenu);
        alertsWindowsAndFramesMenu.click(); // Actionam butonul din meniul de mai sus
    }

    // Facem o metoda care sa faca scroll
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void choseSubMenu() {
        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        alertsSubMenu.click();
    }

    public void interactWithNewTab(){
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles()); //declaram o lista de ferestre
        driver.switchTo().window(windowsList.get(1)); //ne mutam pe tabul nou deschis
        WebElement tabTextValue = driver.findElement(By.id("sampleHeading"));
        String expectedText = "This is a sample page";
        Assert.assertEquals(tabTextValue.getText(), expectedText, "Text is not displayed properly");
        driver.close();   //close, inchide fereastra, quit, inchide intreaga instanta
        driver.switchTo().window(windowsList.get(0));
    }

    public void interactWithNewWindow(){
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles()); //declaram o lista de ferestre
        driver.switchTo().window(windowsList.get(1)); //ne mutam pe tabul nou deschis
        WebElement windowTextValue = driver.findElement(By.id("sampleHeading"));
        String expectedText = "This is a sample page";
        Assert.assertEquals(windowTextValue.getText(), expectedText, "Text is not displayed properly");
        driver.close();   //close, inchide fereastra, quit, inchide intreaga instanta
        driver.switchTo().window(windowsList.get(0));
    }

//    public void closeBrowser(){
//        driver.quit();
//    }

    public void interactWithNewWindowMessage() {
        WebElement newWindowMessageButton = driver.findElement(By.id("messageWindowButton"));
        newWindowMessageButton.click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles()); //declaram o lista de ferestre
        if (windowsList.size() > 1) {
            System.out.println("A new window is successfully opened");
        } else {
            System.out.println("New window can't be opened");
        }
        driver.switchTo().window(windowsList.get(1));
        driver.close();
        driver.switchTo().window(windowsList.get(0));
    }
}
