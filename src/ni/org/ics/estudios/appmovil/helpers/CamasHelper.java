package ni.org.ics.estudios.appmovil.helpers;

import android.content.ContentValues;
import android.database.Cursor;
import ni.org.ics.estudios.appmovil.domain.encuestas.Cama;
import ni.org.ics.estudios.appmovil.domain.encuestas.PersonaCama;
import ni.org.ics.estudios.appmovil.utils.MainDBConstants;

/**
 * Created by Miguel Salinas on 5/10/2017.
 * V1.0
 */
public class CamasHelper {

    public static ContentValues crearCamaContentValues(Cama cama){
        ContentValues cv = new ContentValues();
        cv.put(MainDBConstants.codigoCama, cama.getCodigoCama());
        cv.put(MainDBConstants.habitacion, cama.getHabitacion().getCodigo());
        cv.put(MainDBConstants.estado, String.valueOf(cama.getEstado()));

        return cv;
    }

    public static Cama crearCama(Cursor cursor){
        Cama cama = new Cama();
        cama.setCodigoCama(cursor.getString(cursor.getColumnIndex(MainDBConstants.codigoCama)));
        cama.setHabitacion(null);
        cama.setEstado(cursor.getString(cursor.getColumnIndex(MainDBConstants.estado)).charAt(0));

        return cama;
    }

    public static ContentValues crearPersonaCamaContentValues(PersonaCama personaCama){
        ContentValues cv = new ContentValues();
        cv.put(MainDBConstants.codigoPersona, personaCama.getCodigoPersona());
        cv.put(MainDBConstants.cama, personaCama.getCama().getCodigoCama());
        cv.put(MainDBConstants.estaEnEstudio, String.valueOf(personaCama.getEstaEnEstudio()));
        cv.put(MainDBConstants.edad, personaCama.getEdad());
        cv.put(MainDBConstants.sexo, personaCama.getSexo());
        if (personaCama.getParticipante() != null) cv.put(MainDBConstants.participante, personaCama.getParticipante().getCodigo());
        cv.put(MainDBConstants.estado, String.valueOf(personaCama.getEstado()));

        return cv;
    }

    public static PersonaCama crearPersonaCama(Cursor cursor){
        PersonaCama personaCama = new PersonaCama();
        personaCama.setCodigoPersona(cursor.getString(cursor.getColumnIndex(MainDBConstants.codigoPersona)));
        personaCama.setCama(null);
        personaCama.setEstaEnEstudio(cursor.getString(cursor.getColumnIndex(MainDBConstants.estaEnEstudio)).charAt(0));
        if (cursor.getInt(cursor.getColumnIndex(MainDBConstants.edad)) > 0) personaCama.setEdad(cursor.getInt(cursor.getColumnIndex(MainDBConstants.edad)));
        personaCama.setSexo(cursor.getString(cursor.getColumnIndex(MainDBConstants.sexo)));
        personaCama.setParticipante(null);
        personaCama.setEstado(cursor.getString(cursor.getColumnIndex(MainDBConstants.estado)).charAt(0));

        return personaCama;
    }
}