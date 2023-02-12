import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String lin, maylin, host;
        int port;
        try {
            System.out.println("args 0: " + args[0] + "| args 1: " + args[1]);
            port = Integer.parseInt(args[1]);
            host = args[0];
        } catch (Exception e) {
            System.out.println("Como hubo problemas en parámetros, usamos el ip de docker");
            host = "172.19.0.2";
            port = 1234;
        }
        try {
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            Socket cliente = new Socket(host, port);
            DataOutputStream sale = new DataOutputStream(cliente.getOutputStream());
            BufferedReader entra = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));
            System.out.print("Ingrese su nombre: ");
            System.out.flush();
            lin = consola.readLine();
            while (!lin.equals(".")) {
                sale.writeBytes(lin + "\n");
                maylin = entra.readLine();
                System.out.println("Recibido: " + maylin);
                System.out.print("Ingrese su nombre:");
                System.out.flush();
                lin = consola.readLine();
            }
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}