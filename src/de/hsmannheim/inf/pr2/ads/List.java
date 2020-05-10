package de.hsmannheim.inf.pr2.ads;

import java.awt.*;
import java.util.Iterator;

public class List<E> implements Container<E> {
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private class ListNode<T> {
        T value;
        ListNode<T> next;

        public ListNode(final T value, final ListNode<T> next){
            this.value = value;
            this.next = next;
        }

        public int size(){
            if(this.next == null){
                return 1;
            }
            else return 1 + this.next.size();
        }

        public String toListString(){
            if(this.next == null){
                return ")";
            }else {
                return ", " +this.next.value.toString() + this.next.toListString();
            }
        }

    }
        private ListNode<E> head;
        public List(){
            this.head=null;
        }

        public void addFirst(final E val){
            this.head = new ListNode<>(val, this.head);
        }

        public int size(){
            if(this.head != null){
                return this.head.size();
            } else{
                return 0;
            }
        }
        public String toListString(){
            if(this.head!=null){
                return "("+this.head.value.toString() + this.head.toListString();
            }else{
                return "";
            }
        }

        @Override
        public boolean contains(E o) {
            return false;
        }
        @Override
        public void clear() {

        }


    public static void main(String[] args){
            var l = new List<Integer>();
            var s = new List<String>();

            l.addFirst(8);
            l.addFirst(5);
            l.addFirst(3);
            l.addFirst(2);
            l.addFirst(1);
            l.addFirst(1);
            System.out.println(l.toListString());

            s.addFirst("schön");
            s.addFirst("ist");
            s.addFirst("Wetter");
            s.addFirst("das");
            s.addFirst("Welt");
            s.addFirst("Hallo");
            System.out.println(s.toListString());
        }

}
