package net.infobosccoma.titularsnoticies;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;

public class Dialeg extends DialogFragment {
	
	private String missatge;
	
	public void setMissatge(String missatge) {
		this.missatge = missatge;  
	}
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// 1. Instanciar un AlertDialog.Builder amb el seu constructor
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		// 2. Indicar les característiques que volem que tingui el dialeg
		builder.setMessage(missatge).setTitle("Missatge");
		
		// afegir botó
		builder.setPositiveButton("OK", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(getActivity(), "HAS ESCOLLIT OK", Toast.LENGTH_SHORT).show();
			}
		});
		builder.setTitle("Escull els color que t'agradin");
		
		// 3. Obtenir el diàleg amb el mètode create()
		AlertDialog dialog = builder.create();
		
		return dialog;
	}

}
