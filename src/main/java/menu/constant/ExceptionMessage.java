package menu.constant;

public enum ExceptionMessage { //메시지는 꼭!! 문제에 맞게 수정할 것
    INVALID_NUMBER("숫자만 입력해주세요"),
    INVALID_COMMA_USAGE("콤마를 올바르게 찍어주세요"),
    PLEASE_NOT_INPUT_BETWEEN_BLANK("사이에 공백을 입력하지 말아주세요"),
    PLEASE_INPUT_UNIQUE("중복되지 않게 입력해주세요"),
    PLEASE_CORRECT_LENGTH("올바른 길이로 입력해주세요"),
    PLEASE_NOT_INPUT_BLANK("공백을 입력하지 말아주세요"),
    PLEASE_INPUT_CORRECT_COACH("코치는 최소 2명, 최대 5명까지 식사를 함께합니다, 올바른 인원을 입력해주세요");



    private static final String FIRST_MESSAGE = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = FIRST_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}