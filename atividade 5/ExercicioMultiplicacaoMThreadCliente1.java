import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ExercicioMultiplicacaoMThreadCliente1 {

    public static void main(String[] args) {
        String SERVER_IP = "127.0.0.1";
        int SERVER_PORT = 9090;

        Scanner scanner = new Scanner(System.in);

        try{
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            System.out.println("Digite um numero: ");
            int num = scanner.nextInt();


            output.writeInt(num);

            DataInputStream input = new DataInputStream(socket.getInputStream());

            int resultado = input.readInt();
            System.out.println("Resultado: " + resultado);

        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}