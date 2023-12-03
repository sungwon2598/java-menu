package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {
    private final List<String> coachesName;
    private final List<Coach> coaches = new ArrayList<>();

    public Coaches(List<String> coachesName) {
        this.coachesName = new ArrayList<>(coachesName);
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public String getCoachName(int index) {
        return coachesName.get(index);
    }

    public Coach getCoach(int index) {
        return coaches.get(index);
    }

    public int size() {
        return coachesName.size();
    }
}
