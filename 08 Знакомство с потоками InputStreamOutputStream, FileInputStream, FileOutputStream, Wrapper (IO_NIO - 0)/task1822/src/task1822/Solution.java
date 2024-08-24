package task1822;

import java.io.*;

/* 
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.

Пример содержимого файла:
194 хлеб 12.6 25
195 масло сливочное 52.2 12
196 молоко 22.9 19

Пример вывода для id = 195:
195 масло сливочное 52.2 12


Requirements:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Напишите id с которым будем работать: ");
        int idia = Integer.parseInt(br.readLine());
        System.out.println("Напишите имя файла для поиска по заданному id="+idia);
        String filee = br.readLine();

        try{
            FileInputStream pyk = new FileInputStream(filee);
            BufferedReader fileered = new BufferedReader(new InputStreamReader(pyk));
            String stoki;
            while ((stoki=fileered.readLine())!=null){
                String[] data = stoki.split(" ",2);
                int id = Integer.parseInt(data[0]);
                if(id==idia){
                    System.out.println(stoki);
                    break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
