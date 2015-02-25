package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import gangster.GangsterService;

public class PVganster extends JPanel {
	GridBagConstraints gbc ;
	JProgressBar pbar ;
	ArrayList<JProgressBar> liste ;

	public PVganster(int Gmax, int largeur){
		super();
		setOpaque(false);
		liste = new ArrayList<JProgressBar>();
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = -1;
		gbc.insets = new Insets(0,0,0,0);

		for(int i=0 ; i<Gmax ; i++){
			pbar=new JProgressBar(0, 100);
			pbar.setPreferredSize(new Dimension(3*largeur/8, 10));
			pbar.setBackground(Color.RED);
			pbar.setForeground(Color.GREEN);
			pbar.setBorderPainted(false);
			liste.add(pbar);
		}
		affichage();
	}
	public void affichage(){
		for(int i=0; i< liste.size(); i++){
			gbc.gridx=i%6;
			gbc.insets = new Insets(10,10,0,0);
			if(gbc.gridx==0){
				gbc.gridy+=1;
				gbc.insets = new Insets(10,25,0,0);
			}
			liste.get(i).setVisible(false);;
			add(liste.get(i),gbc);
		}
	}
	public void affichage(ArrayList<GangsterService> l){
		for(int i=0; i< l.size(); i++){
			liste.get(i).setMaximum(l.get(i).pvMax());
			liste.get(i).setVisible(true);
			liste.get(i).setValue(l.get(i).pointsDeVie());
		}
		for(int j=l.size() ; j <liste.size(); j++){
			liste.get(j).setVisible(false);
		}
	}
}
