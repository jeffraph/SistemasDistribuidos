import java.rmi.Naming;

public class ClienteRMI {

	public static void main(String[] args) throws Exception {
		String objName = "rmi://localhost:1099/Calc";
        IMult calc = (IMult) Naming.lookup(objName);

		System.out.println("O Resultado da multiplicacao é: " + calc.multiplicaPorDois(3));
		System.out.println("O Resultado da multiplicacao é: " + calc.multiplicaPorTres(3));
		System.out.println("O Resultado da multiplicacao é: " + calc.multiplicaPorQuatro(3));
	}
}