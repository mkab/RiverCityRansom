package gangster;

import error.PostconditionError;
import error.PreconditionError;
import personnage.InvariantError;
import personnage.Objet;
import personnage.PersonnageDecorator;
import personnage.PersonnageService;

public class GangsterContrat extends GangsterDecorator{
	

		public GangsterContrat(GangsterService delegate){
			super(delegate);
		}

		public void checkInvariant() throws InvariantError {
			if(estVaincu() != (pointsDeVie()<=0)){ 
				throw new InvariantError("Le personnage n'est pas vaincu mais il n'a plus de pv :/");
			}
		}


		public void init(String nom, int largeur, int hauteur,int profondeur, int force , int pointsDeVie) throws PreconditionError, PostconditionError {
			// pre : nom != ""
			if(nom.equals("")){
				throw new PreconditionError("Le nom du personnage est vide");
			}
			// pre : nom = gangster || nom = slick
			if(! (nom.equals("gangster")  || nom.equals("slick") )){
				throw new PreconditionError("Le nom du gangster n'est pas correct");
			}
			

			// pre : longueur > 0
			if(!(largeur>0)) {
				throw new PreconditionError("La largeur n'est pas correcte");
			}

			if(!(hauteur>0)) {
				throw new PreconditionError("La hauteur n'est pas correcte");
			}
			if(!(profondeur>0)) {
				throw new PreconditionError("La profondeur n'est pas correcte");
			}
			if(!(force>0)){
				throw new PreconditionError("La force n'est pas correcte");
			}
			if(!(force <pointsDeVie)){
				throw new PreconditionError("La force est plus grande que les points de vie");
			}
			if(!(pointsDeVie>0)){
				throw new PreconditionError("Les PV ne sont pas positifs");
			}

			super.init(nom, largeur,hauteur,profondeur,force ,pointsDeVie);




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
				throw new PostconditionError("Le gangster doit avoir 0 d'argent au début");
			}
			//post : estVaincu() == false
			if(!(estVaincu()==false)){
				throw new PostconditionError("Le gangster ne peut être vaincu au début");
			}
			//post : estVaincu() == false
			if(!(estEquipe()==false)){
				throw new PostconditionError("Le gangster est équipé d'un objet");
			}

		}


		public GangsterService depotPV(PersonnageService p, int pv) throws PreconditionError, PostconditionError {
			
			
			
			//pointsDeVie()@pre : pointsDevie
			int tmpPV = pointsDeVie();
			
			super.depotPV(p, pv);

			//post : pointsDeVie()@pre == pointsDeVie()
			if(!(pointsDeVie() == tmpPV)){
				throw new PostconditionError("Erreur Un gangster ne gagne pas de pv");
			}

			return this;
		}


		public GangsterService retraitPV(PersonnageService p, int pv) throws PreconditionError, PostconditionError {

			// pointsDeVie()@pre
			int tmpPV = pointsDeVie();
			//pre : pv>0
			if(!(pv>0)){
				throw new PreconditionError("Les PV doivent être postifs");
			}
			super.retraitPV(p, pv);
			//post : pointsDeVie()@pre == pointsDevie()@pre - pv
			if(!(pointsDeVie()==(tmpPV - pv))){
				throw new PostconditionError("Erreur durant l'update des PV");
			}
			return this;
		}


		public GangsterService depotArgent(PersonnageService p, int a) throws PreconditionError, PostconditionError {
			//argentRamasse@pre
			int tmpArgent = ArgentRamasse();


			super.depotArgent(p, a);

			//post : ArgentRamasse() == argentRamasse()@pre
			if(!(ArgentRamasse()==(tmpArgent))){
				throw new PostconditionError("l'argent n'est pas correctement mis-à-jour");
			}

			return this;

		}


		public GangsterService retraitArgent(PersonnageService p, int a) throws PreconditionError, PostconditionError {
			//argentRamasse@pre
			int tmpArgent = ArgentRamasse();

			super.retraitArgent(p, a);

			//post : ArgentRamasse() == argentRamasse()@pre
			if(!(ArgentRamasse()==(tmpArgent))){
				throw new PostconditionError("l'argent n'est pas correctement mis-à-jour");
			}

			return this;

		}



		public GangsterService ramasser(PersonnageService p, Objet o) throws PreconditionError, PostconditionError {


			// pre :estEquipe() == false
			if(estEquipe()) throw new PreconditionError("Le gangster ne doit pas être équipé pour ramasser");

			//argentRamasse()@pre
			int tmpArgent = ArgentRamasse();
			//force()@pre
			int tmpForce = force();		

			super.ramasser(p, o);

			//post : estEquipe() ==true
			if(!estEquipe()) throw new PostconditionError("Le gangster doit être équipé d'un objet");

			//post : choseEquipee() == o
			if(!(choseEquipee().equals(o))) 
				throw new PostconditionError("l'objet équipé est différent");



			//post if o::estUtilisable() then force() == force() + o.valeur();
			if(o.estUtilisable()){
				if(!(force()==(tmpForce + o.valeur()))){
					throw new PostconditionError("Problème de mise-à-jour de la force");
				}
			}



			//post : if o.estUtilisable = false then argentRamasse() = argentRamasse() + o.valeur
			if(!(o.estUtilisable())){
				if(!(ArgentRamasse() == (tmpArgent+o.valeur()))){
					throw new PostconditionError("Problème de mise-à-jour de l'argent");
				}
			}




			return this;
		}



		public GangsterService jeter(PersonnageService p, Objet o) throws PostconditionError, PreconditionError {

			// pre :estEquipe() == true
			if(!estEquipe()) throw new PreconditionError("Le perso ne doit pas être équipé pour ramasser");

			//force()@pre
			int tmpForce = force();
			//argentRamasse()@pre
			int tmpArgent = ArgentRamasse();


			super.jeter(p, o);

			//post : estEquipe() ==false
			if(estEquipe()) throw new PostconditionError("Le personnage ne doit pas être équipé d'un objet");

			//post : choseEquipee() == null
			if((choseEquipee()!=null)) 
				throw new PostconditionError("Le personnage est toujours équipé d'un objet");


			//post force() == force() - o.valeur();

			if(!(force()==(tmpForce - o.valeur()))){
				throw new PostconditionError("Problème de mise-à-jour de la force");
			}



			//post : argentRamasse() = argentRamasse()@pre

			if(!(ArgentRamasse() == (tmpArgent))){
				throw new PostconditionError("Problème de mise-à-jour de l'argent");
			}


			

			return this;
		}


		public GangsterService sauter(PersonnageService p) throws PreconditionError, PostconditionError {
		//pre : estPositionSaut() = false
			
			
			if(estPositionSaut()) 
				throw new PreconditionError("Le personnage est déja en position de saut");
			
			super.sauter(p);
			
			//post : estPositionSaut() = true
			if(! estPositionSaut())
				throw new PostconditionError("Le personnage n'est pas en position de saut");
			
			return this;
		}

	}

