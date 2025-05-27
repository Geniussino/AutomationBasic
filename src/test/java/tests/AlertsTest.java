package tests;

import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class AlertsTest extends BaseTest {

    @Test
    public void alertsTest() {
        HomePage homePage= new HomePage(driver);
        homePage.isPageLoaded();
        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        CommonPage commonPage= new CommonPage(driver);
        commonPage.isPageLoaded();
        commonPage.goToDesiredSubMenu("Alerts");
        AlertsPage alertsPage= new AlertsPage(driver);
        alertsPage.isPageLoaded();
        alertsPage.interactWithFirstAlert();
    }

//    // Metoda care deschide browserul
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
//    // Indendificam submeniul dorit si facem click pe el
//    public void choseSubMenu() {
//        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        alertsSubMenu.click();
//    }
//
//    // Facem o metoda care sa interactioneze cu prima alerta
//    public void interactWithFirstAlert() {
//        WebElement firstAlertButton = driver.findElement(By.id("alertButton"));
//        firstAlertButton.click();
//        Alert FirstAlert = driver.switchTo().alert();
//        FirstAlert.accept();
//    }
//
//    // Facem o metoda care sa interactioneze cu a doua alerta
//    public void interactWithTimerAlert() {
//        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
//        timerAlertButton.click();
//        // Inainte sa schimbam focusul pe alerta, trebuie sa punem un wait explicit
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert timerAlert = driver.switchTo().alert();
//        timerAlert.accept();
//    }
//
//    // Facem o metoda care sa interactioneze cu a treia alerta
//    public void interactWithConfirmAlert(String alertValue) {
//        WebElement confirmAlertButton = driver.findElement(By.id("confirmButton"));
//        confirmAlertButton.click();
//        Alert confirmAlert = driver.switchTo().alert();
//        if (alertValue.equals("Ok")) {
//            confirmAlert.accept();
//            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
//            assertTrue(alertResultText.getText().contains(alertValue), "You didn't select Ok. You selected: " + alertResultText.getText());
//        }
//        if (alertValue.equals("Cancel")) {
//            confirmAlert.dismiss();
//            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
//            assertTrue(alertResultText.getText().contains(alertValue), "You didn't select Cancel. You selected: " + alertResultText.getText());
//        }
//    }
//
//    public void interactWithPromptButtonAlert(String alertValue) {
//        WebElement promptButton = driver.findElement(By.id("promtButton"));
//        promptButton.click();
//        Alert promptAlert = driver.switchTo().alert();
//        promptAlert.sendKeys(alertValue);
//        promptAlert.accept();
//        WebElement resultText = driver.findElement(By.id("promptResult"));
//        assertTrue(resultText.getText().contains(alertValue), "The result doesn't contain the expected name. " + resultText.getText());
//    }
}
