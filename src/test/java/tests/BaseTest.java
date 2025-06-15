package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod

    //facem o metoda care deschide un browser;
    public void openBrowser() {
        driver = new ChromeDriver();
        // navigam catre pagine website-ului
        driver.get("https://demoqa.com/");
        //facem fereastra browser-ului maximize
        driver.manage().window().maximize();
    }

    @AfterMethod

    public void closeBrowser() {
        driver.quit();
    }

    public Map<String, Object> loadFormData(String fileName) {
        Properties properties = new Properties();
        Map<String, Object> dataMap = new HashMap<>();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new FileNotFoundException("File not found: " + fileName);
            }
            properties.load(input);
            for (String key : properties.stringPropertyNames()) {
                dataMap.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }
}