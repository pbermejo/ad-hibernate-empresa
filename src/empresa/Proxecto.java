package empresa;
// Generated 2 feb 2022 17:40:51 by Hibernate Tools 5.5.7.Final

/**
 * Proxecto generated by hbm2java
 */
public class Proxecto implements java.io.Serializable {

	private int numProxecto;
	private String nomeProxecto;
	private String lugar;

	public Proxecto() {
	}

	public Proxecto(int numProxecto) {
		this.numProxecto = numProxecto;
	}

	public Proxecto(int numProxecto, String nomeProxecto, String lugar) {
		this.numProxecto = numProxecto;
		this.nomeProxecto = nomeProxecto;
		this.lugar = lugar;
	}

	public int getNumProxecto() {
		return this.numProxecto;
	}

	public void setNumProxecto(int numProxecto) {
		this.numProxecto = numProxecto;
	}

	public String getNomeProxecto() {
		return this.nomeProxecto;
	}

	public void setNomeProxecto(String nomeProxecto) {
		this.nomeProxecto = nomeProxecto;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

}
