import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
    private WebDriver driver;
    private String path="src/test/resources/driver/chromedriver.exe";
    private By email_login = By.className("style_input__dvx2f");
    private By password = By.id("password_login");
    private By email_reg = By.id("email_register");
    private By pass_reg = By.id("password_register");

    @BeforeTest()
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", this.path);
        this.driver = new ChromeDriver();

//        Command to run the tests on Firefox
//        WebDriver driver = new FirefoxDriver();
    }

    @Test()
    public void navigateHomePage()  {
        this.driver.get("https://www.twitter.com/");
    }

    @Test()
    public void navigateHomePage2()  {
        this.driver.get("https://www.nike.com/");
    }

    @Test()
    public void navigateHomePage3()  {
        this.driver.get("https://ztrain-web.vercel.app/en/home");
//        this.driver.findElement(By.id("style_popular_product_wrapper__z6Joh")).click();

//        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        this.driver.findElement(By.cssSelector("nav>div:nth-child(4)")).click();
//        this.driver.findElement(By.id("email_login")).sendKeys("roland.siledjie@institutsaintjean.org");
        this.driver.findElement(this.email_login).sendKeys("roland.siledjie@institutsaintjean.org");
        this.driver.findElement(this.password).sendKeys("12345678");
//        this.driver.findElement(By.id("btn_login")).click();
        this.driver.findElement(By.id("btn_login"));

        String mail = this.driver.findElement(By.id("btn_login")).getText();

        Assert.assertTrue(this.driver.findElement(this.email_login).isDisplayed());
//        this.driver.findElement(By.className("style_card__gNEqX")).click();
    }

    @Test()
    public void signUp()    {
        this.driver.get("https://ztrain-web.vercel.app/en/home");

//        Registration
        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        this.driver.findElement(By.cssSelector(".MuiTabs-scroller>div>button:nth-child(2)")).click();
        this.driver.findElement(this.email_reg).sendKeys("rol.mambo@cool.com");
        this.driver.findElement(this.pass_reg).sendKeys("12345678");
        this.driver.findElement(By.id("confirm_password_register")).sendKeys("12345678");
        this.driver.findElement(By.id("btn_register")).click();

//        Connection
//        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
//        this.driver.findElement(By.className("ant-menu-item.style_ant_menu_item__Aqa9N")).click();
//        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
//        this.driver.findElement(this.email_reg).sendKeys("rol.mambo@cool.com");
//        this.driver.findElement(this.pass_reg).sendKeys("12345678");
//        this.driver.findElement(By.id("btn_login")).click();
    }

    @Test()
    public void signIn()    {
        this.driver.get("https://ztrain-web.vercel.app/en/home");

        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        this.driver.findElement(By.className("ant-menu-item.style_ant_menu_item__Aqa9N")).click();
        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        this.driver.findElement(this.email_reg).sendKeys("rol.mambo@cool.com");
        this.driver.findElement(this.pass_reg).sendKeys("12345678");
        this.driver.findElement(By.id("btn_login")).click();

        String email = "";
        boolean visibled = this.driver.findElement(By.id("email")).isDisplayed();

        if (visibled) {
            email = this.driver.findElement(By.id("email")).getText();
            System.out.println("Email : " + email);
            Assert.assertEquals(email, "rol.mambo@cool.com", "Connexion reussie");
        } else {
            System.out.println("Pas d'email");
        }
    }

//    @AfterTest()
//    public void closeDriver()   {
//        this.driver.quit();
//    }
}
