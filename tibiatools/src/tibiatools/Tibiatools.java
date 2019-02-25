/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tibiatools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author mako
 */
public class Tibiatools {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\selenium_java\\chromedriver\\chromedriver.exe");

        //setting up chrome driver and making it headless
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless"); 
        WebDriver driver = new ChromeDriver(chromeOptions);

        //readInfo("C:\\Users\\mako\\Desktop\\forumtools\\character_data.txt");
        String login, password, character, world;
        login = "isaksam2";
        password = "daniel321";
        character = "Anna Misshandlarn";
        world = "Antica";

        login(driver);
        post(driver);
      
        
        //driver.quit();           
    }

    //read the account info
    public static void readInfo(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));

    }

    public static void login(WebDriver driver) {

        driver.navigate().to("https://www.tibia.com/account/?subtopic=accountmanagement");

        //logging in
        WebElement element = driver.findElement(By.name("loginname"));
        element.clear();
        element.sendKeys("isaksam2");
        element = driver.findElement(By.name("loginpassword"));
        element.clear();
        element.sendKeys("daniel321" + Keys.ENTER);
        //
        driver.navigate().to("https://www.tibia.com/forum/?subtopic=worldboards");
        element = driver.findElement(By.linkText("Antica"));
        element.click();
    }

    public static void post(WebDriver driver) {

         WebElement element = driver.findElement(By.xpath("//*[@id=\"worldboards\"]/div[5]/div/div/table[2]/tbody/tr[2]/td[1]/a/img"));
         element.click();
         
         ////*[@id="worldboards"]/div[5]/div/div/table[2]/tbody/tr[2]/td[2]/select
         element = driver.findElement(By.xpath("//*[@id=\"worldboards\"]/div[5]/div/div/table[2]/tbody/tr[2]/td[2]/select"));
         element.click();
         Select ddSelect = new Select(element);
         ddSelect.selectByVisibleText("Anna Misshandlarn (Antica)");
         
         element = driver.findElement(By.name("forum_subject"));
         element.sendKeys("blabla");
         
         element = driver.findElement(By.name("forum_pagetext"));
         element.sendKeys("blabla");
         
        // element = driver.findElement(By.name("submit"));
        // element.click();
    }

}
