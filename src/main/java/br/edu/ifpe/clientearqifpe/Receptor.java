package br.edu.ifpe.clientearqifpe;

import java.io.InputStream;
import java.util.Scanner;

public class Receptor implements Runnable {

    private InputStream servidor;

    public Receptor(InputStream servidor) {
        this.servidor = servidor;
    }

    public void run() {
        Scanner s = new Scanner(this.servidor);
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());

        }
    }
}
