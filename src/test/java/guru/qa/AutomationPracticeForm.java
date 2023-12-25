package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {

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
    void fillAutomationPracticeForm() {

        //simpleFields
        open("/automation-practice-form");
        $("#firstName").setValue("TestName");
        $("#lastName").setValue("TestLastName");
        $("#userEmail").setValue("Test@test.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("1234567890");

        //dateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("1");
        $(".react-datepicker__day--016").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $("#dateOfBirth-label").click();

        //Subjects
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();

        //Hobbies
        $(byId("hobbies-checkbox-1")).ancestor(".custom-checkbox").click();
        $(byId("hobbies-checkbox-2")).ancestor(".custom-checkbox").click();
        $(byId("hobbies-checkbox-3")).ancestor(".custom-checkbox").click();

        //Picture
        $("#uploadPicture").uploadFile(new File("/Users/user/Documents/Изображения/вторичка.jpeg"));

        //Current Address
        $("#currentAddress").setValue("TestAddress");

        //State and city
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        //Submit
        $("#submit").click();

        //Result
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("TestName TestLastName"));
        $(".table-responsive").shouldHave(text("Test@test.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("16 February,2023"));
        $(".table-responsive").shouldHave(text("Maths, Computer Science, Economics, Physics"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("вторичка.jpeg"));
        $(".table-responsive").shouldHave(text("TestAddress"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}

