package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import menu.constant.ExceptionMessage;

public class HatesProcess {
    private static final String COMMA = ",";
    private static final String DOUBLE_COMMA = ",,";
    private static final String SPACE = " ";

    public List<String> process(String input) { //문자열의 쉼표검증, 공백제거 후 문자열 리스트로 반환
        validateCommas(input);
        List<String> inputs = splitByComma(input);
        validateInput(inputs);
        return trim(inputs);
    }

    private void validateCommas(String input) {
        if (input.startsWith(COMMA) || input.endsWith(COMMA) || input.contains(DOUBLE_COMMA)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
        }
    }

    private List<String> splitByComma(String input) {
        return Arrays.asList(input.split(COMMA));
    }

    private List<String> trim(List<String> inputs) {
        List<String> trimmed = new ArrayList<>();
        for (String name : inputs) {
            trimmed.add(name.trim());
        }
        return trimmed;
    }

    public void validateInput(List<String> inputs) { // 리스트에서 길이와 중복을 검증
        uniqueNames(inputs);
        length(inputs);
        noSpaces(inputs);
    }

    private void length(List<String> inputs) {
        if (inputs.size() > 2) {
            throw new IllegalArgumentException(ExceptionMessage.PLEASE_CORRECT_LENGTH_HATES.getMessage());
        }
    }

    private void noSpaces(List<String> inputs) {
        inputs.stream()
                .filter(input -> input.contains(SPACE)) // 공백이 포함된 경우 필터링
                .findFirst()
                .ifPresent(input -> {
                    throw new IllegalArgumentException(ExceptionMessage.PLEASE_NOT_INPUT_BETWEEN_BLANK.getMessage());
                });
    }

    private void uniqueNames(List<String> names) {
        HashSet<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() < names.size()) {
            throw new IllegalArgumentException(ExceptionMessage.PLEASE_INPUT_UNIQUE.getMessage());
        }
    }
}
