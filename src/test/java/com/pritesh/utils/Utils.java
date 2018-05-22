package com.pritesh.utils;

import com.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {


    public static void takeFaileScreenShot(RemoteWebDriver driver, String screenshotName) {
        try {
            // This takes a screenshot from the driver at save it to the specified location
            File sourcePath = driver.getScreenshotAs(OutputType.FILE);

            // Building up the destination path for the screenshot to save
            // Also make sure to create a folder 'screenshots' with in the cucumber-report folder
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
            // Create folder under project with name "screenshots" provided to destDir.
            // Set file name using current date time.
            String dateTimeString = dateFormat.format(new Date());

            String imageFile = screenshotName + "_" + dateTimeString + ".png";
            File destinationPath =
                    new File(
                            System.getProperty("user.dir")
                                    + "/target/cucumber-reports/screenshots/"
                                    + imageFile);

            // Copy taken screenshot from source location to destination location
            FileUtils.copyFile(sourcePath, destinationPath);

            // This attach the specified screenshot to the test
            Reporter.addScreenCaptureFromPath("./screenshots/" + imageFile);
        } catch (IOException e) {
        }
    }

    public static void startFlickVideoRecording(String deviceName) {
        List<String> args = new ArrayList<>();
        args.add("flick"); // command name
        args.add("video");
        args.add("-a");
        args.add("start");
        args.add("-p");
        args.add("android");
        args.add("-u");
        args.add(deviceName);
        args.add("-o");
        args.add(System.getProperty("user.dir"));
        ProcessBuilder pb = new ProcessBuilder(args);
        try {
            System.out.println("Init Video Recording using flick...");
            Process p = pb.start();
            p.waitFor();
            System.out.println("Start Video Recording using flick...");
            String output = IOUtils.toString(p.getInputStream(), StandardCharsets.UTF_8);
            System.out.println("TEST - Video Recording Started : \n" + output);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while starting video recording...");
        }
    }

    public static void stopFlickVideoRecording(String deviceName) {
        List<String> args = new ArrayList<>();
        args.add("flick"); // command name
        args.add("video");
        args.add("-a");
        args.add("stop");
        args.add("-p");
        args.add("android");
        args.add("-u");
        args.add(deviceName);

        ProcessBuilder pb = new ProcessBuilder(args);
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
            String timeStamp = dateFormat.format(new Date());
            String newFileName = timeStamp + ".mp4";

            System.out.println("Init Stop Video Recording using flick...");
            Process p = pb.start();
            p.waitFor();
            System.out.println("Stop Video Recording using flick...");
            String output = IOUtils.toString(p.getInputStream(), StandardCharsets.UTF_8);
            System.out.println("TEST - Video Recording Stopped : \n" + output);
            args.clear();
            args.add("mv");
            args.add(deviceName + ".mp4");
            String newLocation = System.getProperty("user.dir") + "/videos/" + deviceName + "-" + newFileName;
            args.add(newLocation);
            pb.start();
            System.out.println("Moved video to " + newLocation);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while stopping video recording...");
        }
    }
}
