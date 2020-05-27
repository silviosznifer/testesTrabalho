package br.com.bb.telegram;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws UnirestException, InterruptedException {
        TelegramBot tb = new TelegramBot("940760239:AAGLN7gk1F_3YNhCUBMh72I4ohdi2jKkF8E");
        TelegramAtivo tAtivo = new TelegramAtivo("940760239:AAGLN7gk1F_3YNhCUBMh72I4ohdi2jKkF8E");
        Thread t = new Thread(tAtivo);
        try {
        	t.start();
            tb.run();
        } catch (UnirestException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
