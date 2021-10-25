import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import  org.junit.Test;
import org.openqa.selenium.Keys;



import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ee {
    @Test
    public void Method_1(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://ee.ge/");
        $(".btn-register.mb-2.mr-4", 0).click();
        $(byText("რეგისტრაცია მარტივი, სწრაფი და უფასოა..")).shouldBe(Condition.visible);
        $("#firstName").setValue("salome");
        $("#firstName").shouldNotBe(Condition.empty);
        $("#lastName").setValue("bozhadze");
        $("#lastName").shouldNotBe(Condition.empty);
        $("#email").setValue("sal.bozhadze@gmail.com");
        $("#email").shouldNotBe(Condition.empty);
        $("#password").setValue("Salome1989");
        $("#confirmPassword").setValue("Salome1989");
        $("#singup").shouldBe(Condition.enabled);
        sleep(5000);

}
    @Test
    public void Method_2(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://ee.ge/");
        $(".btn-register.mb-2.mr-4", 0).click();
        $(byText("რეგისტრაცია მარტივი, სწრაფი და უფასოა..")).shouldBe(Condition.visible);
        $("#singup").shouldNot(Condition.enabled);
        $("#firstName").click();
        $("#lastName").click();
        $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").click();
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
        $("#password").click();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#confirmPassword").click();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $("#password").click();
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").setValue("test");
        //String value = "test";
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").sendKeys(Keys.CONTROL + "a");
        $("#email").sendKeys(Keys.BACK_SPACE);
        //for (int i = 0; i < value.length(); i++);
        //$("#email").sendKeys(Keys.BACK_SPACE);
        $("#email").setValue("test@");
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").sendKeys(Keys.CONTROL + "a");
        $("#email").sendKeys(Keys.BACK_SPACE);
        $("#email").setValue("test@gmail");
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").sendKeys(Keys.CONTROL + "a");
        $("#email").sendKeys(Keys.BACK_SPACE);
        $("#email").setValue("test@gmail.");
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#password").setValue("Salom");
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $("#password").setValue("e");
        $("#confirmPassword").setValue("Salome1989");
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
        sleep(5000);


    }

    @Test
    public void Method_3(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://ee.ge/");
        $(".cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $("#search_list").setValue("computer");
        $(".artist-name",1).click();
        $(".btn-darkred.mb-2.add_to_cart", 0).click();
        $(".cart").click();
        $(byText("კალათა ცარიელია")).shouldNot(Condition.visible);
        $(".btn.btn-lightgrey").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        sleep(5000);
    }

    @Test
    public void Method_4(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://ee.ge/");
        $(".cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $("#search_list").setValue("კომპიუტერი");
        $(".artist-name", 1).click();
        $(".btn-darkred.mb-2.add_to_cart", 0).click();
        $(".cart").click();
        $(".btn.btn-darkred.redButton").click();
        $(".nav-link", 7).click();
        $(byText("ვერ მოიძებნა")).shouldNot(Condition.visible);
        $(".cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $(".nav-link", 7).click();
        $(".btn.btn-darkred.btn_round.d-xs-none").click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
        sleep(5000);

    }
}
