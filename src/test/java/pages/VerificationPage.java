package pages;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id='code'] input");
    private final SelenideElement verifyButton = $(byText("Продолжить"));
    private final SelenideElement heading = $(byText("Интернет Банк"));

    public VerificationPage() {
        heading.shouldBe(visible);
        codeField.shouldBe(visible);
        verifyButton.shouldBe(visible);
    }

    public DashboardPage validVerify(String verificationCode) {

        sleep(500);
        codeField.setValue(verificationCode);
        sleep(500);
        verifyButton.click();
        return new DashboardPage();
    }
}