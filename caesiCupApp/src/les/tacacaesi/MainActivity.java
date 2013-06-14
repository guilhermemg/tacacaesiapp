package les.tacacaesi;

import java.util.Currency;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	public static final String CHAMPIONSHIP_EXTRA = "new_championship";
	public static final String REPLACE_POSITION_EXTRA = "replace_position";
	public static final int REPLACE_NONE = -1;
	
	private static final int REQUEST_NEW = 0, REQUEST_EDIT = 1;
	
	private Button newButton, editButton;
	
	private TacaCaesi taca;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_layout);
		
		newButton = (Button)findViewById(R.id.newButton);
		editButton = (Button)findViewById(R.id.editButton);
		
		taca = new TacaCaesi();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			Championship cs = (Championship)data.getSerializableExtra(CHAMPIONSHIP_EXTRA);
			
			if (cs != null) {
				int replace_position = data.getIntExtra(REPLACE_POSITION_EXTRA, REPLACE_NONE);
				
				if (replace_position == REPLACE_NONE) {
					taca.getChampionships().clear();
					taca.getChampionships().add(cs);
					
					editButton.setEnabled(true);
				} else {
					taca.getChampionships().set(replace_position, cs);
				}
			}
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	public void newClicked(View button) {
		Intent intent = new Intent(this, NewChampionshipActivity.class);
		startActivityForResult(intent, REQUEST_NEW);
	}
	
	public void editClicked(View button) {
		Intent intent = new Intent(this, EditChampionshipActivity.class);
		
		intent.putExtra(CHAMPIONSHIP_EXTRA, taca.getChampionships().get(0));
		intent.putExtra(REPLACE_POSITION_EXTRA, 0);
		
		startActivityForResult(intent, REQUEST_EDIT);
	}
}
