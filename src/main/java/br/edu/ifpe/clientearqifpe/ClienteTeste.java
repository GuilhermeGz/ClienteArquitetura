package br.edu.ifpe.clientearqifpe;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class ClienteTeste {

    private String host;
    private int porta;

    ClienteTeste(String host, int porta) {
        this.host = host;
        this.porta = porta;

    }

    public static void main(String[] args)
            throws IOException, UnknownHostException {

        Socket cliente = new Socket("127.0.0.1", 32154);
        System.out.println("O cliente se conectou ao servidor!");

        Receptor r = new Receptor(cliente.getInputStream());
        new Thread(r).start();

        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
        cliente.close();
    }

}
