package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.constant.ExceptionMessage;

public class InputView {

    public void printInit() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public String requestInput() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine().trim(); // 입력값의 좌우 공백제거
        validateEmpty(input);
        return input;
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) { // 입력값이 빈 문자열인 경우
            throw new IllegalArgumentException(ExceptionMessage.PLEASE_NOT_INPUT__BLANK.getMessage());
        }
    }
}
