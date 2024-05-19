package ListTests;

import List.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ListTests {
    private List<Integer> list;

    @Test
    public void addTest() {
        list = new List<Integer>();
        list.add(1);
        list.add(0);

        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(0), list.get(1));
    }

    @Test
    public void removeTest() {
        list = new List<Integer>();
        list.add(1);
        list.add(0);
        list.add(9);
        list.add(4);
        list.add(5);

        list.remove(1);
        list.remove(3);

        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(9), list.get(1));
        assertEquals(Integer.valueOf(4), list.get(2));
    }

    @Test
    public void isEmptyTest() {
        list = new List<Integer>();

        assertTrue(list.isEmpty());

        list.add(1);

        assertFalse(list.isEmpty());
    }

    @Test
    public void clearTest() {
        list = new List<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void indexOutOfBoundsTest() {
        list = new List<Integer>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));

        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    public void sizeTest() {
        list = new List<Integer>();
        list.add(1);
        list.add(0);
        list.add(9);
        list.add(0);
        list.add(0);

        assertEquals(5, list.size());
    }
}