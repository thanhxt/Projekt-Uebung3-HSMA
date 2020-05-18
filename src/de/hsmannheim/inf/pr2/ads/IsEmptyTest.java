package de.hsmannheim.inf.pr2.ads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsEmptyTest {

    /**
     * aufg 6
     * Test class isEmpty() method
     */

    @Test
    void isEmpty(){
        var s = new SearchTreeNode<Integer>(null,null,null);
        s.add(6);
        assertFalse(s.isEmpty());
    }

    @Test
    void isEmpty1(){
        var s = new SearchTreeNode<Integer>(5,null,null);

        assertTrue(s.isEmpty());
    }

    @Test
    void isEmpty2(){
        var s = new SearchTreeNode<Integer>(null,null,null);
        s.add(2);
        s.add(3);

        assertFalse(s.isEmpty());
    }

    @Test
    void isEmpty3(){
        var s = new SearchTreeNode<Integer>(40,null,null);

        assertTrue(s.isEmpty());
    }


}
