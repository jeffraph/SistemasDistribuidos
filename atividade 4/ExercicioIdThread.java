public class ExercicioIdThread extends Thread{
    public void run() {
        System.out.println(
                "ID da Thread: " + Thread.currentThread().getId());
    }
    public static void main(String[] args) {
        ExercicioIdThread primeiraThread = new ExercicioIdThread();
        ExercicioIdThread segundaThread = new ExercicioIdThread();

        primeiraThread.start();
        segundaThread.start();

    }
}

