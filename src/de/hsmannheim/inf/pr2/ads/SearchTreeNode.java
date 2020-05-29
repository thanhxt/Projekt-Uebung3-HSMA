package de.hsmannheim.inf.pr2.ads;

import com.sun.source.tree.Tree;

import java.util.LinkedList;

public class SearchTreeNode<E extends Comparable<E>> extends TreeNode<E> {

    protected SearchTreeNode<E> root;
    protected TreeNode<E> nodes = root;


    public SearchTreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
        super(value, left, right);
    }

    /**
     * aufg 6
     * wenn wurzel keinen inhalt hat
     * @return true
     */
    public boolean isEmpty(){
        if(this.root == null)
            return true;
        else
            return false;
    }


    public boolean add(E o){
        //Fall 1 Blatt ist noch leer
        //Conclusion: ein neues Element(Blatt) als neue Wurzel
        if(this.root == null){
            this.root = new SearchTreeNode<E>(o,null,null);
            return true;
        }

        //Fall 2,3 und 4, Baum ist nicht leer, man muss die richtige Stelle zum Einfügen finden
        var parent = root;
        var node = root;
        while(node != null){ //solange im Baum hinabsteigen, bis...
            parent = node;
            if(o.compareTo(node.getValue()) < 0){
                // o muss in den linken Unterbaum
                node = (SearchTreeNode<E>) node.left;
                // o muss in den rechten Unterbaum
            } else if(o.compareTo(node.getValue()) > 0){
                node = (SearchTreeNode<E>) node.right;
            }else { //o ist schon im Baum enthalten, abbrechen
                return false;
            }
        }
        //an dieser Stelle ist klar: o ist nicht im Baum,
        //node ist null und parent Ist der SearchTreeNode, unter dem o einsoriert werden muss
        if(o.compareTo(parent.getValue()) < 0){
            parent.left = new SearchTreeNode<E>(o,null,null);
        } else{
            parent.right = new SearchTreeNode<E>(o,null,null);
        }
        return true;
    }

    /**
     *  FALSCHER GEDANKENGANG
     *  löscht alle Elemente aus dem Suchbaum
     *
     * (0) if root = null there is no tree
     * (1) if
     *
     * (0) if root = null there is no tree.
     * (1) search for minValue
     * (2) traverse through tree and compare minValue with value
     * (3) set the node = null to remove it
     * (4) search for maxValue
     * (5) traverse through tree and compare maxValue with value
     * (6) set the node = null to remove it
     * (7) repeat it until root.left and root.right = null
     * (8) if root right and left = null,
     *          root = null;
     */

    public void clear2(){
        if (root == null){
            System.out.println("Baum ist leer");
        }
        var node = root;
        //(1) (2)
        while(root.left != null) {
            if (minValue() == node.value) {
                //(3)
                node.value = null;
                node = root;
            }else
            node = (SearchTreeNode<E>) node.left;
        }
        node = root;

        //(4)(5)
        while(root.right != null){

            if(maxValue() == node.value){
                //(6)
                node.value = null;
                node = root;
            }else
            node = (SearchTreeNode<E>) node.right;
        }

        if(root.left == null && root.right == null){
            root = null;
        }
    }
    public E maxValue(){
        E maxValue = root.value;
        var node = root;

        while(node.right != null){
            maxValue = node.right.value;
            node = (SearchTreeNode<E>) node.right;
        }
        return maxValue;
    }
    public E minValue(){
        E minValue = root.value;
        var node = root;

        while(node.left != null){


            minValue = node.left.value;
            node = (SearchTreeNode<E>) node.left;
        }
        return minValue;
    }


    /**
     * RICHTIG
     * löscht alle Elemente aus dem Suchbaum
     */
    public void clear(){
        if(root != null)
            root = null;
    }
/*
    public int height(){
        int leftHeight = 1, rightHeight = 1;

        if(root == null)
            return 0;

        if(this.left != null){
            leftHeight += this.left.height();
        }
        if(this.right != null){
            rightHeight += this.right.height();
        }
        System.out.println(leftHeight + " " + rightHeight);
        return Math.max(leftHeight,rightHeight);
    }
 */

    /**
     * aufg 8
     * @return
     */
    public int height(){
        //wenn kein inhalt
        if(root == null)
            return 0;

        var node = root;
        int leftHeight = 1;

        //iterativ geht nach links durch
        while(node.left != null){
            leftHeight++;
            node = (SearchTreeNode<E>) node.left;
        }

       node = root;
        int rightHeight = 1;

        //iterativ geht nach rechts durch
        while(node.right != null){
            rightHeight++;
            node = (SearchTreeNode<E>) node.right;
        }

        //gibt größten wert zurück
        return Math.max(leftHeight, rightHeight);
    }
/*
    public boolean contains(E e){
        if(this.root == null)
            return false;
        var node = root;

        if (root.value == e)
            return true;
        else if(e.compareTo(node.getValue())<0){
            return node.left == e ||  node.left.contains(e);
        }
        else
            return node.right == e || node.right.contains(e);

    }
 */
/*
    public boolean contains(E e){

        if(root == null)
            return false;

        if(root.value.equals(e))
            return true;
        else if(e.compareTo(root.getValue())<0){
            root = (SearchTreeNode<E>) root.left;
            return root.value.equals(e) || root.left.contains(e);
        } else {
            root = (SearchTreeNode<E>) root.right;
            return root.value.equals(e) || root.right.contains(e);
        }
    }


    public void inOrder(TreeNode<E> root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

 */


    public boolean traverseRek(E e, TreeNode<E> root){

        //Wenn Wurzel == e, return true
        if(root.value.equals(e))
            return true;

        boolean result = false;
        //wenn value == e, return true
        if(root.value.equals(e))
            return true;
        //wenn e < value && e > minValue
        else if(e.compareTo(root.getValue())<0 && minValue().compareTo(root.getValue())<0)
           result = traverseRek(e,root.left);  //rekursive Wiederholung mit root.left

        //wenn e > value && e < maxValue
        else if(e.compareTo(root.getValue())>0 && maxValue().compareTo(root.getValue())>0){
            result = traverseRek(e,root.right); // rekursive Wiederholung mit root.right
        }
        return result;
    }
/*
    public boolean traverseLeft(E e, TreeNode<E> root){
        return e.equals(root.value) || traverseLeft(e, root.left);
    }

    public boolean traverseRight(E e, TreeNode<E> root){
        return e.equals(root.value) || traverseRight(e, root.right);
    }
*/

    /**
     * Aufg 9
     * @param e Gesuchte Element
     * @return true, wenn das Element existiert
     */
    public boolean contains(E e){
        if(root == null)
            return false;

        return traverseRek(e, root);
    }



/*
bisher Erfolgreicher versuch, erfüllt rahmenbedingungen aber nicht
public boolean contains(E e, SearchTreeNode <E> node){

    if(node == null)
        return false;

    if(node.value.equals(e))
        return true;
    boolean result = false;

    if(e.compareTo(node.getValue())<0)
        result = contains(e, (SearchTreeNode<E>) node.left);
    else if(e.compareTo(node.getValue())>0){
        result = contains(e, (SearchTreeNode<E>) node.right);
    }

    return result;

 */



    public static void main(String[] args) {
        var s = new SearchTreeNode<Integer>(null,null,null);

        s.add(4);
        s.add(2);
        s.add(1);
        s.add(5);
        s.add(6);
        s.add(3);




        System.out.println(s.height());
        //System.out.println(s.contains(6,s.root));
        System.out.println(s.contains(7));
        //Testtt

    }


}
