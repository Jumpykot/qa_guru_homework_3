package guru.qa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestTextBoxForm {

    @BeforeAll
    static void BeforeAll() {

        System.out.println("     Запуск конфигураций");
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {

        open("/text-box");
        $("#userName").setValue("TestUsername");
        $("#userEmail").setValue("TestEmail@test.ru");
        $("#currentAddress").setValue("TestUsersCurrentAddress");
        $("#permanentAddress").setValue("TestUsersPermanentAddress");
        $("#submit").click();

        $("#output #name").shouldHave(text("TestUsername"));
        $("#output #email").shouldHave(text("TestEmail@test.ru"));
        $("#output #currentAddress").shouldHave(text("TestUsersCurrentAddress"));
        $("#output #permanentAddress").shouldHave(text("TestUsersPermanentAddress"));

    }
}
