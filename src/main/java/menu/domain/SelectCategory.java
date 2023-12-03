package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.menu.Menu;

public class SelectCategory {
    private static final Menu menu = new Menu();
    private static final int NUMBER_OF_SELECTIONS = 5;
    private static final int MAX_CATEGORY_COUNT = 2;
    private static final int MIN_CATEGORY_RANGE = 1;
    private static final int MAX_CATEGORY_RANGE = 5;

    private static void select(Map<String, Integer> categoryCount, List<String> selectedCategory) {
        for (int i = 0; i < NUMBER_OF_SELECTIONS; i++) {
            String category;
            do {
                category = menu.categories.get(Randoms.pickNumberInRange(MIN_CATEGORY_RANGE, MAX_CATEGORY_RANGE));
            } while (categoryCount.getOrDefault(category, 0) >= MAX_CATEGORY_COUNT);

            selectedCategory.add(category);
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        }
    }

    public List<String> process() {
        List<String> selectedCategory = new ArrayList<>();
        Map<String, Integer> categoryCount = new HashMap<>();
        select(categoryCount, selectedCategory);
        return selectedCategory;
    }

}
