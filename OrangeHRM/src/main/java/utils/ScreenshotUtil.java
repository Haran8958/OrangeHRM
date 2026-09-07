package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    private ScreenshotUtil() {
        // Prevent object creation
    }

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String directory = "screenshots";

        Path path = Paths.get(directory);

        try {
            Files.createDirectories(path);
        } 
        catch (IOException e) {
            throw new RuntimeException("Unable to create screenshot directory", e);
        }

        String filePath = directory
                + File.separator
                + testName
                + "_"
                + timestamp
                + ".png";

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(source.toPath(),Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Unable to save screenshot", e);
        }

        return filePath;
    }
}