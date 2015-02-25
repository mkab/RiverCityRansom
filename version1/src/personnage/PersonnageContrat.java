package personnage;

import error.PostconditionError;
import error.PreconditionError;

public class PersonnageContrat extends PersonnageDecorator{

	public PersonnageContrat(PersonnageService delegate){
		super(delegate);
	}

	public void checkInvariant(){
		//\Inv estVaincu() = pointsDeVie() <= 0
		if(estVaincu() != (pointsDeVie()<=0)){ 
			throw new InvariantError("Le personnage est invaincu mais il n'a plus de pv :/");
		}
	}


	public void init(String nom, int largeur, int hauteur,int profondeur, int force , int pointsDeVie) {
		// pre : nom != ""
		if(nom.equals("")){
			throw new PreconditionError("Le nom du personnage est vide");
		}
		if(!(nom.equals("alex")||nom.equals("ryan"))){
			throw new PreconditionError("Le nom du personnage n'est pas correct");
		}

		// \pre : init(nom,largeur,hauteur,profondeur,force,pointsDeVie) require longueur > 0
		if(!(largeur>0)) {
			throw new PreconditionError("La largeur n'est pas correcte");
		}
		// \pre : init(nom,largeur,hauteur,profondeur,force,pointsDeVie) require hauteur>0
		if(!(hauteur>0)) {
			throw new PreconditionError("La hauteur n'est pas correcte");
		}
		// \pre : init(nom,largeur,hauteur,profondeur,force,pointsDeVie) require profondeur>0
		if(!(profondeur>0)) {
			throw new PreconditionError("La profondeur n'est pas correcte");
		}
		// \pre : init(nom,largeur,hauteur,profondeur,force,pointsDeVie) require force>0
		if(!(force>0)){
			throw new PreconditionError("La force n'est pas correcte");
		}
		// \pre : init(nom,largeur,hauteur,profondeur,force,pointsDeVie) require force <pointsDeVie
		if(!(force <pointsDeVie)){
			throw new PreconditionError("La force est plus grande que les points de vie");
		}
		// \pre : init(nom,largeur,hauteur,profondeur,force,pointsDeVie) require pointsDeVie>0
		if(!(pointsDeVie>0)){
			throw new PreconditionError("Les PV ne sont pas positifs");
		}

		
		checkInvariant();
		super.init(nom, largeur,hauteur,profondeur,force ,pointsDeVie);
		checkInvariant();




		// post : nom() == nom
		if(!(nom().equals(nom))){
			throw new PostconditionError("Le nom du personnage n'est pas correct");
		}

		//post : largeur() == largeur
		if(!(largeur()==largeur)){
			throw new PostconditionError("La largeur n'est pas correcte");
		}
		//post : hauteur() == hauteur
		if(!(hauteur()==hauteur)){
			throw new PostconditionError("La hauteur n'est pas correcte");
		}
		//post : profondeur() == profondeur
		if(!(profondeur()==profondeur)){
			throw new PostconditionError("La profondeur n'est pas correcte");
		}
		//post : force() == force
		if(!(force()==force)){
			throw new PostconditionError("La force n'est pas correcte");
		}
		//post : pointsDeVie() == pointsDeVie
		if(!(pointsDeVie()==pointsDeVie)){
			throw new PostconditionError("Les PV ne sont pas corrects");
		}
		//post : ArgentRamasse = 0
		if(!(ArgentRamasse()==0)){
			throw new PostconditionError("Le personnage doit avoir 0 d'argent au d�but");
		}
		//post : estVaincu() == false
		if(!(estVaincu()==false)){
			throw new PostconditionError("Le personnage ne peut �tre vaincu au d�but");
		}
		//post : estVaincu() == false
		if(!(estEquipe()==false)){
			throw new PostconditionError("Le personnage est �quip� d'un objet");
		}

	}


	public PersonnageService depotPV(PersonnageService p, int pv){
		//pre : pv>0
		if(!(pv>0)){
			throw new PreconditionError("Les PV doivent �tre postifs");
		}

		int tmpPV = pointsDeVie();
		super.depotPV(p, pv);

		checkInvariant();
		//post : pointsDeVie()@pre == pointsDeVie() + pv
		if(!(pointsDeVie() == tmpPV+pv)){
			throw new PostconditionError("Erreur durant l'update des PV");
		}
		return this;
	}


	public PersonnageService retraitPV(PersonnageService p, int pv){
		// pointsDeVie()@pre
		int tmpPV = pointsDeVie();
		//pre : pv>0
		if(!(pv>0)){
			throw new PreconditionError("Les PV doivent �tre postifs");
		}
		super.retraitPV(p, pv);
		checkInvariant();
		
		//post : pointsDeVie()@pre == pointsDevie()@pre - pv
		if(!(pointsDeVie()==(tmpPV - pv))){
			throw new PostconditionError("Erreur durant l'update des PV");
		}
		return this;
	}


