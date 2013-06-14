package les.tacacaesi;

import java.util.ArrayList;
import java.util.List;

public class TacaCaesi {
	private List<Championship> championships;
	
	public TacaCaesi() {
		this.championships = new ArrayList<Championship>();
	}
	
	public TacaCaesi(List<Championship> championships) {
		this.championships = championships;
	}

	public List<Championship> getChampionships() {
		return championships;
	}

	public void setChampionships(List<Championship> championships) {
		this.championships = championships;
	}
}
