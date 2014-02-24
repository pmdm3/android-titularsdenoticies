package net.infobosccoma.titularsnoticies;

import net.infobosccoma.titularsnoticies.data.TitularConversor;
import net.infobosccoma.titularsnoticies.data.TitularsSQLiteHelper;
import net.infobosccoma.titularsnoticies.model.Titular;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TitularsActivity extends Activity implements OnItemClickListener {
	private TitularsAdapter adapter;
	//private Titular[] dades;
	private TitularsSQLiteHelper sqlite;
	private ListView llista;
	private TitularConversor titularsConv;
	private Cursor titulars;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_titulars);
		
		/*dades = new Titular[10];
		dades[0] = new Titular("El Barça no és líder", "Va perdre estrepitosament amb el València");
		dades[1]= new Titular("Aniol suspès", "Ha suspès per ser del Madrid");
		for(int i = 2; i < 10; i++) {
			dades[i] = new Titular("Titol " + (i+1), "Subtitol " + (i+1));
		}*/
		
		sqlite = new TitularsSQLiteHelper(this, "titularsDB.db", null, 1);
		SQLiteDatabase database = sqlite.getWritableDatabase();
		
		titularsConv = new TitularConversor(sqlite);
		llista = ((ListView)findViewById(R.id.listTitulars));
        // Si s'ha obert correctament la BD
		if(database != null) {
			// actualitzar la llista
			refreshData();
	    	// Tancar la base de dades
			database.close();
		} 
		
		
		//adapter = new TitularsAdapter(this, dades);
		
		
		//llista.setAdapter(adapter);
		llista.setOnItemClickListener(this);
	}

	private void refreshData() {
		titulars = titularsConv.getAll();
        adapter = new TitularsAdapter(this, titulars);  
        adapter.notifyDataSetChanged();
        llista.setAdapter(adapter);  
        /*if(titulars.getCount() == 0) {
        	lblNoData.setVisibility(lblNoData.VISIBLE);
        	llista.setVisibility(llista.INVISIBLE);
        }
        else {
        	lblNoData.setVisibility(lblNoData.INVISIBLE);
        	llista.setVisibility(llista.VISIBLE);
        }*/		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.titulars, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Dialeg dialeg = new Dialeg();

		dialeg.setMissatge(((Titular)adapter.getItem(position)).getTitol());
		
		dialeg.show(getFragmentManager(),"" );	
		
	}

}































