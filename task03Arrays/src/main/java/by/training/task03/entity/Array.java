package by.training.task03.entity;

import java.util.Arrays;

public class Array {

    private int[] values;

    public Array(int[] values) {
        this.values = values;
    }
    public Array (int n){ values= new int[n];}

    public int getValue(int index) {
        return values[index];
    }

    public void setValues(int index, int value) {
        values[index] = value;
    }

    public int getLength() {
        return values.length;
    }

    /**
     * Swaps array elements
     * @param left
     * @param rigth
     */

    public void swap(int left, int rigth) {
        int tmp = values[left];
        values[left] = values[rigth];
        values[rigth] = tmp;
    }    // Найти и понять способ поменять местами не заводя дополнительную переменную

    public int[] getArray()
    {
        return values;
    }

    public int hashValue( int index) {

        return (Arrays.hashCode(values)+index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        int length = array.getLength();
        for (int i = 0; i < length; i++) {
            if(array.getValue(i) != values[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return "Array{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
