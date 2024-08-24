package task2021;

import java.io.*;

/* 
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.


Requirements:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс SubSolution должен быть создан внутри класса Solution.
3. Класс SubSolution должен быть потомком класса Solution.
4. При попытке сериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
5. При попытке десериализовать объект типа SubSolution должно возникать исключение NotSerializableException.*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException("Сериализация SubSolution не поддерживается");
        }
        private void readObject(ObjectInputStream in) throws IOException {
            throw new NotSerializableException("Десериализация SubSolution не поддерживается");
        }
    }

    public static void main(String[] args) {
        try {
            SubSolution subSolution = new SubSolution();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(subSolution);
            objectOutputStream.close();

        } catch (NotSerializableException e) {
            System.out.println("Serialization is forbidden: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[0]);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            SubSolution subSolution = (SubSolution) objectInputStream.readObject();
            objectInputStream.close();

        } catch (NotSerializableException e) {
            System.out.println("Deserialization is forbidden: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
