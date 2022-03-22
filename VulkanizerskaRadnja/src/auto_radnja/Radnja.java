package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja radnju sa auto gumama.
 * 
 * Ima operacije dodavanja auto gume u radnju i pretrage radnje.
 * 
 * @author Aleksandar Vicic
 * @version 1.0
 *
 */
public interface Radnja {
	
	/**
	 * Dodaje auto gumu u radnju.
	 * 
	 * Dodaje auto gumu u radnju samo ako auto guma vec ne postoji u radnji i ako nije null.
	 * 
	 * @param a auto guma koju treba dodati u radnju.
	 * @throws java.lang.NullPointerException ako je uneta auto guma null.
	 * @throws java.lang.IllegalArgumentException ako uneta auto guma vec postoji u radnji.
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Pronalazi i vraca listu sa svim auto gumama iz radnje koje imaju marku i model koji su isti kao prosledjeni parametar.
	 * 
	 * 
	 * @param markaModel Marka i model auto gume.
	 * 
	 * @return 
	 * <ul>
	 * 		<li>Lista koja sadrzi sve auto gume koji odgovaraju uslovima pretrage.</li>
	 * 		<li>null ako je parametar markaModel null</li>
	 * </ul>
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * Vraca sve auto gume iz radnje
	 *  
	 * @return Lista sa svim auto gumama iz radnje
	 */
	List<AutoGuma> vratiSveGume();
}
