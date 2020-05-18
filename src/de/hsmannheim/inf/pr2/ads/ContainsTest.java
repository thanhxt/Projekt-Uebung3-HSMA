package de.hsmannheim.inf.pr2.ads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsTest {

    /**
     * aufg 3
     * Test class for contains() method
     */
    @Test
    void contains() {
        var s = new List<String>();

        s.addFirst("Welt");
        s.addFirst("Hallo");

        assertTrue(s.contains("Hallo"));
    }

    @Test
    void testContains() {
        var f = new List<Integer>();

        f.addFirst(3);
        f.addFirst(2);
        f.addFirst(123214);

        assertTrue(f.contains(2));
    }

    @Test
    void testContains1() {
        var g = new List<String>();

        g.addFirst("Tag");
        g.addFirst("Guten");

        assertTrue(g.contains("Guten"));
    }
}