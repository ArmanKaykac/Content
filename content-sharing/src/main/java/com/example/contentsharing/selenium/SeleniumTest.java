package com.example.contentsharing.selenium;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.jni.Time;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static String CaptureScreen(String url) throws InterruptedException { //set the location of chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.gulsanholding.com/bize-ulasin"); // url parameter

        driver.switchTo().frame(0);   // or frame index
        String className = "/html/body/div[1]/div/div/div[3]/div/div/div/div";

//        WebElement button = driver.findElement(By.className("google-maps-link"));
//        button.click();
        //*[@id="map-canvas"]/div[2]/div[1]/div[3]/div
        //WebElement element;
        driver.findElement(By.xpath("//*[@id=\"mapDiv\"]/div/div/div[3]/div/div/div/div/a")).click();

        driver.switchTo().parentFrame();
//        WebElement logo = driver.findElement(By.xpath("//*[@id=\"map-canvas\"]/div[2]/div[1]/div[3]"));
//        File screenshot = logo.getScreenshotAs(OutputType.FILE);

//        FileUtils.copyFile(screenshot, new File("screenshot.png"));
//
//        File file = new File("screenshot.png");
//
//        byte[] data = FileUtils.readFileToByteArray(file);
//
//        driver.quit();
//
//        return Base64.getEncoder().encodeToString(data);

        return "";
    }
}
