package les.tacacaesi;

import java.util.ArrayList;
import java.util.List;

public class TacaCaesi {
	private List<Championship> championships;
	private TacaCaesiController controller;
	
	public TacaCaesi(TacaCaesiController controller) {
		this.championships = new ArrayList<Championship>();
		this.controller = controller;
	}
	
	public TacaCaesi(List<Championship> championships) {
		this.championships = championships;
	}

	public List<Championship> getChampionships() {
		return championships;
	}
}
