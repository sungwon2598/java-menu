package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import menu.constant.ExceptionMessage;

public class NamePorcess {
    public List<String> process(String input) { //문자열의 쉼표검증, 공백제거 후 문자열 리스트로 반환
        validateCommas(input);
        List<String> inputs = splitByComma(input);
        validateInput(inputs);
        return trim(inputs);
    }

    private void validateCommas(String input) {
        if (input.startsWith(",") || input.endsWith(",") || input.contains(",,")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
        }
    }

    private List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private List<String> trim(List<String> inputs) {
        List<String> trimmed = new ArrayList<>();
        for (String name : inputs) {
            trimmed.add(name.trim());
        }
        return trimmed;
    }

    public void validateInput(List<String> inputs) { // 리스트에서 길이와 중복을 검증
        nameLength(inputs);
        uniqueNames(inputs);
        noSpaces(inputs);
        size(inputs);
    }

    private void noSpaces(List<String> inputs) {
        inputs.stream()
                .filter(input -> input.contains(" ")) // 공백이 포함된 경우 필터링
                .findFirst()
                .ifPresent(input -> {
                    throw new IllegalArgumentException(ExceptionMessage.PLEASE_NOT_INPUT_BETWEEN_BLANK.getMessage());
                });
    }

    private void size(List<String> inputs) {
        if (inputs.size() < 2 || inputs.size() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.PLEASE_INPUT_CORRECT_COACH.getMessage());
        }
    }

    private void nameLength(List<String> names) {
        names.stream()
                .filter(name -> name.length() > 4 || name.length() < 2) // 이름 길이가 4보다 크거나 2보다 작은 경우 필터링
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(ExceptionMessage.PLEASE_CORRECT_LENGTH.getMessage());
                });
    }


    private void uniqueNames(List<String> names) {
        HashSet<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() < names.size()) {
            throw new IllegalArgumentException(ExceptionMessage.PLEASE_INPUT_UNIQUE.getMessage());
        }
    }
}
