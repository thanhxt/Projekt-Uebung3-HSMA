package de.hsmannheim.inf.pr2.ads;

import com.sun.source.tree.Tree;

import java.util.Iterator;
import java.util.LinkedList;

public class TreeNode<E> implements Container2<E> {
    protected E value;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    /**
     * Knoten ohne Blatt
     * @param value Inhalt
     */
    public TreeNode(E value){
        this.value = value;
    }

    /**
     * Knoten mit Blättern bzw. Knoten
     * @param value Inhalt
     * @param left linkes Blatt, Knoten
     * @param right rechtes Blatt, Knoten
     */
    public TreeNode(E value, TreeNode<E> left, TreeNode<E> right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Getter Methoden
     * @return
     */
    public E getValue(){
        return this.value;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    /**
     * 2(b)(c)
     * Iterativer Vergleich linke rechte Baumhälfte
     * funktioniert
     * @param otherNode
     * @return
     */
    public boolean equalIt(TreeNode<E> otherNode){
        var node = this;
        var onode = otherNode;
        var queue = new LinkedList<TreeNode<E>>();
        boolean check = false;

        queue.add(node);
        while(!queue.isEmpty()){
            node = queue.pollLast();

            if(node.getLeft() != null && onode.getLeft() != null) {
                if (node.value == onode.value){
                    check = true;
                    queue.add(node.left);
                    node = node.left;
                    onode = onode.left;
                }
                else
                    check = false;
            }
            if(node.getRight() != null && onode.getRight() != null){
                if(node.value == onode.value){
                    check = true;
                    queue.add(node.right);
                    node = node.right;
                    onode = onode.right;
                }
                else
                    check = false;
            }
        }
        if(check)
            return true;
        else
            return false;
    }

    /**
     * 2(b)(c)
     * rekursiver vergleich linker rechte baumhälfte
     * funktioniert nicht
     * @param otherNode
     * @return
     */
    public boolean equalRek(TreeNode<E> otherNode){
        boolean check = false;
        if(this.left != null && otherNode.left != null){
            if(this.value == otherNode.value){
                check = true;
              this.left.equalRek(otherNode.left);
            }
            else
                check = false;
        }
        if(this.right != null && otherNode.right != null) {
            if (this.value == otherNode.value) {
                check = true;
                this.right.equalRek(otherNode.right);
            }
            else
                check = false;
        }
        if(check)
            return true;
        else
            return false;
    }
    
    /**
     * Aufg 5
     * Algorithmus
     * (1)
     * if Bäume = null return true
     * (2) else if bei Bäume != null
     *      (a) Wurzel vergleichen
     *      (b) linke baumhälfte vergleichen iterativ/rekursiv
     *      (c) rechte baumhälfte vergleichen iterativ/rekursiv
     *      (d) if (a)(b)(c) 1, return true
     * (3) else return false (ein Baum leer, ein Baum mit Inhalt)
     *
     * @param otherNode
     * @return
     */
    public boolean equalStructure(TreeNode<E> otherNode){
        //(1)
        if(this.value == null && otherNode.value == null)
            return true;
        //(2)
        if(this.value!=null && otherNode.value != null){
            //(a)
            if(this.value == otherNode.value){
                //(b) (c)
                if(equalIt(otherNode)){
                    return true;
                }
            }
        }
        //(3)
        return false;
    }
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public static void main(String[] args) {
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

        System.out.println(tree.equalStructure(sametree));


    }

}
