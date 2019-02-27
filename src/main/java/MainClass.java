
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class MainClass {

    public static void main(String[] args) {
        OpenSite openSite = new OpenSite();

    }
}

//Делаем простенький тест который открывает google отправляет строку "Automation testing"
// в поиск, нажимает search, попадает на страницу результатов и находит линку
// в результатах с сайта -  https://www.qasymphony.com и нажимает на неё.