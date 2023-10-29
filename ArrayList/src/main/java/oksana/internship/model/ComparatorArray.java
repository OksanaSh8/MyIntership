package oksana.internship.model;

import java.util.Comparator;

/**
 * класс компаратора для сортировки элементов массива
 *
 * @param <T> - универсальный параметр
 */

public class ComparatorArray<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if (o1 instanceof Integer && o2 instanceof Integer)
            return (Integer) o1 - (Integer) o2;
        else if (o1 instanceof String && o2 instanceof String)
            return ((String) o1).compareTo((String) o2);
        return 0;
    }
}