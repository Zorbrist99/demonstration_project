package web;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.HomePage;
import pages.TasksPage;


import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Tag("web")
@Feature("Проверки раздела Задачи")
public class TasksPageTests extends TestBase {

    AuthPage authPage = new AuthPage();
    HomePage homePage = new HomePage();
    TasksPage tasksPage = new TasksPage();

    @Test
    @DisplayName("Добавление привычки")
    void addingHabit() {
        String habitOne = "Начать бегать",
                habitTwo = "Второе значение";

        step("Авторизуемся в сервисе", () -> {
            authPage.authorizations("beryozkinkonstantin@yandex.ru", "QAguru2024");
        });

        step("Добавить привычку и проверить её отображение в списке", () -> {
            homePage.addHabit(habitOne);
            homePage.checkingHabitsInList(habitOne);
        });

        step("Зайти в настройки привычки и нажать Изменить", () -> {
            homePage.habitSettings();
            homePage.selectFieldFromHabitSettings("Изменить");
        });

        step("Очистить поле с название и записать новое", () -> {
            tasksPage.clearNameField();
            tasksPage.registerNewNameForHabit(habitTwo);
        });

        step("Сохранить изменения и проверить новое название в списке привычек", () -> {
            tasksPage.clickOnSaveButton("Сохранить");
            homePage.checkingHabitsInList(habitTwo);
        });


        step("Перейти в настройки новой привычки и удалить её", () -> {
            homePage.habitSettings();
            homePage.selectFieldFromHabitSettings("Удалить");
            Selenide.confirm();
        });

        step("Проверить что привычка удалена", () -> {
            homePage.checkingForAbsenceOfHabitsInList(habitTwo);
        });
    }
}
