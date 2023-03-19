package tests.lesson7;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllureLabels {
    @Test
    @Owner("sultanova.iui")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("code javafaker")
    @Story("find code javafaker")
    @DisplayName("checking the repository search")
    @Description("This test checks the repo search")
    @Link(value = "Testing", url = "https://github.com")
    public void annotatedLabels(){
    }

    @Test
    public void dynamicLabels(){
        Allure.label("owner","sultanova.iui");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.feature("code javafaker");
        Allure.story("find code javafaker");
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("Checking Issue deletion for an authorized user");
        });
        Allure.description("This test checks the repo search");
        Allure.link("Testing", "https://github.com");
    }

    @Test
    public void testParameters() {
        Allure.parameter("region", "Leningrad region");
        Allure.parameter("city", "Saint Petersburg");
    }
}

