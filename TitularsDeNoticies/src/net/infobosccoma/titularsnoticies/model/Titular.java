package net.infobosccoma.titularsnoticies.model;

public class Titular {
	private String titol;
	private String subtitol;

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
}
