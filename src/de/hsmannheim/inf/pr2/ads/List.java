package de.hsmannheim.inf.pr2.ads;

import java.util.Iterator;

public class List<E> implements ContainerList<E> {
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private class ListNode<T> {
        T value;
        ListNode<T> next;

        /**
         * List Structure
         * @param value
         * @param next
         */
        public ListNode(final T value, final ListNode<T> next){
            this.value = value;
            this.next = next;
        }

        /**
         *
         * @return the size of the list
         */
        public int size(){
            if(this.next == null){
                return 1;
            }
            else return 1 + this.next.size();
        }

        /**
         * List to String converter
         * @return
         */
        public String toListString(){
            if(this.next == null){
                return ")";
            }else {
                return ", " +this.next.value.toString() + this.next.toListString();
            }
        }

        /**
         * Vergleich des Elementes Iterativ
         * @param e
         * @return
         */
        public boolean containsIter(E e){
            int i = 0;
            var element = this;

            while(element != null){
                if(e.equals(element.value))
                    i++;
                element = element.next;
            }

            if(i>=1)
                return true;
            else
                return false;
        }

        /**
         * aufg 3
         * rekursion, methode ruft sich selbst auf ohne schleifen
         * @param o
         * @return  wenn value == o return true sonst this.next.contains
         */
        public boolean contains(E o) {
            if(this.next == null) {
                return false;
            }
            return  this.value == o || this.next.contains(o);
        }

    }

    /**
     * Start of the list Head structure
     */
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

    public boolean containsIter(E e){
        int i = 0;

        if(this.head != null) {
            if (this.head.containsIter(e))
                i++;
        }
        if(i>=1){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E o) {
        int i = 0;

        if(this.head != null) {
            if (this.head.contains(o))
                i++;
        }
        if(i>=1){
            return true;
        }
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
            System.out.println(l.containsIter(9));
            System.out.println(l.contains(2));

            s.addFirst("schön");
            s.addFirst("ist");
            s.addFirst("Wetter");
            s.addFirst("das");
            s.addFirst("Welt");
            s.addFirst("Hallo");
            System.out.println(s.toListString());
            System.out.println(s.containsIter("ist"));
            System.out.println((s.contains("ist")));

            var r = new List<Integer>();
            System.out.println(r.toListString());
            System.out.println(r.contains(5));


        }

}
