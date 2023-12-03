package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.HatesProcess;
import menu.domain.NamePorcess;
import menu.domain.SelectCategory;
import menu.domain.SelectMenu;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private static final int DAY_LENGTH = 5;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final HatesProcess hatesProcess = new HatesProcess();
    private Coaches coaches;

    public void start() {
        inputView.printInit();
        inputNames();
        processCoach();

        List<String> categories = porcessCategory();

        outputResult(categories);
    }

    private void inputNames() {
        while (true) {
            try {
                NamePorcess namePorcess = new NamePorcess();
                this.coaches = new Coaches(namePorcess.process(inputView.requestCoachNames()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void outputResult(List<String> categories) {
        String category = "";
        for (int i = 0; i < DAY_LENGTH; i++) {
            category += "| " + categories.get(i) + " ";
        }
        category += "]";

        outputView.printMenu(coaches, category);
        outputView.printEnd();
    }

    private List<String> porcessCategory() {
        SelectCategory selectCategory = new SelectCategory();
        List<String> categories = selectCategory.process();

        SelectMenu selectMenu = new SelectMenu(this.coaches, categories);
        this.coaches = selectMenu.process();
        return categories;
    }

    private void processCoach() {
        for (int i = 0; i < coaches.size(); i++) {
            while (true) {
                inputHates(i);
                break;
            }

        }
    }

    private void inputHates(int i) {
        try {
            String hates = inputView.requestCoachHate(coaches.getCoachName(i));
            Coach coach = new Coach(coaches.getCoachName(i), hatesProcess.process(hates));
            coaches.addCoach(coach);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
