package br.osnir.teste;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (Config.DEBUG_ENABLE) {
			System.out.println("DEBUG ENABLED");
		}else{
			System.out.println("DEBUG DISABLED");
		}
	}
}
