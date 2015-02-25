package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class PanelTerrain extends JPanel {
	private GridBagConstraints gbc ;
	private Case tab[][];
	private int x,y ;
	int t=0;

	public PanelTerrain(int x, int Y){
		this.x = x ;
		this.y = Y+2 ;
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0,0,0);
		tab = new Case[x][y];
		int num ;
		for(int i=0 ; i<y ; i++){
			gbc.gridy = i+1;
			if(i<5){num=(6*i)+1;}
			else{num=25;}

			for(int j=0 ; j<x ; j++){

				gbc.gridx = j;
				if(i<5){
					tab[j][i]= new Case(new Dimension(150,100), "JPEG/fond_"+num+".jpg");
					add(tab[j][i], gbc);
					num++;
					if(num == (6*i)+7){num=(6*i)+1;}
				}
				else{
					tab[j][i]= new Case(new Dimension(150,100), "JPEG/fond_"+num+".jpg");
					add(tab[j][i], gbc);
					num++;
					if(num == 31){num=25;}
				}
			}
		}
	}

	public Case getCase(int x , int y ){
		Case A ;
		try{
			A = tab[x][y+2];
		} catch(Exception e){
			A=new Case(new Dimension(150,100), "JPEG/fond_1.jpg");
		}
		return A; //limite terrain zone verte
	}

	public void Update(){
		for(int i=0 ; i<x ; i++){
			for(int j=0 ; j<y ; j++){
				tab[i][j].UpdateG();
				}
			}
		updateUI();
	}
}


