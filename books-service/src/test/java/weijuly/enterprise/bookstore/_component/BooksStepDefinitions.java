package weijuly.enterprise.bookstore._component;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;

public class BooksStepDefinitions {


    @Before("@books")
    public void before() {
        System.out.println(">>>>> before books >>>>>");
    }

    @After("@books")
    public void after() {
        System.out.println(">>>>> after books >>>>>");

    }

    @When("create books API is called")
    public void createBooks() {
        System.out.println(">>>>> create books API is called >>>>>");
    }
}
