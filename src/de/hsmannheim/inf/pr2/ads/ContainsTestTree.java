package de.hsmannheim.inf.pr2.ads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainsTestTree {

    /**
     * aufg 9
     * Test class contains method (SearchTree)
     */

    @Test
    void Contains(){
        var s = new SearchTreeNode<Integer>(null,null,null);

        s.add(4);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(5);
        s.add(6);

        assertTrue(s.contains(2));
    }

    @Test
    void Contains2(){
        var s = new SearchTreeNode<Integer>(null,null,null);

        s.add(4);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(5);
        s.add(6);

        assertFalse(s.contains(7));
    }

    @Test
    void Contains3(){
        var s = new SearchTreeNode<Integer>(null,null,null);

        s.add(4);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(5);
        s.add(6);

        assertTrue(s.contains(4));
    }
}
