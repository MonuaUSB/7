package task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Requirements:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все символы из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ввведите имя файлов: ");
        String fileName = br.readLine();
        String fileName2 = br.readLine();
        br.close();
        try (FileReader fr = new FileReader(fileName);
             FileWriter fw = new FileWriter(fileName2)) {

            int character;
            int index = 1;

            while ((character = fr.read()) != -1) {
                if (index % 2 == 0) {
                    fw.write(character);
                }
                index++;
        }
    }
 }
}
