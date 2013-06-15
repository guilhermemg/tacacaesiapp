package les.tacacaesi;

public interface TacaCaesiController {
	public void editClicked(int position);
	public void removeClicked(int position);
	public TacaCaesi getTaca();
	public TacaCaesiAdapter getTacaAdapter();
}
