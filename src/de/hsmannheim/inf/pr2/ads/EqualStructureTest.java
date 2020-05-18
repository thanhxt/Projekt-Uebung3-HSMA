package de.hsmannheim.inf.pr2.ads;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.beans.Transient;

import static org.junit.jupiter.api.Assertions.*;

public class EqualStructureTest {

    /**
     * aufg 5
     * Test class equalStructure() method
     */

    @Test
    void equalstruct(){
        var tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        new TreeNode<Integer>(3),
                        new TreeNode<Integer>(4,
                                new TreeNode<Integer>(5),
                                new TreeNode<Integer>(6))),
                new TreeNode<Integer> (7));

        var sametree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        new TreeNode<Integer>(3),
                        new TreeNode<Integer>(4,
                                new TreeNode<Integer>(5,
                                        new TreeNode<Integer>(8),
                                        new TreeNode<Integer>(9)),
                                new TreeNode<Integer>(6))),
                new TreeNode<Integer> (7));

        assertFalse(tree.equalStructure(sametree));
    }

    @Test
    void equalstruct2(){
        var tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        new TreeNode<Integer>(3),
                        new TreeNode<Integer>(4,
                                new TreeNode<Integer>(5),
                                new TreeNode<Integer>(6))),
                new TreeNode<Integer> (7));

        var sametree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        new TreeNode<Integer>(3),
                        new TreeNode<Integer>(4,
                                new TreeNode<Integer>(5),
                                new TreeNode<Integer>(6))),
                new TreeNode<Integer> (7));

        assertTrue(tree.equalStructure(sametree));
    }

    @Test
    void equalStruct3(){
        var tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        new TreeNode<Integer>(3),
                        new TreeNode<Integer>(4,
                                new TreeNode<Integer>(5),
                                new TreeNode<Integer>(6))),
                new TreeNode<Integer> (7));

        var sametree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        new TreeNode<Integer>(3),
                        new TreeNode<Integer>(4,
                                new TreeNode<Integer>(5,
                                        new TreeNode<Integer>(8,
                                            new TreeNode<Integer>(2),
                                            new TreeNode<Integer>(12)),
                                        new TreeNode<Integer>(9)),
                                new TreeNode<Integer>(6))),
                new TreeNode<Integer> (7));

        assertFalse(tree.equalStructure(sametree));
    }

    @Test
    void equalStruct4(){
        var tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(3,
                        new TreeNode<Integer>(5),
                        new TreeNode<Integer>(4)),
                new TreeNode<Integer>(4));

        var sametree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,
                        new TreeNode<Integer>(3),
                        new TreeNode<Integer>(4,
                                new TreeNode<Integer>(5),
                                new TreeNode<Integer>(6))),
                new TreeNode<Integer> (7));

        assertFalse(tree.equalStructure(sametree));
    }

    @Test
    void equalStruct5(){
        var tree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(3,
                        new TreeNode<Integer>(5),
                        new TreeNode<Integer>(4)),
                new TreeNode<Integer>(4));

        var sametree = new TreeNode<Integer>(1,
                new TreeNode<Integer>(3,
                        new TreeNode<Integer>(5),
                        new TreeNode<Integer>(4)),
                new TreeNode<Integer>(4));

        assertTrue(tree.equalStructure(sametree));
    }
}
