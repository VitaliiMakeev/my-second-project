package org.example.moduls;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

import static java.nio.file.StandardOpenOption.APPEND;

public class SaveData {
    public String saveData(Queue<Toy> queue) throws NoFolder {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String path = "C:\\ProjectsJava\\finalBlock1\\src\\main" +
                "\\java\\org\\example\\data\\" + dateFormat.format(date) + ".txt";
        if (!checkFile(path)){
            File f = new File(path);
            try{
                f.createNewFile();
            } catch (IOException e){
                new File("C:\\ProjectsJava\\finalBlock1\\src\\main" +
                        "\\java\\org\\example\\data").mkdirs();
                throw new NoFolder();
            }
            if (f.exists()){
                try {
                    for (Toy toy : queue) {
                        String str = toy.toString() + "\n";
                        Files.write(Paths.get(path), str.getBytes(), APPEND);
                    }
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        } else {
            try {
                for (Toy toy : queue) {
                    String str = toy.toString() + "\n";
                    Files.write(Paths.get(path), str.getBytes(), APPEND);
                }
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return "Данные сохранены!";
    }


    private boolean checkFile(String nameFile) {
        File f = new File(nameFile);
        if (f.exists()){
            return true;
        }
        return false;
    }
}