	public PersonnageService depotArgent(PersonnageService p, int a){
		//argentRamasse@pre
		int tmpArgent = ArgentRamasse();

		//pre : amount > 0
		if(!(a>0)){
			throw new PreconditionError("l'argent doit �tre positif");
		}


		super.depotArgent(p, a);
		checkInvariant();
		
		
		//post : ArgentRamasse() == argentRamasse()@pre + a
		if(!(ArgentRamasse()==(tmpArgent+a))){
			throw new PostconditionError("l'argent n'est pas correctement mis-�-jour");
		}

		return this;

	}


	public PersonnageService retraitArgent(PersonnageService p, int a){
		//argentRamasse@pre
		int tmpArgent = ArgentRamasse();

		//pre : amount > 0
		if(!(a>0)){
			throw new PreconditionError("l'argent doit �tre positif");
		}


		super.retraitArgent(p, a);
		checkInvariant();
		
		//post : ArgentRamasse() == argentRamasse()@pre - a
		if(!(ArgentRamasse()==(tmpArgent-a))){
			throw new PostconditionError("l'argent n'est pas correctement mis-�-jour");
		}

		return this;

	}



	public PersonnageService ramasser(PersonnageService p, Objet o){


		// pre :estEquipe() == false
		if(estEquipe()) throw new PreconditionError("Le perso ne doit pas �tre �quip� pour ramasser");

		//argentRamasse()@pre
		int tmpArgent = ArgentRamasse();
		//force()@pre
		int tmpForce = force();		

		super.ramasser(p, o);
		checkInvariant();
		
		
		//post : estEquipe() ==true
		if(!estEquipe()) throw new PostconditionError("Le personnage doit �tre �quip� d'un objet");

		//post : choseEquipee() == o
		if(!(choseEquipee().equals(o))) 
			throw new PostconditionError("l'objet �quip� est diff�rent");



		//post if o::estUtilisable() then force() == force() + o.valeur();
		if(o.estUtilisable()){
			if(!(force()==(tmpForce + o.valeur()))){
				throw new PostconditionError("Probl�me de mise-�-jour de la force");
			}
		}



		//post : if o.estUtilisable = false then argentRamasse() = argentRamasse() + o.valeur
		if(!(o.estUtilisable())){
			if(!(ArgentRamasse() == (tmpArgent+o.valeur()))){
				throw new PostconditionError("Probl�me de mise-�-jour de l'argent");
			}
		}




		return this;
	}



	public PersonnageService jeter(PersonnageService p, Objet o){

		// pre :estEquipe() == true
		if(!estEquipe()) throw new PreconditionError("Le perso ne doit pas �tre �quip� pour ramasser");

		//force()@pre
		int tmpForce = force();
		//argentRamasse()@pre
		int tmpArgent = ArgentRamasse();


		super.jeter(p, o);
		checkInvariant();
		
		
		//post : estEquipe() ==false
		if(estEquipe()) throw new PostconditionError("Le personnage ne doit pas �tre �quip� d'un objet");

		//post : choseEquipee() == null
		if((choseEquipee()!=null)) 
			throw new PostconditionError("Le personnage est toujours �quip� d'un objet");


		//post force() == force() - o.valeur();

		if(!(force()==(tmpForce - o.valeur()))){
			throw new PostconditionError("Probl�me de mise-�-jour de la force");
		}



		//post : argentRamasse() = argentRamasse()@pre

		if(!(ArgentRamasse() == (tmpArgent))){
			throw new PostconditionError("Probl�me de mise-�-jour de l'argent");
		}


		

		return this;
	}


	public PersonnageService sauter(PersonnageService p){
	//pre : estPositionSaut() = false
		
		
		if(estPositionSaut()) 
			throw new PreconditionError("Le personnage est déja en position de saut");
		
		super.sauter(p);
		checkInvariant();
		
		
		//post : estPositionSaut() = true
		if(! estPositionSaut())
			throw new PostconditionError("Le personnage n'est pas en position de saut");
		
		return this;
	}
	
	public PersonnageService setPositionFrappe(boolean pos){
		//pre : estPositionFrappe() = false
			
			
			if(estPositionFrappe()) 
				throw new PreconditionError("Le personnage est deja en position de frappe");
			
			super.setPositionFrappe(pos);
			checkInvariant();
			
			
			//post : estPositionSaut() = true
			if(! estPositionFrappe())
				throw new PostconditionError("Le personnage n'est pas en position de frappe");

			return this;
		}


	public PersonnageService setPosition(int x,int y){
		//pre : setPosition(x,y) require x>=0 and y>=0
		if(! (x>=0&&y>=0))
			throw new PreconditionError("Les positions ne sont pas correctes");
		super.setPosition(x, y);
		checkInvariant();
		
		
		return this;
	}

	
	

}
