import exceptions.InvalidIndexException;
import org.junit.jupiter.api.Test;
import static constants.IntegerListImplTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import exceptions.NullItemException;

class IntegerListImpTest {
    private final IntegerListImp out = new IntegerListImp();

    @Test
    void shouldReturnCorrectResult_add() {
        Integer actual = out.add(ITEM1);
        assertEquals(ITEM1, actual);
        assertThrows(NullItemException.class, () -> out.add(ITEM2));
    }

    @Test
    void shouldReturnCorrectResult_add2() {
        Integer actual = out.add(INDEX1, ITEM1);
        assertEquals(ITEM1, actual);
        assertThrows(InvalidIndexException.class, () -> out.add(INDEX2, ITEM1));
        assertThrows(NullItemException.class, () -> out.add(INDEX1, ITEM2));
    }

    @Test
    void shouldReturnCorrectResult_set() {
        Integer actual = out.set(INDEX1, ITEM1);
        assertEquals(ITEM1, actual);
        assertThrows(InvalidIndexException.class, () -> out.set(INDEX2, ITEM1));
        assertThrows(NullItemException.class, () -> out.set(INDEX1, ITEM2));
    }

    @Test
    void shouldReturnCorrectResult_removeItem() {
        out.add(ITEM1);
        Integer actual = out.remove(ITEM1);
        assertEquals(ITEM1, actual);
        assertThrows(NullItemException.class, () -> out.remove(ITEM2));
    }

    @Test
    void shouldReturnCorrectResult_removeIndex() {
        out.add(INDEX1, ITEM1);

        Integer actual = out.remove(INDEX1);
        assertEquals(ITEM1, actual);
        assertThrows(InvalidIndexException.class, () -> out.remove(INDEX2));

    }

    @Test
    void shouldReturnCorrectResult_indexOf() {
        out.add(ITEM1);
        int expected = 0;
        int actual = out.indexOf(ITEM1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectResult_lastIndexOf() {
        out.add(ITEM1);
        int expected = 0;
        int actual = out.lastIndexOf(ITEM1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectResult_get() {
        out.add(INDEX1, ITEM1);
        Integer actual = out.get(INDEX1);
        assertEquals(ITEM1, actual);
        assertThrows(InvalidIndexException.class, () -> out.get(INDEX2));
    }

    @Test
    void testEquals() {
        IntegerListImp integerList1 = new IntegerListImp(1);
        IntegerListImp integerList2 = new IntegerListImp(1);
        IntegerListImp integerList3 = new IntegerListImp(2);

        integerList1.add(ITEM1);
        integerList2.add(ITEM1);
        integerList3.add(ITEM1);
        integerList3.add(ITEM3);

        assertTrue(integerList1.equals(integerList2));
        assertFalse(integerList1.equals(integerList3));
    }

    @Test
    void shouldReturnCorrectResult_size() {
        int actual = out.size();
        assertEquals(SIZE, actual);
    }

    @Test
    void isEmpty() {
        boolean expected = true;
        boolean actual = out.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void testToArray() {
        IntegerListImp integerListImpList = new IntegerListImp(1);
        integerListImpList.add(ITEM1);

        Integer[] array = integerListImpList.toArray();

        assertEquals(integerListImpList.size(), array.length);

        for(Integer str: array) {
            assertTrue(integerListImpList.contains(str));
        }
    }

    @Test
    void contains() {
        IntegerListImp integerList1 = new IntegerListImp(1);
        integerList1.add(ITEM1);

        assertTrue(integerList1.contains(ITEM1));
        assertFalse(integerList1.contains(ITEM3));
    }
    @Test
    void binarySearch() {
        IntegerListImp integerList1 = new IntegerListImp(1);
        integerList1.add(ITEM1);
        Integer[] array = integerList1.toArray();

        assertTrue(integerList1.binarySearch(array,ITEM1));
        assertFalse(integerList1.binarySearch(array,ITEM3));
        assertFalse(integerList1.contains(ITEM3));
    }
}
