package menu.domain;

import java.util.List;

public class Coach {


    private List<String> hates;
    private List<String> eat;
    private String name;

    public Coach(String name) {
        this.name = name;
    }

    public List<String> getHates() {
        return hates;
    }

    public List<String> getEat() {
        return eat;
    }

    public String getName() {
        return name;
    }
}
