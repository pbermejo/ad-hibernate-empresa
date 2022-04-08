package empresa;

import java.util.Date;

public class Horas {
	private int Id;
	private Date Fecha;
	private int Horas;
	
	public Horas() {
	}

	public Horas(Date fecha) {
		Fecha = fecha;
	}

	public Horas(Date fecha, int horas) {
		Fecha = fecha;
		Horas = horas;
	}

	public Horas(int Id, Date fecha, int horas) {
		Id = Id;
		Fecha = fecha;
		Horas = horas;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public int getHoras() {
		return Horas;
	}

	public void setHoras(int horas) {
		Horas = horas;
	}
}
