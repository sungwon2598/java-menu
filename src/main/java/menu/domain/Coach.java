package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final List<String> hates;
    private final String name;
    private final List<String> eat = new ArrayList<>();

    public Coach(String name, List<String> hates) {
        this.name = name;
        this.hates = hates;
    }

    public void addEat(String menu) {
        eat.add(menu);
    }

    public List<String> getHates() {
        return hates;
    }

    public List<String> getEat() {
        return eat;
    }

}
