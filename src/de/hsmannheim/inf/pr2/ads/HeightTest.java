package de.hsmannheim.inf.pr2.ads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class HeightTest {

    /**
     * aufg 8
     * Test class height() method
     */

    @Test
    void height(){
        var s = new SearchTreeNode<Integer>(null,null,null);
        s.add(4);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(5);
        s.add(7);

        assertEquals(3, s.height());
    }
    void height2() {
        var s = new SearchTreeNode<Integer>(null, null, null);
        s.add(4);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(5);
        s.add(7);
        s.add(8);

        assertEquals(4, s.height());
    }
    void height3() {
        var s = new SearchTreeNode<Integer>(null, null, null);
        s.add(4);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(5);
        s.add(7);
        s.add(9);
        s.add(8);

        assertEquals(4, s.height());
    }
}
