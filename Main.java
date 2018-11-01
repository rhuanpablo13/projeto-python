
public class Main {


	private static Tabuleiro tabuleiro;


	public static void main(String[] args) {

		tabuleiro = new Tabuleiro(10);
		boolean f = false;

		printTabuleiro(tabuleiro.getMapBombs());
		System.out.println("\n\n");
		do {

			if (tabuleiro.getNrBombas() == 0) {
				System.out.println("Parabéns! Você venceu!");
				return;
			}
			printTabuleiro(tabuleiro.getTabuleiro());
			System.out.println("----------------------------------------------");
			System.out.println("\t\t\tNúmero de bombas: " + tabuleiro.getNrBombas() + "\n");

			f = UserInterface();

		} while(f);

	}



	private static void printTabuleiro(String[][] tabuleiro) {

		System.out.print("   ");
		for (int i = 0; i < tabuleiro.length; i++) {
			System.out.print(i + "   ");
		}
		System.out.println();

		for (int i = 0; i < tabuleiro.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < tabuleiro.length; j++) {
				System.out.print(tabuleiro[i][j] + " ");
			}
			System.out.println();
		}
	}


	public static boolean UserInterface( ) {
		System.out.println("Pisar[1] ou Marcar[2] ?");
		int a = Inputs.getInt(1, 2);
		if (a == 1) {
			//pisa
			int[] coordenadas = Inputs.getCordenadas();
			if (tabuleiro.isBranco(coordenadas)) {
				System.out.println("\n\nEste local já foi verificado! Escolha outro...");
				return true;
			}

			if (tabuleiro.acertouBomba(coordenadas)) {
				System.err.println("--------------------------------");
				System.err.println("Você pisou em uma bomba! Perdeu!");
				System.err.println("--------------------------------");
				return false;
			} else {
				System.out.println("\n\nVocê pisou em um local seguro! Prossiga...");
				tabuleiro.setLocalTabuleiroBranco(coordenadas);
				return true;
			}

		} else {
			//marcar
			int[] coordenadas = Inputs.getCordenadas();
			if (tabuleiro.isBranco(coordenadas)) {
				System.err.println("\n\nEste local não pode ser marcado! Escolha outro...");
				return true;
			}

			if (tabuleiro.isMarcado(coordenadas)) {
				System.err.println("\nEste local já foi marcado! Escolha outro...");
				return true;
			}

			if (tabuleiro.acertouBomba(coordenadas)) {
				tabuleiro.setLocalTabuleiroBomba(coordenadas);
				System.out.println("\n\nBomba encontrada! Parabéns.");
				tabuleiro.subtraiNrBombas();
				return true;
			} else {
				System.out.println("\n\n");
				tabuleiro.setLocalTabuleiroMarcado(coordenadas);
				return true;
			}
		}

	}






}
