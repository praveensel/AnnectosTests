package trash;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Discount {


    public static void main(String a[] ) {
        String dis[] = new String[]{


                "343437010",
                "343437063",
                "343437101",
                "343437473",
                "343437691",











        };

        System.out.println(dis.length);
        for (int i = 0; i < dis.length;i++)
        {
            System.out.println("{\"id\": \""+dis[i]+"\", \"extra_off\":\".14\"},");
        }
    }
}
