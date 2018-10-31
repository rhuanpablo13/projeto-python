import java.util.Scanner;

public class Inputs {

	public static int[] getCordenadas() {
		System.out.println("Informe as cordenadas: ");
		System.out.println("Linha: ");
		int i = getInt();
		System.out.println("Coluna: ");
		int j = getInt();
		int a[] = new int[2];
		a[0] = i;
		a[1] = j;
		return a;
	}


	public static int getInt() {
		int i = -1;
		do {
			try {
				i = new Scanner(System.in).nextInt();
			} catch (Exception e) {
				System.err.println("Informe um número válido entre 0 e 8!");
			}
		} while(i < 0 || i > 8);
		return i;
	}
}
