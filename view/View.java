package org.example.view;

import org.example.controller.Controller;
import org.example.moduls.NoFolder;
import org.example.moduls.SaveData;
import org.example.moduls.Shop;
import org.example.moduls.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class View {



    public void start() throws NoFolder {
        Shop shop = new Shop();
        List<Toy> toyList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать!" + "\n" + "Администратирование игравого автомата.");
        System.out.println("Давайте для начала загрузим игрушек в автомат!");
        System.out.println("Для прекращения загрузки введите 0 (ноль).");
        boolean flag = true;
        while (flag){
            System.out.println("Введите название " + (toyList.size() + 1) + " игрушки и частоту выпадения: ");
            String toy = scanner.nextLine();
            if (toy.trim().charAt(0) == '0'){
                break;
            }
            List<String> strList = List.of(toy.split(" "));
            try{
                int n = Integer.parseInt(strList.get(1));
                String name = strList.get(0).trim();
                toyList.add(new Toy(shop, name, n));
            } catch (RuntimeException ex) {
                System.out.println("Попробуйте еще раз!");
            } catch (Exception e){
                System.out.println("Необходимо ввести целое число!(1 - 9)");
            }

        }
        Controller controller = new Controller(toyList);
        System.out.println("В таком порядке выпали бы игрушки 10 раз!");
        Queue<Toy> queue = controller.get(10);
        controller.printQueue(queue);
        SaveData saveData = new SaveData();
        String res = saveData.saveData(queue);
        System.out.println("Готово!");

    }

}
