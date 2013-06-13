package les.tacacaesi;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class NewChampionshipActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_champion_ship);
	}
	
	public void cancelClicked(View button) {
		
	}
	
	public void createClicked(View button) {
		String name = ((EditText)findViewById(R.id.nameEdit)).getText().toString();
		
	}

}
