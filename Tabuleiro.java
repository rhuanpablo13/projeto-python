import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Tabuleiro {

	private String [][] tabuleiro;
	private String [][] mapBombs;
	private String defaultt = "[#]";
	private String empty   = "[ ]";
	private String bomb    = "[@]";
	private String flag    = "[?]";

	public Tabuleiro() {
		tabuleiro = new String[9][9];
		mapBombs  = new String[9][9];
		init();
	}

	private void init() {
		setTabuleiro();
		setMapBombs();
	}


	public boolean acertouBomba(int[] coordenadas) {
		if (mapBombs[coordenadas[0]] [coordenadas[1]].equals(bomb)) {
			return true;
		}
		return false;
	}






	//inicializa o mapa das bombas
	private void setMapBombs() {
		for (int i = 0; i < 9; i++) {
			Random r = new Random();
			int a = r.nextInt(9);
			int b = r.nextInt(9);
			mapBombs[a][b] = bomb;
		}
	}

	//Inicia o tabuleiro
	private void setTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = defaultt;
				mapBombs[i][j] = defaultt;
			}
		}
	}


	public String[][] getTabuleiro() {
		return tabuleiro;
	}


	public String[][] getMapBombs() {
		return mapBombs;
	}
}
