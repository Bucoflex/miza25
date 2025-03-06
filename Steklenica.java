/**
 * Razred za prikaz modela steklenice, ki vsebuje tekočino
 *
 * @author Domen Gorišek
 * @version Primer 15b - Razred v Javi
 */
public class Steklenica {
	
	// Deklariramo lastnosti
	
	/**
	 * Kapaciteta steklenice v mililitrih
	 */
	private int kapaciteta;
	
	/**
	 * Stanje odprtosti steklenice
	 * true - odprta
	 * false - zaprta
	 */
	private boolean jeOdprta;
	
	/**
	 * Trenutna količina vsebine v ml
	 */
	private int kolicinaVsebine;
	
	/**
	 * Trenutna vrsta vsebine
	 */
	private String vrstaVsebine;
	
	/**
	 * Konstruktor za inicializacijo nove steklenice, ki je polna in zaprta
	 * Inicializira vse lastnosti
	 * @param k Kapaciteta steklenice (ml)
	 * @param v Vrsta vsebine steklenice
	 */
	public Steklenica(int k, String v) {
		
		// Inicializiramo vse lastnosti
		this.kapaciteta = k;
		this.jeOdprta = false;
		this.kolicinaVsebine = k;
		this.vrstaVsebine = v;
		
		// Izpišemo podatke o steklenici
		System.out.println("Ustvarjam steklenico " + v + " kapacitete " + k + " ml.");
	}
	
	/**
	 * Metoda, ki odpre steklenico - spremeni lastnost jeOdprta
	 * @return Uspešnost odpiranja
	 * true - prej je bila zaprta
	 * false - že prej je bila odprta
	 */
	public boolean odpri() {
		
		// Če je steklenica že odprta
		if(jeOdprta) {
			
			return false;
		}
		
		// Če steklenica še ni odprta
		else {
				
			// Odpre steklenico
			jeOdprta = true;
			System.out.println("Odpiram steklenico " + vrstaVsebine + ".");
			return true;
			
		}
	}
	
	/**
	 * Metoda, ki iz steklenice izprazni določeno količino vsebine
	 * @param k Količina vsebine, ki jo želimo izprazniti (ml)
	 * @return Kličina vsebine, ki je ostala v steklenici po praznenju
	 * @throws Exception če je steklenica zaprta, ko jo skušamo izprazniti
	 */
	
	public int izprazni(int k) throws Exception {
	
		// Če je steklenica odprta
		if(jeOdprta) {
			
			// Količino vsebine zmanjšamo za željeno količino
			System.out.println("Iz steklenice v kateri je " + kolicinaVsebine + " ml " + vrstaVsebine + " praznim "+ k + "ml.");
			kolicinaVsebine -= k;
			
			// Preverimo, če se je količina slučajno preveč zmanjšala
			if(kolicinaVsebine <= 0) {
				
				// Postavimo količino vsebine na 0
				kolicinaVsebine = 0;
				System.out.println("Steklenica " + vrstaVsebine + " je prazna.");
				
			}
		}
		
		// Če je steklenica zaprta
		else {
			
			// Vrže izjemo
			throw new Exception("Ne morem izprazniti steklenice, ker je zaprta.");
		}
		
		// Vrnemo količino vsebine po praznenju
		return kolicinaVsebine;
	}
}