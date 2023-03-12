import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTest {

    @BeforeAll
    static void beforeTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    //https://demoqa.com/text-box
    @Test
    void fillFormTest() {
        open("/text-box");

        $("[id=userName]").setValue("Gina Lollobrigida");
        $("[id=userEmail]").setValue("ginalollobrigida@google.com");
        $("[id=currentAddress]").setValue("City of Chicago");
        $("[id=permanentAddress]").setValue("Washington, D.C");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Gina Lollobrigida"), text("ginalollobrigida@google.com"),
                text("City of Chicago"), text("Washington, D.C"));
    }
    @AfterAll
    static void afterTest() {
        System.out.println("Good Job!");
    }
}
