package net.infobosccoma.titularsnoticies;

import net.infobosccoma.titularsnoticies.model.Titular;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TitularsActivity extends Activity implements OnItemClickListener {
	private TitularsAdapter adapter;
	private Titular[] dades;
	private ListView llista;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_titulars);
		
		dades = new Titular[10];
		dades[0] = new Titular("El Barça no és líder", "Va perdre estrepitosament amb el València");
		dades[1]= new Titular("Aniol suspès", "Ha suspès per ser del Madrid");
		for(int i = 2; i < 10; i++) {
			dades[i] = new Titular("Titol " + (i+1), "Subtitol " + (i+1));
		}
		
		adapter = new TitularsAdapter(this, dades);
		
		llista = ((ListView)findViewById(R.id.listTitulars));
		llista.setAdapter(adapter);
		llista.setOnItemClickListener(this);
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































