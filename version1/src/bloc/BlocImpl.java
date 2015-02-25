package bloc;

public class BlocImpl implements BlocService{

	private Tresor tresor;
	private bloc.Type type;
		
	public BlocImpl(){}
	
	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public Tresor getTresor() {
		return this.tresor;
	}

	@Override
	public void init(Type type, Tresor tresor) {
		this.tresor = tresor;
		this.type = type;
	}

	@Override
	public void setTYPE(Type type) {
		this.type = type;
	}

	@Override
	public void setTresor(Tresor tresor) {
		this.tresor = tresor;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof BlocService)
		{
			BlocService b = (BlocService) o;
			if(this.getTresor() == b.getTresor() && 
					this.getType() == b.getType())
				return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		if(getType() == Type.VIDE) return "-";
		if(getType() == Type.FOSSE) return "_";
		return " ";
	}
}
