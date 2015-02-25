package terrain;

import bloc.BlocService;

public class TerrainDecorator implements TerrainService {

	private TerrainService delegate;

	public TerrainDecorator(TerrainService terrain){
		this.delegate = terrain;
	}

	@Override
	public void init(int SizeCol, int SizeLig) {
		this.delegate.init(SizeCol, SizeLig);
	}

	@Override
	public String toString(){
		return delegate.toString();
	}

	@Override
	public int largeur() {
		return this.delegate.largeur();
	}

	@Override
	public int hauteur() {
		return this.delegate.hauteur();
	}

	@Override
	public int profondeur() {
		return this.delegate.profondeur();
	}

	@Override
	public void setBloc(BlocService bloc, int x, int y){
		this.delegate.setBloc(bloc, x, y);
	}
	
	public BlocService getBloc(int x, int y) {
		return this.delegate.getBloc(x, y);
	}
}