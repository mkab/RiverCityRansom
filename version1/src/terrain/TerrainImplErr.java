package terrain;

import java.util.Random;

import bloc.BlocContract;
import bloc.BlocImpl;
import bloc.BlocService;
import bloc.Tresor;
import bloc.Type;

public class TerrainImplErr implements TerrainService {

	BlocService terrain[][] = null;
	private int Y, X;


	public int largeur() {
		return X;
	}

	@Override
	public int hauteur() {
		return Y;
	}

	@Override
	public int profondeur() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void init(int x, int y) { 
		this.Y = y;
		this.X = x;
		terrain = new BlocService[X][Y];
		for(int i = 0; i < X;  i++){
			for(int j = 0; j < Y; j++){
				BlocService b =  new BlocContract(new BlocImpl());
				b.init(Type.FOSSE, Tresor.RIEN);
				terrain[i][j] = b;
			}
		}

		int nbFosse=y-2;
		
		Random rand = new Random();
		int X ;
		int Y ;
		for(int i=0; i<nbFosse;i++){
			do{
				X = rand.nextInt(x) ;
				Y = rand.nextInt(y) ;
				if(X==0){X=1;;}
				if(X==largeur()-1){X=largeur()-2;}
			}while(terrain[X][Y].getType()!=Type.VIDE);
			terrain[X][Y].setTYPE(Type.VIDE);
		}
		for(int i=0; i<3;i++){
			do{
				X = rand.nextInt(x) ;
				Y = rand.nextInt(y) ;
			}while(terrain[X][Y].getType()==Type.FOSSE || terrain[X][Y].getTresor()!=Tresor.RIEN);
			if(i==0)terrain[X][Y].setTresor(Tresor.BARRE);
			if(i==1)terrain[X][Y].setTresor(Tresor.CHAINE);
			if(i==2)terrain[X][Y].setTresor(Tresor.POUBELLE);
		}
		terrain[0][2].setTresor(Tresor.POUBELLE);
	}

	@Override
	public BlocService getBloc(int x, int y) {
		return terrain[y][y];
	}

	@Override
	public void setBloc(BlocService bloc, int x, int y) {
		terrain[x][x]=bloc;

	}
}