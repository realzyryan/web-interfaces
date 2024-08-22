package ru.netology;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DebitCardTest {

    @Test
    void DebitCardApplication() throws InterruptedException {
        open("http://localhost:9999/");
        $(".heading").shouldHave(exactText("Заявка на дебетовую карту"));
        $(".heading_size_s").shouldHave(exactText("Персональные данные"));
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Иванов Иван");
        form.$("[data-test-id=name] .input__sub").shouldHave(exactText("Укажите точно как в паспорте"));
        form.$("[data-test-id=phone] input").setValue("+79220000000");
        form.$("[data-test-id=phone] .input__sub").shouldHave(exactText("На указанный номер моб. тел. будет отправлен смс-код для подтверждения заявки на карту. Проверьте, что номер ваш и введен корректно."));
        form.$("[data-test-id=agreement]").click();
        form.$("[data-test-id=agreement] .checkbox__text").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
        $(".button_view_extra").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}