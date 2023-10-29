import oksana.internship.model.MyArrayList;
import org.junit.jupiter.api.Test;

import static oksana.internship.Main.createArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest1 {


    @Test
    void getItemInteger() {
        MyArrayList<Integer> arrayList = createArrayList(7, 9, 8);
        assertEquals(9, arrayList.showItemByIndex(1));
    }

    @Test
    void getItemString() {
        MyArrayList<String> arrayList = createArrayList("Ira", "Oleg", "Bob");
        assertEquals("Bob", arrayList.showItemByIndex(2));
    }

    @Test
    void showAddItemByIndex() {
        MyArrayList<String> arrayList = createArrayList("Ira", "Oleg", "Bob");
        arrayList.addItem(0, "Lena");
        assertTrue(arrayList.showItemByIndex(0) == "Lena");
    }

    @Test
    void showChangeSize() {
        MyArrayList<Integer> arrayList = createArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        arrayList.addItem(9);
        assertEquals(9, arrayList.getSize());
    }

    @Test
    void checkRemoveItem() {
        MyArrayList<String> arrayList = createArrayList("Ira", "Oleg", "Bob");
        arrayList.removeByIndex(1);
        assertTrue(arrayList.showItemByIndex(1) == "Bob");
    }

    @Test
    void array_isEmpty() {
        MyArrayList<Integer> arrayList = createArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        arrayList.clearArray();
        assertEquals(0, arrayList.getSize());
    }

    @Test
    void showEqualsArrayWithoutSort() {
        MyArrayList<Integer> arrayList = createArrayList(7, 9, 5, 6, 8, 3, 1, 5);
        MyArrayList<Integer> arrayListSort = createArrayList(1, 3, 5, 5, 6, 7, 8, 9);
        assertFalse(arrayList.equals(arrayListSort));
    }

    @Test
    void showSortArrayInteger() {
        MyArrayList<Integer> arrayList = createArrayList(7, 9, 5, 6, 8, 3, 1, 5);
        arrayList.sort();
        MyArrayList<Integer> arrayListSort = createArrayList(1, 3, 5, 5, 6, 7, 8, 9);
        assertTrue(arrayListSort.equals(arrayList));
    }

    @Test
    void showSortArrayString() {
        MyArrayList<String> arrayList = createArrayList("Ira", "Oleg", "Bob");
        arrayList.sort();
        MyArrayList<String> arrayListSort = createArrayList("Bob", "Ira", "Oleg");
        assertTrue(arrayListSort.equals(arrayList));
    }

}
