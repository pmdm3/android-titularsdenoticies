package net.infobosccoma.titularsnoticies.data;

import net.infobosccoma.titularsnoticies.model.Titular;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
 
/**
 * Classe conversora d'objectes Titular a BD
 * 
 * @author Marc Nicolau Reixach
 *
 */
public class TitularConversor {
 
	private TitularsSQLiteHelper helper;
 
	/**
	 * Consructor per defecte
	 */
	public TitularConversor() {
 
	}
 
	/**
	 * Constructor amb paràmetres
	 * @param helper l'ajudant de la BD de Titulars
	 */
	public TitularConversor(TitularsSQLiteHelper helper) {
		this.helper = helper;
	}
 
	/**
	 * Desa un nou titular a la taula
	 * @param titular l'objecte a desar
	 * @return l'id del nou titular desat
	 */
	public long save(Titular titular) {		
		long index = -1;
		// s'agafa l'objecte base de dades en mode escriptura
		SQLiteDatabase db = helper.getWritableDatabase();
		// es crea un objecte de diccionari (clau,valor) per indicar els valors a afegir 
		ContentValues dades = new ContentValues();
 
    	dades.put("titol", titular.getTitol());
    	dades.put("subtitol", titular.getSubtitol());
    	try {
    		index = db.insertOrThrow("Titulars", null, dades);
    		// volem veure en el log el que passa
    		Log.i("Titulars", dades.toString() + " afegit amb codi " + index);
    	}
    	catch(Exception e) {
    		// volem reflectir en ellog que hi ha hagut un error
    		Log.e("Titulars", e.getMessage());
    	}
    	return index;
	}	
 
	/**
	 * Retorna un cursor amb totes les dades de la taula
	 * @return
	 */
	public Cursor getAll() {
		SQLiteDatabase db = helper.getReadableDatabase();
 
		return db.query(true, "Titulars", 
						new String[]{"codi","titol","subtitol"}, 
						null, null, null, null, null, null);
	}
 
	/**
	 * Esborra el titular passat per paràmetre
	 * @param t el titular a esborrar
	 * @return la quantitat de titulars eliminats
	 */
	public boolean remove(Titular t) {		
		// obtenir l'objecte BD en mode esriptura
		SQLiteDatabase db = helper.getWritableDatabase();
 
		return db.delete("Titulars", "codi=?" ,new String[]{ t.getCodi()+"" }) > 0;
	}
	/**
	 * Esborra tots els titulars de la taula
	 * @return 
	 */
	public boolean removeAll() {		
		// obtenir l'objecte BD en mode escriptura
		SQLiteDatabase db = helper.getWritableDatabase();
 
		return db.delete("Titulars", null, null ) > 0;
	}
}