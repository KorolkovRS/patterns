package behavioral.Iterator;

interface List<E> {
    Iterator<E> iterator();
    void add(E num);
    E get(int index);
    int size();
}

interface Iterator<E> {
    boolean hasNext();
    E next();
}

class ArrayList<E> implements List<E> {
    private Object[] array;
    private int capacity;
    private int size = 0;
    private int index = -1;

    public ArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<>();
    }

    @Override
    public void add(E c) {
        index++;
        if (index >= array.length) {
            throw new RuntimeException("Capacity = " + capacity + ", index = " + index);
        }
        size++;
        array[index] = c;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Size = " + size + ", index = " + index);
        }
        return (E) array[index];
    }

    @Override
    public int size() {
        return size;
    }

    private class ArrayListIterator<E> implements Iterator<E> {
        private int index = -1;
        @Override
        public boolean hasNext() {
            return index < size - 1;
        }

        @Override
        public E next() {
            index++;
            if (index >= size) {
                throw new IndexOutOfBoundsException("Size = " + size + ", index = " + index);
            }
            return (E)array[index];
        }
    }
}

class Solution {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(10);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        System.out.println("Size = " + integerList.size());
        System.out.println(integerList.get(3));

        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


