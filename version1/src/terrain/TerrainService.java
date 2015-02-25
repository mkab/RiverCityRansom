package terrain;

import bloc.BlocService;

public interface TerrainService {

	public int largeur();
	public int hauteur();
	public int profondeur();
	public BlocService getBloc(int x , int y) ;
	public void init(int SizeCol, int SizeLig) ;
	void setBloc(BlocService bloc, int x, int y);
}
