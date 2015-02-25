package gestionCombat;

import moteurJeu.COMMANDE;
import error.InvariantError;
import error.PostconditionError;
import error.PreconditionError;

public class GestionCombatContrat extends GestionCombatDecorator{

	public GestionCombatContrat(GestionCombatService gcs){
		super(gcs);
	}


	public boolean estFrappe(String nom,int id){

		//\ pre estFrappe(nom,id) require nom = alex || nom = ryan || nom = slick || (nom = gangster && id >= 0)
		if(!   ( (nom.equals("alex")) || (nom.equals("ryan")) || (nom.equals("slick"))  || (nom.equals("gangster") && (id >=0))   )){
			throw new PreconditionError("estFrappe : Le nom du perso n'est pas correct ou bien le numero du gangster est négatif");
		}
		return super.estFrappe(nom, id);
	}


	public boolean estGele(String nom, int id){
		//\ pre estGele(nom,id) require nom = alex || nom = ryan || nom = slick || (nom = gangster && id >= 0)
		if(!   ( (nom.equals("alex")) || (nom.equals("ryan")) || (nom.equals("slick"))  || (nom.equals("gangster") && (id >=0))   )){
			throw new PreconditionError("estGele : Le nom du perso n'est pas correct ou bien le numero du gangster est négatif");
		}
		return super.estFrappe(nom, id);
	}

	public int positionX(String nom, int id){
		//\ pre positionX(nom,id) require nom = alex || nom = ryan || nom = slick || (nom = gangster && id >= 0)
		if(!   ( (nom.equals("alex")) || (nom.equals("ryan")) || (nom.equals("slick"))  || (nom.equals("gangster") && (id >=0))   )){
			throw new PreconditionError("positionX : Le nom du perso n'est pas correct ou bien le numero du gangster est négatif");
		}
		return super.positionX(nom, id);
	}

	public int positionY(String nom, int id){
		//\ pre positionY(nom,id) require nom = alex || nom = ryan || nom = slick || (nom = gangster && id >= 0)
		if(!   ( (nom.equals("alex")) || (nom.equals("ryan")) || (nom.equals("slick"))  || (nom.equals("gangster") && (id >=0))   )){
			throw new PreconditionError("positionY : Le nom du perso n'est pas correct ou bien le numero du gangster est négatif");
		}
		return super.positionX(nom, id);
	}

	public void init(int largeur,int hauteur,int profondeur){
		//\pre  init(largeur,hauteur,profondeur) require largeur>0
		if(!(largeur>0)){
			throw new PreconditionError("La largeur n'est pas correcte");
		}
		//\pre init(largeur,hauteur,profondeur) require hauteur>0
		if(!(hauteur>0)){
			throw new PreconditionError("La hauteur n'est pas correcte");
		}
		//\pre init(largeur,hauteur,profondeur) require profondeur>0
		if(!(profondeur>0)){
			throw new PreconditionError("La profondeur n'est pas correcte");
		}

		super.init(largeur, hauteur, profondeur);

		//\post : estFrappe(nom ,id) = false quelque soit le personnage
		if( (estFrappe("alex", 0))  || (estFrappe("ryan",0))){
			throw new PostconditionError("Un personnage ne peut etre frappé au début");
		}
		for(int i=0;i<nombreGangsters();i++){
			if(estFrappe("gangster", 0)){
				throw new PostconditionError("Un gangster ne peut etre frappe en début de partie");
			}
		}


		//\post : estGele(nom ,id) = false quelque soit le personnage
		if( (estGele("alex", 0))  || (estGele("ryan",0))){
			throw new PostconditionError("Un personnage ne peut etre gele au début");
		}
		for(int i=0;i<nombreGangsters();i++){
			if(estGele("gangster", 0)){
				throw new PostconditionError("Un gangster ne peut etre gele en début de partie");
			}
		}
	}

	public boolean dansIntervalle(int x, int min, int max){
		return x<=max && x>=min;
	}

	public void checkInvariants(){

		if( ! (nombreGangsters() <= nombreGangsterMax() )){
			throw new InvariantError("Un peu plus de gangsters que prevu");
		}
	}





