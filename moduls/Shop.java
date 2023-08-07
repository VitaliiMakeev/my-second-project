package org.example.moduls;

public class Shop {
    private int idToys;

    public Shop(){
        this.idToys = 1;
    }

    public int getIdToys() {
        return idToys;
    }

    public void setIdToys() {
        this.idToys++;
    }
}
