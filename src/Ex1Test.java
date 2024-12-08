import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        int s1 = 15;
        int base = 3;
        String v = Ex1.int2Number(s1,base);
        assertTrue(v.equals("120b3"));
        int s2 = 21;
        int base2 = 2;
        String v2 = Ex1.int2Number(s2,base2);
        assertTrue(v2.equals("10101b2"));
    }
    @Test
    void maxIndexTest() {
        String[] arr = {"325bG",null,"","-1"};
        assertEquals(0,Ex1.maxIndex(arr));
        String[] arr1 = {"32b3","3b1","-123bG","12b44"};
        assertEquals(-1,Ex1.maxIndex(arr1));
        String[] arr2 = {"32","3b5","101010011b2","12b44"};
        assertEquals(2,Ex1.maxIndex(arr2));
    }

    @Test
    void equalsTest() {
        String str1 = "15",str2 = "1111b2";
        assertTrue(Ex1.equals(str1,str2));
        String str3 = "1021b3",str4 = "131b5";
        assertFalse(Ex1.equals(str3,str4));
        String str5 = "45b7",str6 = "37bB";
        assertFalse(Ex1.equals(str5,str6));
    }

    @Test
    void getNumValueTest(){
        assertEquals(-1,Ex1.getNumValue('a'));
        assertEquals(10,Ex1.getNumValue('A'));
        assertEquals(16,Ex1.getNumValue('G'));
        assertEquals(-1,Ex1.getNumValue('b'));
    }
    @Test
    void getStrValueTest(){
        assertEquals("B",Ex1.getStrValue(11));
        assertEquals("",Ex1.getStrValue(-1));
        assertEquals("4",Ex1.getStrValue(4));
        assertEquals("F",Ex1.getStrValue(15));
    }
    @Test
    void allDigitsTest(){
        assertTrue(Ex1.allDigits("84152456"));
        assertFalse(Ex1.allDigits("84152a456"));
        assertFalse(Ex1.allDigits("-1"));
        assertFalse(Ex1.allDigits(" 24"));
        assertTrue(Ex1.allDigits(""));
    }
}