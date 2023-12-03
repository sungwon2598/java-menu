package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.constant.ExceptionMessage;

public class InputView {
    private static final String INIT_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String REQUEST_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String REQUEST_HATE_MENU_MESSAGE_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    private static void validateEmpty(String input) {
        if (input.isEmpty()) { // 입력값이 빈 문자열인 경우
            throw new IllegalArgumentException(ExceptionMessage.PLEASE_NOT_INPUT_BLANK.getMessage());
        }
    }

    public void printInit() {
        System.out.println(INIT_MESSAGE);
    }

    public String requestCoachNames() {
        System.out.println(REQUEST_COACH_NAMES_MESSAGE);
        String input = Console.readLine().trim(); // 입력값의 좌우 공백제거
        validateEmpty(input);
        return input;
    }

    public String requestCoachHate(String name) {
        System.out.printf(REQUEST_HATE_MENU_MESSAGE_FORMAT, name);
        return Console.readLine().trim(); // 입력값의 좌우 공백제거
    }

}

