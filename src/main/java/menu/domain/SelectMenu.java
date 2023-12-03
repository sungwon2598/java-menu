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
                if (category.equals("일식")) {
                    List<String> japan = menu.getJapan();
                    menu(coach, japan);
                }
                if (category.equals("양식")) {
                    List<String> western = menu.getWestern();
                    menu(coach, western);
                }
                if (category.equals("중식")) {
                    List<String> china = menu.getChina();
                    menu(coach, china);
                }
                if (category.equals("한식")) {
                    List<String> korea = menu.getKorea();
                    menu(coach, korea);
                }
                if (category.equals("아시아")) {
                    List<String> asis = menu.getAsisa();
                    menu(coach, asis);
                }

            }
        }
        return coaches;
    }

    private void menu(Coach coach, List<String> categories) {
        while (true) {
            String menu = Randoms.shuffle(categories).get(0);
            if (!coach.getHates().contains(menu)) {
                coach.addEat(menu);
                break;
            }
        }
    }
}
