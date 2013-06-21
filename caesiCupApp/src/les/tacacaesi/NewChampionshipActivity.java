package les.tacacaesi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewChampionshipActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_champion_ship);
	}
	
	public void cancelClicked(View button) {
		setResult(RESULT_CANCELED);
		finish();
	}
	
	public void createClicked(View button) {
		String name = ((EditText)findViewById(R.id.nameEdit)).getText().toString();
		int ncontestants = Integer.parseInt(((EditText)findViewById(R.id.manyContestantsEdit)).getText().toString());
		Championship cs = new Championship(name, ncontestants);
		
		Intent data = new Intent();
		data.putExtra(MainActivity.CHAMPIONSHIP_EXTRA, cs);
		setResult(RESULT_OK, data);
		finish();
	}

}
