// Uvozimo razred za delo z vrsto (buffer) iz paketa za delo z vhodno-izhodnimi operacijami
// import java.io.BufferedReader;
import java.io.*;
import java.util.*;

/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Domen Gorišek
 * @version Primer 15b - Hello World v Javi
 */
public class HelloWorld {
	
	/**
	 * Statični atribut/lastnost za branje vhoda iz konzole (tipkovnice)
	 */
	private static BufferedReader in;
	
	/**
	 * Deklariramo seznam objektov tipa PivskaSteklenica - kot lastnost/atribut razreda HelloWorld
	 */
	private static ArrayList<PivskaSteklenica> pivskeSteklenice;
	
	/**
	 * Glavna metoda programa. Zažene se vedno ob zagonu.
	 *
	 * @param args Seznam argumentov iz ukazne vrtice
	 */
	public static void main(String[] args) {
		
		// Izpišemo pozdrav v konzolo
		System.out.println("Pozdravljen, Svet!");
		
		// Inicializiramo objekt in za zajem podatkov iz tipkovnice preko konzole
		in = new BufferedReader(new InputStreamReader(System.in));
		
		// Inicializiramo seznam pivskih steklenice
		pivskeSteklenice = new ArrayList<>();
		
		// Deklariramo in inicializiramo lastnosti steklenice
		String znamkaPiva = "";
		int velikostSteklenice = 500;
		double temperaturaSteklenice = 5.0;
		
		// Poskusimo prebrati iz ukazne konzole
		try {
			// Vnos podatkov o pivski steklenici - znamka
			System.out.print("Vnesti znamko piva: ");
			znamkaPiva = in.readLine();
			
			// Preverimo, ali je vnešena vrednost ENAKA (in ne ISTA) kot "n"
			System.out.print("Je pivo veliko (d/n)?");
			if(in.readLine().equals("n")); {
				velikostSteklenice = 330;
			}
			
			// Vnos podatkov o pivski steklenici - temperatura
			System.out.print("Vnesti temperaturo piva: ");
			temperaturaSteklenice = Double.parseDouble(in.readLine());
			
		}
		// Lovljenje in obravnava izjem pri branju vrstice
		catch(Exception e) {
			System.out.println("Napaka pri branju podatkov o steklenici piva: " + e);
		}
		
		// Ustvarimo objekt tipa Steklenica
		Steklenica PlastenkaVode = new Steklenica(500, "Voda");
		
		// Ustvarimo objekt tipa PivskaSteklenica, glede na vnešene podatke
		PivskaSteklenica mojePivo = new PivskaSteklenica(velikostSteklenice, znamkaPiva, temperaturaSteklenice);
		
		// Objekt dodamo v seznam
		pivskeSteklenice.add(mojePivo);
		
		// V seznam dodamo še nekaj anonimnih objektov
		pivskeSteklenice.add(new PivskaSteklenica(500, "Laško", 8.0));
		pivskeSteklenice.add(new PivskaSteklenica(500, "Laško", 8.0));
		pivskeSteklenice.add(new PivskaSteklenica(500, "Union", 8.0));
		
		// Izpišemo število steklenic na seznam
		System.out.println("V seznamu je " + pivskeSteklenice.size() + " steklenic.");
		
		// Odpremo vse steklenice na seznamu
		for(int c=0; c<pivskeSteklenice.size(); c++) {
			
			// Odpremo trenutno pivsko steklenico
			pivskeSteklenice.get(c).odpri();
		}
		
		// Izpijemo požirek piva
		try {
			System.out.println("Po prvem požirku je v steklenici še " + mojePivo.izprazni(50) + "ml");
		}
		catch(Exception e) {
			System.out.println("Izjema pri praznenju steklenice: " + e);
			
		}
		
		mojePivo.odpri();
		
		try {
			System.out.println("Po prvem požirku je v steklenici še " + mojePivo.izprazni(50) + "ml");
			
			// Izpijemo požirek vode
			PlastenkaVode.odpri();
			System.out.println("Po požirku vode je v plastenki še " + PlastenkaVode.izprazni(30) + "ml");
			
		}
		catch(Exception e) {
			System.out.println("Izjema pri praznenju steklenice: " + e);
			
		}
	}
}