	public void gerer(COMMANDE cA,COMMANDE cR){

		
		if(alex().estVaincu()){
			if(! (cA == COMMANDE.RIEN)){
				throw new PreconditionError("Alex est vaincu , il ne peut plus recevoir de commandes");
			}
		}
		
		
		if(ryan().estVaincu()){
			if(! (cR == COMMANDE.RIEN)){
				throw new PreconditionError("Alex est vaincu , il ne peut plus recevoir de commandes");
			}
		}
		
		
		
		super.gerer(cA, cR);
		checkInvariants();
		
		
		
		
		
		//post : alex().positionX() > 0 && alex().positionX() < largeur -1 && alex().positionY() > 0 && alex().positionY() < hauteur -1
		 //  &&  ryan().positionX() > 0 && ryan().positionX() < largeur -1 && ryan().positionY() > 0 && ryan().positionY() < hauteur -1
		
		if( ! (    (dansIntervalle(alex().positionX(), 0, terrain().largeur()-1))   && (dansIntervalle(alex().positionY(), 0, terrain().hauteur()-1))  
				&& (dansIntervalle(ryan().positionX(), 0, terrain().largeur()-1))   && (dansIntervalle(ryan().positionY(), 0, terrain().hauteur()-1)) )  ){
			throw new PostconditionError("Un personnage est sorti du terrain");
		}
			
		// post alex().estEquipe = true si estFrappe("alex",0)
//		if(estFrappe("alex", 0) && alex().estEquipe() ){
//			throw new PostconditionError("Alex n'a pas perdu d'objet");
//		}
//		
//		// post ryan().estEquipe = true si estFrappe("ryan ",0)
//		if(estFrappe("ryan", 0) && ryan().estEquipe() ){
//			throw new PostconditionError("Ryan n'a pas perdu d'objet");
////		}
		
		//\post : estFrappe("slick",id) = ( !estGele("alex",id) && cA = FRAPPER && collisionEntrePersos("alex","slick",0) )
		//								|| (!estGele("ryan",id) && cR = FRAPPER && collisionEntrePersos("ryan","slick",0) )
		if( !(estFrappe("slick", 0) == (!estGele("alex", 0) && cA==COMMANDE.FRAPPER && collisionEntrePersos("alex", "slick", 0))||
				(cR ==COMMANDE.FRAPPER && collisionEntrePersos("ryan", "slick", 0))
				)){
			throw new PostconditionError("Erreur , Slick n'a pas été frappé :"+(estFrappe("slick", 0)+" "+(estGele("alex", 0))+" "+cA.toString()+" "+collisionEntrePersos("alex", "slick", 0)));
		}


		
		
		//\post : estFrappe("gangster",id) = ( !estGele("gangster",id) && cA = FRAPPER && collisionEntrePersos("alex","gangster",id) )
		//								|| (!estGele("ryan",id) && cR = FRAPPER && collisionEntrePersos("ryan","gangster",id) )

		for(int i=0;i<nombreGangsters();i++){ 
			if( !  (estFrappe("gangster", i) ==   ((!estGele("alex", 0)   && cA ==COMMANDE.FRAPPER && collisionEntrePersos("alex", "gangster", i))
					|| (!estGele("ryan", 0)   && cR ==COMMANDE.FRAPPER && collisionEntrePersos("ryan", "gangster", i)))		)){
				throw new PostconditionError("Erreur , Gangster n'a pas été frappé");
			}
		}

		//\post : estGele("alex",id) = estFrappe("alex",id) || cA = FRAPPER || ryan()::choseEquipee = alex()
		if( !  (estGele("alex",0)  == (estFrappe("alex", 0) || (ryan().estEquipe() && ryan().choseEquipee().equals(alex()))))){
			throw new PostconditionError("Attention , Alex n'est pas gelé");
		}

		//\post : estGele("ryan",id) = estFrappe("ryan",id) || cA = FRAPPER || alex()::choseEquipee = ryan()
		if( !  (estGele("ryan",0)  == (estFrappe("ryan", 0) || (alex().estEquipe() && alex().choseEquipee().equals(ryan())) )     )  ){
			throw new PostconditionError("Attention , Ryan n'est pas gelé");
		}





	}








}

