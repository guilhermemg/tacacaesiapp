package les.tacacaesi;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class TacaCaesiAdapter extends ArrayAdapter<Championship> {

	private TacaCaesiController controller;
	
	public TacaCaesiAdapter(Context context, TacaCaesiController controller) {
		super(context, R.layout.championship_item, R.id.nameText, controller.getTaca().getChampionships());
		this.controller = controller;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View result = super.getView(position, convertView, parent);
		Button editButton = (Button)result.findViewById(R.id.editButton);
		Button removeButton = (Button)result.findViewById(R.id.removeButton);
		
		editButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				controller.editClicked(position);
			}
		});
		removeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				controller.removeClicked(position);
			}
		});
		
		return result;
	}
}
