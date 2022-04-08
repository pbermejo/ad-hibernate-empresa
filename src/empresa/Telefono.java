package empresa;

public class Telefono {

	private int NumTelefono;
	private String Descricion;
	
	public Telefono(int numTelefono) {
		NumTelefono = numTelefono;
	}
	
	public Telefono(int numTelefono, String descricion) {
		NumTelefono = numTelefono;
		Descricion = descricion;
	}

	public int getNumTelefono() {
		return NumTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		NumTelefono = numTelefono;
	}

	public String getDescricion() {
		return Descricion;
	}

	public void setDescricion(String descricion) {
		Descricion = descricion;
	}
}
