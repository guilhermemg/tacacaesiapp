package les.tacacaesi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditChampionshipActivity extends Activity {
	private Championship championship;
	private int replaceIndex;
	private EditText nameEdit, manyContestantsEdit, winnerEdit;
	private Button finalizeButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_champion_ship);
		
		Intent intent = getIntent();
		
		championship = (Championship)intent.getSerializableExtra(MainActivity.CHAMPIONSHIP_EXTRA);
		replaceIndex = intent.getIntExtra(MainActivity.REPLACE_POSITION_EXTRA, MainActivity.REPLACE_NONE);
		
		if (championship == null || replaceIndex == MainActivity.REPLACE_NONE) {
			throw new IllegalArgumentException("EditChampionshipActivity called with the wrong intentions!!");
		}
		
		nameEdit = (EditText)findViewById(R.id.nameEdit);
		manyContestantsEdit = (EditText)findViewById(R.id.manyContestantsEdit);
		winnerEdit = (EditText)findViewById(R.id.winnerEdit);
		finalizeButton = (Button)findViewById(R.id.finalizeButton);
		
		nameEdit.setText(championship.getName());
		winnerEdit.setText(championship.getChampionName());
		manyContestantsEdit.setText(Integer.toString(championship.getContestantsCount()));
		
		updateEnableds();
	}
	
	public void finalizeClicked(View button) {
		championship.setFinalized(true);
		updateEnableds();
	}
	
	private void updateEnableds() {
		finalizeButton.setEnabled(!championship.isFinalized());
		nameEdit.setEnabled(!championship.isFinalized());
		winnerEdit.setEnabled(!championship.isFinalized());
		manyContestantsEdit.setEnabled(!championship.isFinalized());
	}
	
	private void updateChampionship() {
		championship.setName(nameEdit.getText().toString());
		championship.setChampionName(winnerEdit.getText().toString());
		championship.setContestantsCount(Integer.parseInt(manyContestantsEdit.getText().toString()));
	}
	
	public void saveClicked(View button) {
		Intent data = new Intent();
		
		updateChampionship();
		
		data.putExtra(MainActivity.CHAMPIONSHIP_EXTRA, championship);
		data.putExtra(MainActivity.REPLACE_POSITION_EXTRA, replaceIndex);
		
		setResult(RESULT_OK, data);
		finish();
	}
	
	public void cancelClicked(View button) {
		setResult(RESULT_CANCELED);
		finish();
	}
}
