package de.hsmannheim.inf.pr2.ads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClearTest {

    /**
     * aufg 7
     * Test class for clear()
     */

    @Test
    void clear(){
        var s = new SearchTreeNode<Integer>(null,null,null);

        s.add(3);
        s.add(5);
        s.add(20);

        s.clear();
        assertTrue(s.isEmpty());
    }

    @Test
    void clear2(){
        var s = new SearchTreeNode<Integer>(null,null,null);

        s.add(5);
        s.add(6453);
        s.add(24);
        s.add(3);
        s.add(5);
        s.add(20);

        s.clear();
        assertTrue(s.isEmpty());
    }

    @Test
    void clear3(){
        var s = new SearchTreeNode<Integer>(null,null,null);
        s.add(36);
        s.add(64753);
        s.add(222);
        s.add(456);
        s.add(21);
        s.add(799);
        s.add(5);
        s.add(6453);
        s.add(4);
        s.add(3);
        s.add(2);
        s.add(1);

        s.clear();
        assertTrue(s.isEmpty());
    }
}
