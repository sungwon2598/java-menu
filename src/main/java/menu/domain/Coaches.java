package menu.domain;

import java.util.List;

public class Coaches {
    public List<String> coaches;

    public Coaches(List<String> coaches) {
        this.coaches = coaches;
    }

    public void addCoach(String name) {
        coaches.add(name);
    }

    public  String getCoach(int index) {
        return coaches.get(index);
    }

    public int size() {
        return coaches.size();
    }
}
