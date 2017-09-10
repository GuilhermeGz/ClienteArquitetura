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

    public static void main(String[] args)
            throws IOException, UnknownHostException {

        Socket cliente = new Socket("127.0.0.1", 32154);
        System.out.println("O cliente se conectou ao servidor!");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Scanner teclado = new Scanner(cliente.getInputStream());
                    while (teclado.hasNextLine()) {
                        System.out.println(teclado.nextLine());
                    }

                    teclado.close();
                } catch (Exception e) {

                }
            }

        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    PrintStream saida = new PrintStream(cliente.getOutputStream());
                    Scanner teclado = new Scanner(System.in);

                    while (teclado.hasNextLine()) {
                        saida.println(teclado.nextLine());
                    }

                    saida.close();
                    teclado.close();
                } catch (Exception e) {

                }
            }
        });
        t2.start();

    }
}
