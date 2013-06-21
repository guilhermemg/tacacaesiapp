package les.tacacaesi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class TeamInsert extends Activity {

	private static final int REQUEST_NEW = 0;
	private Championship championship;
	private EditText nameEdit;
	
	private int replaceIndex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team_insert);
		
		Intent intent = getIntent();

		championship = (Championship) intent
				.getSerializableExtra(MainActivity.CHAMPIONSHIP_EXTRA);
		replaceIndex = intent.getIntExtra(MainActivity.REPLACE_POSITION_EXTRA,
				MainActivity.REPLACE_NONE);
		
		nameEdit = (EditText) findViewById(R.id.editText1);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.team_insert, menu);
		return true;
	}
	
	public void cancelClicked(View button) {
		setResult(RESULT_CANCELED);
		finish();
	}
	
	private void updateChampionship() {
		if(championship != null)
			championship.addTeam(""
				/*nameEdit.getText().toString()*/);
	}
	
	public void newClicked(View button) {
		Intent data = new Intent();

		updateChampionship();

		data.putExtra(MainActivity.CHAMPIONSHIP_EXTRA, championship);
		data.putExtra(MainActivity.REPLACE_POSITION_EXTRA, replaceIndex);

		setResult(RESULT_OK, data);
		finish();
	}

}
