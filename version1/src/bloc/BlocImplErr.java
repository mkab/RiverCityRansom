package bloc;

public class BlocImplErr implements BlocService {

  protected Tresor tresor;
  protected bloc.Type type;

  @Override
  public Type getType() {
    return null;
  }

  @Override
  public Tresor getTresor() {
    return null;
  }

  @Override
  public void init(Type type, Tresor tresor) {
    this.tresor = null;
    this.type = null;
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
  public boolean equals(Object o) {
    if (o instanceof BlocService) {
      BlocService b = (BlocService) o;
      if (this.getTresor() == b.getTresor() && this.getType() == b.getType())
        return true;
    }
    return false;
  }

  @Override
  public String toString() {
    if (getType() == Type.VIDE)
      return "-";
    if (getType() == Type.FOSSE)
      return "_";
    return " ";
  }
}
