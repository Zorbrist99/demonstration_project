package tests.web;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.pages.AuthPage;
import tests.web.pages.HomePage;
import tests.web.pages.TasksPage;

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
        String habitOne = "Start running",
                habitTwo = "Second value";

        step("Авторизуемся в сервисе", () -> {
            authPage.authorizations("beryozkinkonstantin@yandex.ru", "QAguru2024");
        });

        step("Добавить привычку и проверить её отображение в списке", () -> {
            homePage.addHabit(habitOne);
            homePage.checkingHabitsInList(habitOne);
        });

        step("Перейти в меню изменения привычки", () -> {
            homePage.habitSettings();
        });

        step("Очистить поле с название и записать новое", () -> {
            tasksPage.clearNameField();
            tasksPage.registerNewNameForHabit(habitTwo);
        });

        step("Сохранить изменения и проверить новое название в списке привычек", () -> {
            tasksPage.clickOnSaveButton("Save");
            homePage.checkingHabitsInList(habitTwo);
        });


        step("Перейти в меню изменения привычки и удалить её", () -> {
            homePage.habitSettings();
            homePage.selectFieldFromHabitSettings("Delete this Habit");
            Selenide.confirm();
        });

        step("Проверить что привычка удалена", () -> {
            homePage.checkingForAbsenceOfHabitsInList(habitTwo);
        });
    }
}
