package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.menu.Menu;

public class SelectMenu {
    private static final Menu menu = new Menu();
    private static final int NUMBER_OF_CATEGORIES = 5;
    private static final String JAPANESE = "일식";
    private static final String WESTERN = "양식";
    private static final String CHINESE = "중식";
    private static final String KOREAN = "한식";
    private static final String ASIAN = "아시안";
    private final Coaches coaches;
    private final List<String> categories;

    public SelectMenu(Coaches coaches, List<String> categories) {
        this.coaches = coaches;
        this.categories = categories;
    }

    public Coaches process() {
        for (int i = 0; i < NUMBER_OF_CATEGORIES; i++) {
            String category = categories.get(i);
            for (int j = 0; j < coaches.size(); j++) {
                Coach coach = coaches.getCoach(j);
                menuP(category, JAPANESE, menu.getJapan(), coach);
                menuP(category, WESTERN, menu.getWestern(), coach);
                menuP(category, CHINESE, menu.getChina(), coach);
                menuP(category, KOREAN, menu.getKorea(), coach);
                menuP(category, ASIAN, menu.getAsisa(), coach);

            }
        }
        return coaches;
    }

    private void menuP(String category, String cat, List<String> menu, Coach coach) {
        if (category.equals(cat)) {
            List<String> categories = menu;
            menu(coach, categories);
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
