package org.example.view;

import org.example.controller.Controller;
import org.example.moduls.Shop;
import org.example.moduls.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {



    public void start(){
        Shop shop = new Shop();
        List<Toy> toyList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать!" + "\n" + "Администратирование игравого автомата.");
        System.out.println("Давайте для начала загрузим игрушек в автомат!");
        boolean flag = true;
        while (flag){
            int tmp = 0;
            System.out.println("Введите название" + (i + 1) + "игрушки");
            String name = scanner.nextLine();
            System.out.println("Введите частоту выпадения игрушки " + name + ": ");
            try{
                int n = scanner.nextInt();
                toyList.add(new Toy(shop, name, n));
            } catch (NumberFormatException e){
                System.out.println("Необходимо ввести целое число!(1 - 9)");
                tmp++;
            } catch (RuntimeException ex) {
                System.out.println("Попробуйте еще раз!");
                tmp++;
            }
            if (tmp == 0 && toyList.size() == 3){
                flag = false;
            }
        }
        System.out.println(toyList);

    }

}
