package les.tacacaesi;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Championship implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int contestantsNumber;
	private boolean isFinalized;
	private String championName;
	private Set<Team> teams;

	public Championship(String name, int contestantsNumber) throws IllegalArgumentException {
		if (name == null || name.equals("")) {
			throw new IllegalArgumentException("Nome de Campeonato invalido");
		}
		if (contestantsNumber <= 0) {
			throw new IllegalArgumentException("Numero de participantes menor que o minimo necessario");
		}
		this.name = name;
		this.contestantsNumber = contestantsNumber;
		this.teams = new HashSet<Team>();
	}

	public String getName() {
		return name;
	}

	public String getChampionName() {
		return championName;
	}

	public int getContestantsCount() {
		return contestantsNumber;
	}

	public boolean isFinalized() {
		return isFinalized;
	}

	public void setChampionName(String championName) {
		this.championName = championName;
	}

	public void setContestantsCount(int contestantsNumber) {
		if (contestantsNumber >= 0)
			this.contestantsNumber = contestantsNumber;
	}

	public void setFinalized(boolean isFinalized) {
		if (!this.isFinalized)
			this.isFinalized = isFinalized;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + (isFinalized ? " (Finished)" : " (In progress)");
	}
	
	public void addTeam(String nome){
		
		this.teams.add(new Team(nome));
		
	}
	
	public Set<Team> getTeams(){
		return this.teams;
	}
	
}
