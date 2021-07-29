public class Message <T> {
    private T value;
    public Message() {
    }
    public Message (T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public String toString() {
        if (value == null) {
            return null;
        }
        return value.getClass().getName() + " :" + value;
    }
}
class Runner {
    public static void main(String[ ] args) {
        // параметризация типом Integer
        Message<Integer> ob1 = new Message<Integer>();
        ob1.setValue(1); // возможен только тип Integer для метода setValue
        int v1 = ob1.getValue();
        System.out.println(v1);
        // параметризация типом String
        Message<String> ob2 = new Message<String>("Java");
        String v2 = ob2.getValue();
        System.out.println(v2);
        // ob1 = ob2; // ошибка компиляции – параметризация нековариантна

        // параметризация по умолчанию – Object
        Message ob3 = new Message(); // warning – raw type
        ob3 = ob1; // нет ошибки компиляции – нет параметризации
        System.out.println(ob3.getValue());
        ob3.setValue(new Byte((byte)1));
        ob3.setValue("Java SE 7");
        System.out.println(ob3); /* выводится тип объекта,
 а не тип параметризации */
        ob3.setValue(71);
        System.out.println(ob3);
        ob3.setValue(null);
    }
}

