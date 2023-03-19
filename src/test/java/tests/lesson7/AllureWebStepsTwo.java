package tests.lesson7;

import org.junit.jupiter.api.Test;

public class AllureWebStepsTwo {
    private static final String Repo = "Sinturik/PageObject";

    @Test
    void webStepsTwo(){
        AllureWebSteps steps = new AllureWebSteps();
        steps.openPage();
        steps.searchForRepo(Repo);
        steps.checkRepo(Repo);
        steps.openRepo(Repo);
        steps.checkingLink();
        steps.takeScreenshot();
    }
}
