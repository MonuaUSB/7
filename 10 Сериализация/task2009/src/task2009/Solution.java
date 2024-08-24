package task2009;

import java.io.*;

/* 
Как сериализовать static?
Сделай так, чтобы сериализация класса ClassWithStatic была возможной.


Requirements:
1. Класс ClassWithStatic должен существовать внутри класса Solution.
2. Класс ClassWithStatic должен быть статическим.
3. Класс ClassWithStatic должен быть публичным.
4. Класс ClassWithStatic должен поддерживать интерфейс Serializable.*/

public class Solution {
    public static class ClassWithStatic implements  Serializable{
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        private void writeObject(ObjectOutputStream out) throws Exception {
            out.defaultWriteObject();
            out.writeObject(staticString);
        }
        private void readObject(ObjectInputStream in) throws Exception {
            in.defaultReadObject();
            staticString = (String) in.readObject();
        }


    }

    public static void main(String[] args) {
        try {
            ClassWithStatic original = new ClassWithStatic();
            original.i = 10;
            original.j = 20;
            ClassWithStatic.staticString = "Обновленное значение";
            FileOutputStream file = new FileOutputStream("file1.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(original);
            out.close();

            FileInputStream file1 = new FileInputStream("file1.txt");
            ObjectInputStream in = new ObjectInputStream(file1);
            ClassWithStatic restored = (ClassWithStatic) in.readObject();
            in.close();

            System.out.println("i: "+ restored.i);
            System.out.println("j: "+ restored.j);
            System.out.println("staticString: "+ restored.staticString);






        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
