package org.example.moduls;

import java.io.IOException;

public class NoFolder extends IOException {
    public NoFolder(){
        super("Папки 'data' небыло, я ее уже создал, повторите операцию.");
    }
}
