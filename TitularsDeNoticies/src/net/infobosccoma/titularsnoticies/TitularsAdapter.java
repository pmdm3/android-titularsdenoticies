package net.infobosccoma.titularsnoticies;

import net.infobosccoma.titularsnoticies.model.Titular;
import android.app.Activity;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Classe que implementa un adaptador de dades per un ListView
 * 
 * @author Marc Nicolau Reixach (marc.nicolau@gmail.com)
 * 
 */
public class TitularsAdapter extends BaseAdapter {
	private Activity context;
	private Cursor dades;

	/**
	 * Constructor
	 * 
	 * @param context
	 *            el context de l'aplicació
	 * @param dades
	 *            cursor amb les dades
	 */
	TitularsAdapter(Activity context, Cursor dades) {
		super();
		this.context = context;
		this.dades = dades;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View element = convertView;
		Vista vista;
		
		Titular t = getItem(position);

		if (element == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			element = inflater.inflate(R.layout.listitem_titular, null);

			vista = new Vista();
			vista.titol = (TextView) element.findViewById(R.id.txtViewTitol);
			vista.subtitol = (TextView) element
					.findViewById(R.id.txtViewSubtitol);

			element.setTag(vista);
		} else {
			vista = (Vista) element.getTag();
		}

		vista.titol.setText(t.getTitol());
		vista.subtitol.setText(t.getSubtitol());

		return element;
	}

	/**
	 * Sobreescriptura del mètode getCount que indica quantes dades gestiona
	 * l'adaptador.
	 */
	public int getCount() {
		return dades.getCount();
	}

	/**
	 * Sobreescriptura del mètode getItem que retorna l'objecte que ocupa la
	 * posició indicada amb el paràmetre.
	 */
	public Titular getItem(int pos) {
		Titular t = new Titular();
		if (dades.moveToPosition(pos)) {
			t.setCodi(dades.getInt(0));
			t.setTitol(dades.getString(1));
			t.setSubtitol(dades.getString(2));
		}
		return t;
	}

	/**
	 * Sobreescriptura del mètode getItemId que retorna l'id de l'objecte que
	 * ocupa la posició indicad amb el paràmetre.
	 */
	public long getItemId(int position) {
		return getItem(position).getCodi();
	}
}