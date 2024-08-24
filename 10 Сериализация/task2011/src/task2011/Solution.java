package task2011;

import java.io.*;
import java.util.Base64;

/* 
Externalizable для апартаментов
Реализуй интерфейс Externalizable в классе Apartment.


Requirements:
1. Класс Solution.Apartment должен поддерживать интерфейс Externalizable.
2. В классе Solution.Apartment должен быть реализован метод writeExternal с одним параметром типа ObjectOutput.
3. В классе Solution.Apartment должен быть реализован метод readExternal с одним параметром типа ObjectInput.
4. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeObject с параметром address.
5. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeInt с параметром year.
6. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля address.
7. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля year.*/

public class Solution {

    public static class Apartment implements Externalizable{

        private String address;
        private int year;

        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(encript(address));
            out.writeInt(year);
        }
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = decript(in.readObject().toString());
            year = in.readInt();
        }
        private String encript(String address){
            String encrypted = Base64.getEncoder().encodeToString(address.getBytes());
            System.out.println(encrypted);
            return encrypted;
        }
        private String decript(String encrypted){
            String decrypted = new String(Base64.getDecoder().decode(encrypted));
            System.out.println(decrypted);
            return decrypted;
        }
        public String getAddress() {
            return address;
        }
        public int getYear() {
            return year;
        }
    }

    public static void main(String[] args) {
        try {
            Apartment a = new Apartment("Moscow, Kremlin", 2011);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            a.writeExternal(objectOutputStream);
            objectOutputStream.flush();


            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Apartment deserializedApartment = new Apartment();
            deserializedApartment.readExternal(objectInputStream);

            System.out.println("Оригинальный: " + a);
            System.out.println("Десериализованный: " + deserializedApartment);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
