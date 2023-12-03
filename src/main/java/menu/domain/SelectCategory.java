package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.menu.Menu;

public class SelectCategory {
    private static final Menu menu = new Menu();
    public List<String> process() {
        List<String> selectedCategory = new ArrayList<>();
        Map<String, Integer> categoryCount = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            String category;
            do {
                category = menu.categories.get(Randoms.pickNumberInRange(1, 5));
            } while (categoryCount.getOrDefault(category, 0) >= 2);

            selectedCategory.add(category);
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        }
        return selectedCategory;
    }

}
