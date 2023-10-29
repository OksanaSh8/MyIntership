package oksana.internship.model;

import java.util.*;

/**
 * класс для создания коллекции ArrayList
 *
 * @param <T> - универсальный параметр типов данных из которых состаит коллекция
 */
public class MyArrayList<T> {
    /**
     * первоначальный размер массива
     */
    private static final int INITIAL_SIZE = 8;
    private Object[] items;
    /**
     * показывает насколько заполнен массив
     */
    private int currentSize;

    /**
     * конструктор для создании коллекции с первоначальной емкостью 8 элементов
     */
    public MyArrayList() {
        items = new Object[INITIAL_SIZE];
    }

    /**
     * получение элемента по индексу
     *
     * @param index - индекс элемента, который будет выведен на экран
     */
    public T showItemByIndex(int index) {
        if (isValidIndex(index))
            System.out.println("Элемент по индексу " + index + " = " + items[index]);
        else System.out.println("Index " + index + " is out of array");
        return (T) items[index];
    }

    private boolean isValidIndex(int index) {
        return (index >= 0 && index < currentSize);
    }

    /**
     * добавление элемента
     *
     * @param item - добавляемый элемент в коллекцию
     */
    public void addItem(T item) {
            if (currentSize == items.length) {
                items = Arrays.copyOf(items, items.length * 5 / 4);
            }
        items[currentSize++] = item;
    }

    /**
     * определение размера массива
     * @return размер массива
     */
    public int getSize(){
        return currentSize;
    }

    /**
     * добавление элемента по индексу
     *
     * @param index   - индекс, по которому будет добавлен элемент
     * @param newItem - добавляемый элемент
     */
    public void addItem(int index, Object newItem) {
        if (isValidIndex(index)) {
            System.arraycopy(items, index, items, index + 1, currentSize - index);
            items[index] = newItem;
            currentSize++;
            showArrayItems();
        } else System.out.println("Index " + index + " is out of array");
    }

    /**
     * удаление элемента по индексу
     *
     * @param index - индекс удаляемого элемента
     */
    public void removeByIndex(int index) {
        if (isValidIndex(index)) {
            System.arraycopy(items, index + 1, items, index, currentSize - index);
            currentSize--;
            showArrayItems();
        } else System.out.println("Index " + index + " is out of array");
    }

    /**
     * очистка коллекции
     */
    public void clearArray() {
            for (int i = 0; i < items.length; i++)
                items[i] = null;
            System.out.println("очистка коллекции");
            currentSize = 0;
            showArrayItems();
    }

    /**
     * замена элемента по индексу
     *
     * @param index   - индекс заменяемого элемента
     * @param newItem - заменяемый элемент
     */
    public void setItem(int index, T newItem) {
        if (isValidIndex(index)) {
            items[index] = newItem;
            System.out.println("замена элемента находящегося под индексом " + index + " на элемент = " + newItem);
            showArrayItems();
        } else System.out.println("Index " + index + " is out of array");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> arrayList = (MyArrayList<?>) o;
        return currentSize == arrayList.currentSize && Arrays.equals(items, arrayList.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(currentSize);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    /**
     * сортировка коллекции с помощью компаратора
     *
     * @param comparator - используемый компоратор для сортировки коллекции
     */
    public void sort(Comparator<? super T> comparator) {
        Arrays.sort((T[]) items, 0, currentSize, comparator);
    }

    /**
     * сортировка коллекции
     */
    public void sort() {
        ComparatorArray comparator = new ComparatorArray<Integer>();
        Arrays.sort((T[]) items, 0, currentSize, comparator);
    }

    /**
     * вывод коллекции на экран
     */
    public void showArrayItems() {
        System.out.print("ArrayItems  { ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println("}");
    }
}
