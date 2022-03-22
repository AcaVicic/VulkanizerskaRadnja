package auto_radnja.gume;

/**
 * Klasa koja predstavlja konkretan model auto gume. Auto guma ima marku i model
 * u obliku Stringa i dimenzije precnik, sirinu i visinu u obliku celih brojeva.
 * 
 * @author Aleksandar Vicic.
 * 
 * @version 1.0
 *
 */
public class AutoGuma {

	/**
	 * Marka i model auto gume kao String.
	 */
	private String markaModel = null;

	/**
	 * Precnik auto gume kao ceo broj.
	 */
	private int precnik = -1;

	/**
	 * Sirina auto gume kao ceo broj.
	 */
	private int sirina = -1;

	/**
	 * Visina auto gume kao ceo broj.
	 */
	private int visina = -1;

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public AutoGuma() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti atributa auto
	 * gume.
	 * 
	 * @param markaModel Marka i model auto gume kao String.
	 * @param precnik    Precnik auto gume kao ceo broj.
	 * @param sirina     Sirina auto gume kao ceo broj.
	 * @param visina     Visina auto gume kao ceo broj.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca marku i model auto gume.
	 * 
	 * @return Marka i model auto gume kao String.
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja atribut markaModel auto gume na novu vrednost.
	 * 
	 * @param markaModel Marka i model auto gume kao String.
	 * @throws java.lang.NullPointerException     ako je markaModel null.
	 * @throws java.lang.IllegalArgumentException ako markaModel sadrzi manje od 3
	 *                                            znaka.
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik auto gume.
	 * 
	 * @return Precnik auto gume kao ceo broj.
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja atribut precnik auto gume na novu vrednost.
	 * 
	 * @param precnik Precnik auto gume kao ceo broj.
	 * @throws java.lang.IllegalArgumentException ako je precnik van opsega.
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu auto gume.
	 * 
	 * @return Sirina auto gume kao ceo broj.
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja atribut sirina auto gume na novu vrednost.
	 * 
	 * @param sirina Sirina auto gume kao ceo broj.
	 * @throws java.lang.IllegalArgumentException ako je sirina van opsega.
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu auto gume.
	 * 
	 * @return Visina auto gume kao ceo broj.
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja atribut visina auto gume na novu vrednost.
	 * 
	 * @param visina Visina auto gume kao ceo broj.
	 * @throws java.lang.IllegalArgumentException ako je visina van opsega.
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * @return Vraca String sa svim podacima o auto gumi.
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve auto gume i vraca true ako su iste, a false ako nisu.
	 * 
	 * Auto gume se porede po svim atributima i moraju biti isti.
	 * 
	 * @return 
	 * <ul>
	 * 		<li>true ako su oba objekta klase AutoGuma i imaju iste sve parametre.</li>
	 * 		<li>false u svim ostalim slucajevima.</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}