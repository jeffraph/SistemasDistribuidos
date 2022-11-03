import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {

	public static void main(String[] args) {
        try {
            IMult calc = new Mult();
            String objName = "rmi://localhost/Calc";

			LocateRegistry.createRegistry(1099);
            Naming.rebind(objName, calc);

            System.out.println("Servidor conectado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
