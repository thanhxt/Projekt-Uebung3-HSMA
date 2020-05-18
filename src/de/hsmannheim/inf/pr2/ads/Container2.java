package de.hsmannheim.inf.pr2.ads;

public interface Container2<E> extends Iterable<E> {
    public E getValue();
    public TreeNode<E> getLeft();
    public TreeNode<E> getRight();
    public boolean equalStructure(TreeNode<E> otherNode);

    int height();
    boolean contains(E e);
}
