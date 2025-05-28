package tests;

import org.testng.annotations.Test;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;

public class FramesTest extends BaseTest {

    @Test
    public void framesTest() {
        HomePage homePage= new HomePage(driver);
        homePage.isPageLoaded();
        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        CommonPage commonPage=new CommonPage(driver);
        commonPage.isPageLoaded();
        commonPage.goToDesiredSubMenu("Frames");
        FramesPage framesPage=new FramesPage(driver);
        framesPage.interactWithFrameOne();
        framesPage.interactWithFrameTwo();
    }

    //test git
//    public void openBrowser() {
//        driver = new ChromeDriver(); // Navigam catre pagina website-ului
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize(); // Facem fereastra maxima
//    }

//    // Identificam meniul dorit si facem click pe el
//    public void choseMenu() {
//        WebElement alertsWindowsAndFramesMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        scrollToElement(alertsWindowsAndFramesMenu);
//        alertsWindowsAndFramesMenu.click(); // Actionam butonul din meniul de mai sus
//    }
//
//    // Facem o metoda care sa faca scroll
//    public void scrollToElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//    }
//
//    public void choseSubMenu() {
//        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Frames']"));
//        alertsSubMenu.click();
//    }
//
////    public void closeBrowser(){
////        driver.quit();
////    }
//
//    public void interactWithFrameOne(){
//        WebElement frameOneElement = driver.findElement(By.id("frame1"));
//        driver.switchTo().frame(frameOneElement);
//        WebElement frameOneTextValue = driver.findElement(By.id("sampleHeading"));
//        String expectedText = "This is a sample page";
//        Assert.assertEquals(frameOneTextValue.getText(), expectedText, "Text is not displayed properly");
//        System.out.println("Frame one text is: " + frameOneTextValue.getText());
//        driver.switchTo().defaultContent();  // schimbam focusul pe pagina initiala;
//    }
//
//    public void interactWithFrameTwo(){
//        WebElement frameTwoElement = driver.findElement(By.id("frame2"));
//        driver.switchTo().frame(frameTwoElement);
//        WebElement frameTwoTextValue = driver.findElement(By.id("sampleHeading"));
//        String expectedText = "This is a sample page";
//        Assert.assertEquals(frameTwoTextValue.getText(), expectedText, "Text is not displayed properly");
//        System.out.println("Frame two text is: " + frameTwoTextValue.getText());
//        driver.switchTo().defaultContent();
//    }
}
