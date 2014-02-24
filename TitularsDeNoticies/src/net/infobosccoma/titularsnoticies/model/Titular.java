package net.infobosccoma.titularsnoticies.model;

public class Titular {
	private String titol;
	private String subtitol;
	private long codi;

	public Titular() {
		
	}
	public Titular(String tit, String sub) {
		setTitol(tit);
		setSubtitol(sub);
	}
	// setters i getters

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getSubtitol() {
		return subtitol;
	}

	public void setSubtitol(String subtitol) {
		this.subtitol = subtitol;
	}

	public long getCodi() {
		return codi;
	}

	public void setCodi(long codi) {
		this.codi = codi;
	}
}
