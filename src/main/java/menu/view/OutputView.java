package menu.view;

import menu.domain.Coach;
import menu.domain.Coaches;

public class OutputView {
    public void printMenu(Coaches coaches, String category) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 " + category);
        for (int i = 0; i < coaches.size(); i++) {
            System.out.print("[ " + coaches.getCoachName(i) + " ");
            for (int j = 0; j < 5; j++) {
                Coach coach = coaches.getCoach(i);
                System.out.print("| " + coach.getEat().get(j) + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void printEnd() {
        System.out.println("추천을 완료했습니다.");
    }

}
