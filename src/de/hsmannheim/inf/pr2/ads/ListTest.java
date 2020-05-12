package de.hsmannheim.inf.pr2.ads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    /**
     * Test class for ConainsIter() method
     */
    @Test
    void containsIter() {
        var l = new List<String>();

        l.addFirst("Tag");
        l.addFirst("Guten");

        assertTrue(l.containsIter("Guten"));
    }


    @Test
    void testContainsIter() {
        var s = new List<Integer>();

        s.addFirst(7);
        s.addFirst(55);
        s.addFirst(3);

        assertTrue(s.containsIter(3));
    }

    @Test
    void testContainsIter1() {
        var f = new List<Double>();

        f.addFirst(3.4);
        f.addFirst(2.1);
        f.addFirst(546457.1);

        assertTrue(f.containsIter(3.4));
    }

    @Test
    void testContainsIter2() {
        var r = new List<String>();

        r.addFirst("Tag");
        r.addFirst("Jeden");
        r.addFirst("Für");

        assertTrue(r.containsIter("Fur"));
    }
}