import java.util.Iterator;

public class MyGenericList<T> implements Iterable<T>{
    private T[] items;
    private int size;

    public MyGenericList(){
        size = 0;
        items = (T[]) new Object[100];
    }
    public void add(T element){
        items[size++] = element;
    }

    public T get(int index){
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new MyGenericListIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for(int i = 0; i<size; i++){
            res.append(items[i].toString());
            if(i != size-1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    private class MyGenericListIterator implements Iterator<T>{
        private MyGenericList<T> list;
        private int index = 0;
        public MyGenericListIterator(MyGenericList<T> list) {
            this.list = list;
        }
        @Override
        public boolean hasNext() {
            return index < list.size;
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
