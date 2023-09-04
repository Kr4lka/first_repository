import java.util.Arrays;
public class MyStringArray {
    private String[] array;
    private int size;

    public MyStringArray(int length){
        this.array = new String[length];
        this.size = 0;
    }

    public MyStringArray(){
        this(5);
    }

    private void increaseCapacity(){
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    public void add (String element){
        if (size == array.length){
            increaseCapacity();
        }
        array[size] = element;
        size++;
    }

    public void remove (int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        array[size] = null;
    }

    public void sortRight() {
        Arrays.sort(array, 0, size);
    }

    public void sortLeft() {
        Arrays.sort(array, 0, size);
        for (int i = 0; i < size / 2; i++){
            String temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}