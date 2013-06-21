package les.tacacaesi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity implements TacaCaesiController {

	public static final String CHAMPIONSHIP_EXTRA = "new_championship";
	public static final String REPLACE_POSITION_EXTRA = "replace_position";
	public static final int REPLACE_NONE = -1;
	private static final int REQUEST_NEW = 0, REQUEST_EDIT = 1;
	
	private TacaCaesi taca;
	private TacaCaesiAdapter tacaAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_layout);
		
		taca = new TacaCaesi(this);
		tacaAdapter = new TacaCaesiAdapter(this, this);
		
		ListView listView = (ListView)findViewById(R.id.championshipList);
		listView.setAdapter(tacaAdapter);
	}
	
	public TacaCaesi getTaca() {
		return taca;
	}
	
	@Override
	public TacaCaesiAdapter getTacaAdapter() {
		return tacaAdapter;
	}
	
	@Override
	public void editClicked(int position) {
		Intent intent = new Intent(this, EditChampionshipActivity.class);
		
		intent.putExtra(CHAMPIONSHIP_EXTRA, taca.getChampionships().get(position));
		intent.putExtra(REPLACE_POSITION_EXTRA, position);
		
		startActivityForResult(intent, REQUEST_EDIT);
	}

	@Override
	public void removeClicked(int position) {
		taca.getChampionships().remove(position);
		tacaAdapter.notifyDataSetChanged();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			Championship cs = (Championship)data.getSerializableExtra(CHAMPIONSHIP_EXTRA);
			
			if (cs != null) {
				int replace_position = data.getIntExtra(REPLACE_POSITION_EXTRA, REPLACE_NONE);
				
				if (replace_position == REPLACE_NONE)
					taca.getChampionships().add(cs);	
				else
					taca.getChampionships().set(replace_position, cs);
				
				tacaAdapter.notifyDataSetChanged();
			}
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	public void newClicked(View button) {
		Intent intent = new Intent(this, NewChampionshipActivity.class);
		startActivityForResult(intent, REQUEST_NEW);
	}
}
