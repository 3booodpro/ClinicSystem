import java.util.Date;

public class CustomArray {
    private Object[] array;

    public Object[] getArray() {
        return array;
    }

    public String toString() {
        String output = "{";
        for (int i = 0; i < array.length; i++) {
            output += array[i];
            if (i < array.length - 1) {
                output += ", ";
            }
        }
        output += "}";

        return output;
    }

    public Object getElement(int index) {
        return array[index];
    }

    public void addElement(Object element) {
        int new_size = array.length + 1;
        Object[] new_array = new Object[new_size];
        for (int i = 0; i < new_size - 1; i++) {
            new_array[i] = array[i];
        }
        new_array[new_size - 1] = element;
        array = new_array;
    }

    public void removeElement(int index) {
        if (index < 0) {
            index = array.length + index;
        }

        int size = array.length;
        int last_new_index = 0;
        Object[] new_array = new Object[size - 1];
        for (int i = 0; i < size; i++) {
            if (i == index) {
                continue;
            }
            System.out.println(i);
            new_array[last_new_index] = array[i];
            last_new_index += 1;
        }
        array = new_array;
    }

    public int getSize() {
        return array.length;
    }

    public boolean isEmpty() {
        return array.length > 0;
    }

    CustomArray() {
        array = new Object[0];
    }

    CustomArray(Object[] initial_data) {
        array = initial_data;
    }

}
