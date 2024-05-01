package org.example.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage extends Page{
    @FindBy(css = "nav>div:nth-child(4)")
    private WebElement avatar;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(css = "password")
    private WebElement password;

    @FindBy(css = "signIn")
    private WebElement buttonSignIn;

    private String adresse = "https://ztrain-web.vercel.app/en/home";

    public void navigateHomePage() {
        this.getURL(adresse);
    }

    public void SignIn() {
        this.email.sendKeys("rol.mambo@cool.com");
        this.password.sendKeys("12345678");
        this.buttonSignIn.click();
        System.out.println("Test Reussi.");
    }
}
