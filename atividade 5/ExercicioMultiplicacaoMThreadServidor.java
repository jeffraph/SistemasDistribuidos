import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExercicioMultiplicacaoMThreadServidor {

    private static ExecutorService pool = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {

        try{

            ServerSocket serverSocket = new ServerSocket(9090);

            while(true){
                Socket socket = serverSocket.accept();
                try{
                    DataInputStream  input = new DataInputStream(socket.getInputStream());

                    Integer num = input.readInt();

                    Integer resultado = ( num * 2 );
                    DataOutputStream out =
                            new DataOutputStream(socket.getOutputStream());
                    out.writeInt(resultado);

                }catch(SocketTimeoutException s) {

                    System.out.println("TIMEOUT!");
                    break;

                }catch(IOException e) {

                    e.printStackTrace();
                    break;
                }
            }

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}