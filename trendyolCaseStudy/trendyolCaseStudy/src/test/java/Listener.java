import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.concurrent.TimeUnit;

public class Listener extends BaseTest implements ITestListener {

    public void onTestStart(ITestResult ıTestResult) {}

    public void onTestSuccess(ITestResult ıTestResult) {//Test başarılı ise return bilgisi loglanmaktadır
        log.info(ıTestResult); }

    public void onTestFailure(ITestResult ıTestResult) {//Test başarısız ise return bilgisi loglanmaktadır
        log.error(ıTestResult.getThrowable()); }

    public void onTestSkipped(ITestResult ıTestResult) {  log.warn("skip"); }

    public void onTestFailedButWithinSuccessPercentage(ITestResult ıTestResult) { }



    public void onFinish(ITestContext ıTestContext) {//test herhangi bir sebeple bitirildiğinde burdaki komutlar çalışacaktır
        driver.quit();
        log.info("Browser kapatıldı");
    }


    public void onStart(ITestContext ıTestContext) {//kod çalışmaya burdan başlayacak

//loglama yapılmaya başlanması için properties dosyasının yolu belirtildi
        PropertyConfigurator.configure("C:\\Users\\SerifYerinde\\IdeaProjects\\trendyolCaseStudy\\trendyolCaseStudy\\src\\test\\java\\resources\\log4j.properties");

//browser değişkeni atandı. Bu sayede aşağıdaki switch case yapısıyla parametrik olarak browser seçimi yapılabilecek
            String browser = System.getProperty("BROWSER");
            if(browser==null)
            {
                browser = System.getenv("BROWSER");
                if(browser==null)
                {
 //parametrik olarak burada değer ataması yapılıyor
                    browser= "chrome";
                }
            }
            switch (browser)
            {
/*WebDriver çağrımı değer atamasına bağlı olarak burdan çağrılmaktadır
Burada chrome-edge tarayıcıları için yaptım sadece, çoklanabilir bir yapı ve bunlar dışında bir değer gelirse chrome çağrılacaktır
 */
                case "chrome":
                    System.setProperty("webdriver.chrome.driver","C:\\Users\\SerifYerinde\\IdeaProjects\\trendyolCaseStudy\\trendyolCaseStudy\\Driver\\chromedriver.exe");
                    driver=new ChromeDriver(DesiredCapabilities.chrome());
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver","C:\\Users\\SerifYerinde\\IdeaProjects\\trendyolCaseStudy\\trendyolCaseStudy\\Driver\\MicrosoftWebDriver.exe");
                    driver = new EdgeDriver(DesiredCapabilities.edge());
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver","C:\\Users\\SerifYerinde\\IdeaProjects\\trendyolCaseStudy\\trendyolCaseStudy\\Driver\\chromedriver.exe");
                    driver=new ChromeDriver(DesiredCapabilities.chrome());
                    break;
            }
            log.info("Tarayıcı açılıyor..."+browser);

//tarayıcıyı tam boy ve çerezleri kapatma
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
//dinamik bekleme
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
}
