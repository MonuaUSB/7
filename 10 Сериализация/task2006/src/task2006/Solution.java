package task2006;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Как сериализовать?
Сделай так, чтобы сериализация класса Human была возможной.


Requirements:
1. Класс Human должен существовать внутри класса Solution.
2. Класс Human должен быть статическим.
3. Класс Human должен быть публичным.
4. Класс Human должен поддерживать интерфейс Serializable.*/

public class Solution {
    public static class Human implements Serializable{
        public String name;
        public List<String> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, String... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) {
        try{
        Human Ivanov = new Human("Ivan","home", "car");

        FileOutputStream fil = new FileOutputStream("Human.ser");
        ObjectOutputStream out = new ObjectOutputStream(fil);
        out.writeObject(Ivanov);
        out.close();

        FileInputStream fil2 = new FileInputStream("Human.ser");
        ObjectInputStream in = new ObjectInputStream(fil2);
        Human dezz = (Human) in.readObject();
        in.close();

        System.out.println("Name"+dezz.name);
        System.out.println("Assets"+dezz.assets);}
        catch (Exception e){
            e.printStackTrace();
        }



    }
}
