package oksana.internship;

import oksana.internship.model.MyArrayList;

/**
 * @author Oksana
 * @version 1.0
 * Реализован ArrayList (не потокобезопасный).
 * Методы - добавить элемент, добавить элемент по индексу(не заменить),
 * получить элемент, удалить элемент, очистить всю коллекцию, отсортировать,
 * заменить элемент по индексу.
 */

public class Main {
    /**
     * Здесь входная точка в программу
     *
     * @param args - массив, хранящий значения типа String
     */
    public static void main(String[] args) {

        MyArrayList<Integer> arrayList = createArrayList(7, 9, 8);
        /**
         * @see MyArrayList#showArrayItems()
         */
        arrayList.showArrayItems();
        /**
         * @see MyArrayList#showItemByIndex(int)
         */
        arrayList.showItemByIndex(6); //получение элемента по индексу
        /**
         * @see  MyArrayList#addItemByIndex(int, Object)
         */
        arrayList.addItem(1, 3); //добавление элемента по индексу
        /**
         * @see MyArrayList#removeByIndex(int)
         */
        arrayList.removeByIndex(4); //удаление элемента по индексу
        /**
         * @see MyArrayList#setItem(int, Object)
         */
        arrayList.setItem(3, 5); //заменить элемент по индексу
        /**
         * @see MyArrayList#sort()
         */
        arrayList.sort(); //сортировка коллекции
        arrayList.showArrayItems();
        /**
         * @see MyArrayList#clearArray()
         */
        arrayList.clearArray(); //очистка коллекции
    }

    /**
     * создание коллекции из массива элементов универсальных параметров
     *
     * @param nums - элементы добавляемые в коллекцию
     * @param <T>  - универсальный параметр для типов добавляемых элементов
     * @return - созданная коллекция
     */
    public static <T> MyArrayList<T> createArrayList(T... nums) {
        MyArrayList<T> arrayList = new MyArrayList();
        for (T n : nums) {
            arrayList.addItem(n);
        }
        return arrayList;
    }
}
