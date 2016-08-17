package reflection;

public class Superheld {
	private final boolean MAENNLICH = true;
	private final boolean WEIBLICH = false;
	private boolean geschlecht;
	private String superKraft;
	private int alter;
	private String name;
	public int diesesAttributIstPublic;
	
	public Superheld(){}
	private Superheld(String superkraft){
		this.superKraft = superkraft;
	}
	public Superheld(String name, int alter, String superkraft){
		this.name = name; 
		this.alter = alter; 
		this.superKraft = superkraft;
	}
	public void setName(String s){
		name = s;
	}
	public String getName(){
		return name;
	}
	public void setAlter(int i){
		alter = i;
	}
	public int getAlter(){
		return alter;
	}
	public void setSuperkraft(String s){
		superKraft = s;
	}
	public String getSuperkraft(){
		return superKraft;
	}
	public void setMaennlich(){
		geschlecht = MAENNLICH;
	}
	public void setWeiblich(){
		geschlecht = WEIBLICH;
	}
	public String getGeschlecht(){
		if(geschlecht){
			return "Männlich";
		}else if(!geschlecht){
			return "Weiblich";
			
		}else{
			return "Neutral";
		}
	}
}
