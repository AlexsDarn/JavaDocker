import java.io.*;
import java.net.*;

public class Servidor{
    public static void main(String[] args) {
        String lin, maylin;
        try {
            int port = 1234;
            ServerSocket welcome = new ServerSocket(port);
            while (true) {
                System.out.println("Esperando solicitudes en puerto " + port);
                Socket conecta = welcome.accept(); // espera que alguien quiera conectarse
                System.out.println("Conectado a " + conecta.getInetAddress() + ":" + conecta.getPort());
                BufferedReader entra = new BufferedReader(
                        new InputStreamReader(conecta.getInputStream()));
                DataOutputStream sale = new DataOutputStream(conecta.getOutputStream());
                lin = entra.readLine();
                while (lin != null) {
                    System.out.println("Hola: " + lin);
                    maylin = lin.toUpperCase() + "\n";
                    sale.writeBytes(maylin);
                    lin = entra.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}