import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Mult extends UnicastRemoteObject implements IMult {

    public Mult() throws RemoteException {
    }

    @Override
    public int multiplicaPorDois(int x) throws RemoteException {
        return x * 2;
    }

    @Override
    public int multiplicaPorTres(int x) throws RemoteException {
        return x * 3;
    }

    @Override
    public int multiplicaPorQuatro(int x) throws RemoteException {
        return x * 4;
    }
}