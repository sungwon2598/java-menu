package menu.view;

import menu.domain.Coach;
import menu.domain.Coaches;

public class OutputView {
    private static final String MENU_RESULT_INTRO = "메뉴 추천 결과입니다.";
    private static final String MENU_FORMAT = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_PREFIX = "[ 카테고리 ";
    private static final String RECOMMENDATION_COMPLETE = "추천을 완료했습니다.";
    private static final int DAYS_OF_WEEK = 5;

    private static void processCoachEats(Coaches coaches) {
        for (int i = 0; i < coaches.size(); i++) {
            System.out.print("[ " + coaches.getCoachName(i) + " ");
            for (int j = 0; j < DAYS_OF_WEEK; j++) {
                Coach coach = coaches.getCoach(i);
                System.out.print("| " + coach.getEat().get(j) + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void printMenu(Coaches coaches, String category) {
        System.out.println(MENU_RESULT_INTRO);
        System.out.println(MENU_FORMAT);
        System.out.println(CATEGORY_PREFIX + category);
        processCoachEats(coaches);
    }

    public void printEnd() {
        System.out.println(RECOMMENDATION_COMPLETE);
    }

}

