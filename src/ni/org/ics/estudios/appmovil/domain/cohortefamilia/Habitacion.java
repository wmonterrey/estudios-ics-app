package ni.org.ics.estudios.appmovil.domain.cohortefamilia;

/**
 * Created by Miguel Salinas on 5/3/2017.
 * V1.0
 */
public class Habitacion extends AreaAmbiente {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantidadCamas;

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }
}