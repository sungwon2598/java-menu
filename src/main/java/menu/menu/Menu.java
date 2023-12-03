package menu.menu;

import java.util.List;

public class Menu {
    public List<String> category = List.of(new String[]{" ", "일식", "한식", "중식", "아시아", "양식"});
    public List<String> japan = List.of(
            new String[]{"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"});
    public List<String> korea = List.of(
            new String[]{"김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"});
    public List<String> china = List.of(
            new String[]{"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"});
    public List<String> asisa = List.of(
            new String[]{"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"});
    public List<String> western = List.of(
            new String[]{"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"});
}
