package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.menu.Menu;

public class SelectMenu {
    private static final Menu menu = new Menu();
    private final Coaches coaches;
    private final List<String> categories;

    public SelectMenu(Coaches coaches, List<String> categories) {
        this.coaches = coaches;
        this.categories = categories;
    }

    public Coaches process() {
        for (int i = 0; i < 5; i++) {
            String category = categories.get(i);
            for (int j = 0; j < coaches.size(); j++) {
                Coach coach = coaches.getCoach(j);
                menuP(category, "일식", menu.getJapan(), coach);
                menuP(category, "양식", menu.getWestern(), coach);
                menuP(category, "중식", menu.getChina(), coach);
                menuP(category, "한식", menu.getKorea(), coach);
                menuP(category, "아시안", menu.getAsisa(), coach);

            }
        }
        return coaches;
    }

    private void menuP(String category, String 일식, List<String> menu, Coach coach) {
        if (category.equals(일식)) {
            List<String> japan = menu;
            menu(coach, japan);
        }
    }

    private void menu(Coach coach, List<String> categories) {
        while (true) {
            String menu = Randoms.shuffle(categories).get(0);
            if (!coach.getHates().contains(menu) && !coach.getEat().contains(menu)) {
                coach.addEat(menu);
                break;
            }
        }
    }

}
