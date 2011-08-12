package com.reflectedcircle.toxicity;

import com.google.common.collect.Lists;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

public class DataRegister<T extends DataEntity> {
    private final Map<T, List<Integer>> stats = new HashMap<T, List<Integer>>();

    public void enter(T register, Integer value) {
        if (stats.containsKey(register)) {
            stats.get(register).add(value);
        } else {
            stats.put(register, Lists.<Integer>newArrayList(value));
        }
    }

    public CategoryDataset getDataSet() {
        DefaultMultiValueCategoryDataset dataset = new DefaultMultiValueCategoryDataset();
        for (Map.Entry<T, List<Integer>> entry : stats.entrySet()) {
            dataset.add(total(entry.getValue()), entry.getKey().type(), entry.getKey().name());
        }
        return dataset;
    }

    private List total(List<Integer> entry) {
        Integer value = 0;
        for (Integer integer : entry) {
            value += integer;
        }
        return newArrayList(value);
    }
}