package championship;

public class Championship {
	
	
	private String name;
	private int contestantsNumber;
	private boolean isFinalized;
	private String championName;
	
	
	public Championship(String name, int contestantsNumber) throws Exception{
		if(name == null || name.equals("")){
			throw new Exception("Nome de Campeonato invalido");
		}
		if(contestantsNumber <= 0){
			throw new Exception("Numero de participantes menor que o minimo necessario");
		}
		this.name = name;
		this.contestantsNumber = contestantsNumber;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getChampionName() {
		return championName;
	}
	
	public int getContestants() {
		return contestantsNumber;
	}
	
	public boolean isFinalized() {
		return isFinalized;
	}
	
	public void setChampionName(String championName) {
		if(championName == null || championName.equals(""))
			this.championName = championName;
	}
	
	public void setContestants(int contestantsNumber) {
		if(contestantsNumber >= 0)
			this.contestantsNumber = contestantsNumber;
	}
	
	public void setFinalized(boolean isFinalized) {
		if(!this.isFinalized)
			this.isFinalized = isFinalized;
	}
	
	public void setName(String name) {
		if(name == null || name.equals(""))
			this.name = name;
	}
	
}
