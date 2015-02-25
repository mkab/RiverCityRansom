package terrain;

import error.InvariantError;
import error.PostconditionError;
import error.PreconditionError;
import bloc.BlocService;
import bloc.Type;

public class TerrainContract extends TerrainDecorator{

	public TerrainContract(TerrainService terrain) {
		super(terrain);
	}

	/* Check Invariant */
	protected void checkInvariant() {
			//\Inv : getNombreColonne(T) > 0 
			if(largeur() <=0)
				throw new InvariantError("La largeur du Terrain doit être supérieur à 0");
			//\Inv : getNombreLigne(T) > 0 
			if(hauteur() <=0)
				throw new InvariantError("Lla hauteur du Terrain doit être supérieur à 0");
						
			//\Inv : getBloc(T,1,1) = BLOC::VIDE
			if(getBloc(0, hauteur()-1).getType() != Type.VIDE)
				throw new InvariantError("La position initiale de Alex doit être à vide");
			if(getBloc(0, hauteur()-3).getType() != Type.VIDE)
				throw new InvariantError("La position initiale de Ryan doit être à vide");
			
			//\Inv : getBloc(T,getColonne(T)-2,getLigne(T)-2) = BLOC::VIDE
			if(getBloc(largeur()-1, hauteur()-2).getType() != Type.VIDE)
				throw new InvariantError("la position initiale de Slick doit être à vide");
			
		}

	

	public BlocService getBloc(int x, int y){
		//\pre  : 0 <= y < largeur(T) and 0 <=y < hauteur(T)
		if(!( 0 <= x && x<largeur() && 0<=y && y<hauteur()))
		{
			throw new PreconditionError("les coordonnees se trouve a l'exterieur du terrain " + x + " " + y);
		}
		return super.getBloc(x, y);
	}

	/* Initializer */

	public void init(int X, int Y) {
		//\pre  : init(x,y) require x > 0 and y > 0 and 
		//					        x mod 2 = 1 and y mod 2 = 1(x et y doivent �tre impaire)	
		if(X<=0 || Y<=0)
			throw new PreconditionError("Le terrain doit avoir une taille (X*Y) > 0");
		

		super.init(X, Y);
		//check Invariant
		checkInvariant();
		//\post : largeur(init(x,y)) = X
		if(largeur() != X)
			throw new PostconditionError("Initialisation de la longueur Col incorrecte");
		//\post : getNombreLigne(init(x,y)) = Y
		if(hauteur() != Y)
			throw new PostconditionError("Initialisation de la longueur Lig incorrecte");
		//\post : Pour Tout Bloc du Terrain : getBloc(init(X,Y),x,y) != null
		for(int i = 0; i < largeur();  i++){
			for(int j = 0; j < hauteur(); j++){
				if(getBloc(i, j) == null)
					throw new PostconditionError("Bloc ("+ i + ',' + ") null");
			}
		}
		//\post : BLOC::getType(getBloc(init(X,Y),1,1)) = BLOC::VIDE
		if(getBloc(0, hauteur()-1).getType() != Type.VIDE)
			throw new PostconditionError("Position initiale du perso non vide");
		//\post : BLOC::getType(getBloc(init(f),hauteurs(init(x,y))-2,largeur(init(x,y))-2)) = BLOC::VIDE		
		if(getBloc(largeur()-1, hauteur()-2).getType() != Type.VIDE)
			throw new PostconditionError("Position initiale du mechant non vide");
		
	}


	/* Operateur */
	public void setBloc(BlocService bloc, int x, int y){
		//\pre  : 0 <= x < largeur(T) and 0 <= hauteur(T) anD bloc != null
		if(!(0 <= x && x < largeur() &&
				0 <= y && y < hauteur() &&
				bloc != null))
			throw new PreconditionError("le bloc ne doit pas etre  null et la position doit etre dans " +
					"le terrain");

		//Pre-Invariant
		checkInvariant();

		//Traitement
		super.setBloc(bloc, x, y);

		//Post-Invariant
		checkInvariant();

		//\post : getBloc(setBloc(B,x,y),x,y) = B
		if(!getBloc(x, y).equals(bloc))
			throw new PostconditionError("Erreur modification du bloc");
	}
}