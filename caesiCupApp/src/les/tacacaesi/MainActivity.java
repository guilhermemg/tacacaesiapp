package les.tacacaesi;

import java.util.Currency;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_layout);
	}

	public void newChampionshipClicked(View button) {
		Intent intent = new Intent(this, NewChampionshipActivity.class);
		startActivity(intent);
	}
}
