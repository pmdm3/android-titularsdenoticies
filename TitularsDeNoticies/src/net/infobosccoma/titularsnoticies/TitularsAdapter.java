package net.infobosccoma.titularsnoticies;

import net.infobosccoma.titularsnoticies.model.Titular;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
/**
 * Adapter que implementa un ArrayAdapter de titulars de notícies
 * Està optimitzat per reutilitzar instàncies de vistes de layout
 * que ja no s'utilitzen
 * 
 * @author Marc Nicolau
 *
 */
public class TitularsAdapter extends ArrayAdapter<Titular> {

	// Classe que guarda les referències als elements de la vista
	class Vista {
		public TextView titol;
		public TextView subtitol;
	}

	private Titular[] dades;

	TitularsAdapter(Activity context, Titular[] dades) {
		super(context, R.layout.listitem_titular, dades);
		this.dades = dades;

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View element = convertView;
		Vista vista;

		if (element == null) {
			LayoutInflater inflater = ((Activity) getContext())
					.getLayoutInflater();
			element = inflater.inflate(R.layout.listitem_titular, null);

			vista = new Vista();
			vista.titol = (TextView) element.findViewById(R.id.txtViewTitol);
			vista.subtitol = (TextView) element.findViewById(R.id.txtViewSubtitol);

			element.setTag(vista);
		} else {
			vista = (Vista) element.getTag();
		}

		vista.titol.setText(dades[position].getTitol());
		vista.subtitol.setText(dades[position].getSubtitol());

		return element;
	}
}