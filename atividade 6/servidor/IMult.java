import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMult extends Remote {

    int multiplicaPorDois(int x) throws RemoteException;
    int multiplicaPorTres(int x) throws RemoteException;
    int multiplicaPorQuatro(int x) throws RemoteException;
}