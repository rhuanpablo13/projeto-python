import java.util.Random;

public class Tabuleiro {

	private String [][] tabuleiro;
	private String [][] mapBombs;
	private String defaultt = "[#]";
	private String empty    = "[ ]";
	private String bomb     = "[@]";
	private String flag     = "[?]";
	private int nrBombas;


	public Tabuleiro(int nrBombas) {
		tabuleiro = new String[9][9];
		mapBombs  = new String[9][9];
		this.nrBombas = nrBombas;
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

	public void setLocalTabuleiroBranco(int[] coordenadas) {
		tabuleiro[coordenadas[0]][coordenadas[1]] = empty;
	}

	public void setLocalTabuleiroMarcado(int[] coordenadas) {
		tabuleiro[coordenadas[0]][coordenadas[1]] = flag;
	}

	public void setLocalTabuleiroBomba(int[] coordenadas) {
		tabuleiro[coordenadas[0]][coordenadas[1]] = bomb;
	}

	public boolean isMarcado(int[] coordenadas) {
		if (tabuleiro[coordenadas[0]] [coordenadas[1]].equals(flag)) {
			return true;
		}
		return false;
	}

	public boolean isBranco(int[] coordenadas) {
		if (tabuleiro[coordenadas[0]] [coordenadas[1]].equals(empty)) {
			return true;
		}
		return false;
	}


	//inicializa o mapa das bombas
	private void setMapBombs() {
		for (int i = 0; i < nrBombas; i++) {
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
				mapBombs [i][j] = defaultt;
			}
		}
	}


	public String[][] getTabuleiro() {
		return tabuleiro;
	}


	public String[][] getMapBombs() {
		return mapBombs;
	}

	public int getNrBombas() {
		return this.nrBombas;
	}

	public void setNrBombas(int nrBombas) {
		this.nrBombas = nrBombas;
	}

	public void subtraiNrBombas() {
		this.nrBombas--;
	}

}
