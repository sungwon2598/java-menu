package menu.domain;

import java.util.List;

public class Coaches {
    public List<String> coaches;
    public void addCoach(String name) {
        coaches.add(name);
    }

    public String getCoach(int index) {
        return coaches.get(index+1);
    }
}
