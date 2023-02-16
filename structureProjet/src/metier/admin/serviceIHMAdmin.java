package metier.admin;

import java.util.Scanner;

import presentation.modele.Banque;
import presentation.modele.Client;

public class serviceIHMAdmin implements IServiceIHMAdmin {
	Banque B;
	public serviceIHMAdmin() {}
	public serviceIHMAdmin(Banque b) {
		this.B=b;
	}
   Scanner clavier=new Scanner(System.in);
   ServiceAdmin SA= new ServiceAdmin(this.B);
	@Override
	public int menuGlobal() {
		int retour;
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=*=                                                 =*=");
		System.out.println("\n=Tapez 1 pour le [service CRUD] :                     =");
		System.out.println("\n=Tapez 2 pour le [service Informations]:              =");
		System.out.println("\n=Tapez 3 pour le [Service Trie]   :                   =");
		System.out.println("\n=Tapez 4 pour le [Tableau de bord - Statistiques]:    =");
		System.out.println("\n=Tapez 5 pour se déconnecter :                        =");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=>Entrez votre choix : ");
		retour = clavier.nextInt();
		return retour;
	}
	public int menuCRUD() {
		int retour;
		System.out.println("\n=*=>Menu CRUD                                         ");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=*=                                                 =*=");
		System.out.println("\n=Tapez 1 pour le [Menu de Recherche] :                =");
		System.out.println("\n=Tapez 2 pour le [Menu de Modification]:              =");
		System.out.println("\n=Tapez 3 pour le [Menu de suppression]   :            =");
		System.out.println("\n=Tapez 4 pour le [Menu d'ajout]:                      =");
		System.out.println("\n=Tapez 5 pour se déconnecter :                        =");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=>Entrez votre choix : ");
		retour = clavier.nextInt();
		return retour;
		
	}

	@Override
	public int menuModification() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int menuRecherche() {
		int retour;
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=Tapez 1 pour chercher clienr par id :              =");
		System.out.println("\n=Tapez 2 pour chercher client par Nom:              =");
		System.out.println("\n=Tapez 3 pour chercher client par Prenom            =");
		System.out.println("\n=Tapez 4 pour chercher client par Email:            =");
		System.out.println("\n=Tapez 5 pour chercher client par Cin :             =");
		System.out.println("\n=Tapez 6 pour chercher compte par id :              =");
		System.out.println("\n=Tapez 7 pour chercher compte par Solde:            =");
		System.out.println("\n=Tapez 8 pour chercher compte par Date de création  =");
		System.out.println("\n=Tapez 9 pour chercher compte par Nom Propriètaire: =");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=>Entrez votre choix : ");
		retour = clavier.nextInt();
		return retour;
	}
	public void SwitchRecherche() {
		int test;
		test=menuRecherche();
		switch(test) {
		case 1:System.out.println("\n|=Entrez l'id du client souhaitez vous chercher:"); 
		        Long id=clavier.nextLong();
			    SA.chercherClientParId(id);
		case 2 :System.out.println("\n|=Entrez le nom du client souhaitez vous chercher:"); 
                 String nom=clavier.nextLine();
                 SA.chercherClientParNom(nom);
		case 3 :System.out.println("\n|=Entrez le Prenom du client souhaitez vous chercher:"); 
                String prenom=clavier.nextLine();
                 SA.chercherClientParPrénom(prenom);
		case 4 : System.out.println("\n|=Entrez l'email du client souhaitez vous chercher:"); 
                 String email=clavier.nextLine();
                 SA.chercherClientParEmail(email);
		case 5 :  System.out.println("\n|=Entrez le n° cin du client souhaitez vous chercher:"); 
                   String cin=clavier.nextLine();
                   SA.chercherClientParCin(cin);
		case 6:System.out.println("\n|=Entrez l'id du compte souhaitez vous chercher:"); 
                Long id1=clavier.nextLong();
	             SA.chercherCompteParId(id1);
		case 7:System.out.println("\n|=Entrez le solde du compte souhaitez vous chercher:"); 
                  Double solde=clavier.nextDouble();
                 SA.chercherCompteParSolde(solde);
	/*	case 8 :System.out.println("\n|=Entrez la date de creation de compte souhaitez vous chercher:"); 
                Date date=clavier.n;
                SA.chercherCompteParSolde(solde);*/
		case 9 :System.out.println("\n|=Entrez le nom de proprietaire du compte souhaitez vous chercher:"); 
                String nom1=clavier.nextLine();
                Client c=new Client();
                c.setNom(nom1);
                SA.chercherCompteParPropriétaire(c);
       default:
                System.out.println("entrer un nombre valide");
                 
		}
	}

	@Override
	public int menuInformations() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int menuAjout() {
		int retour;
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=Tapez 1 pour ajouter nouveau client :              =");
		System.out.println("\n=Tapez 2 pour ajouter nouveau compte au client:     =");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=>Entrez votre choix : ");
		retour = clavier.nextInt();
		return retour;
	}
    public void SwitchAjout() {
    	int test;
    	test=menuAjout();
    	switch(test) {
    	case 1:SA.nouveauClient();break;
    	case 2:SA.nouveauCompteClientExistant();break;
    	 default:
             System.out.println("\nentrer un nombre valide");
    	}
    }
	@Override
	public int menuSuppression() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int tableauDeBord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int menuTrie() {
		int retour;
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=Tapez 1 pour trier clients par Nom:              =");
		System.out.println("\n=Tapez 2 pour trier clients par Email:            =");
		System.out.println("\n=Tapez 3 pour trier clients par Cin :             =");
		System.out.println("\n=Tapez 4 pour trier clients par Solde compte      =");
		System.out.println("\n=Tapez 5 pour trier comptes par Solde:            =");
		System.out.println("\n=Tapez 6 pour trier comptes par Date de création  =");
		System.out.println("\n=Tapez 7 pour trier comptes par Nom Propriètaire: =");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=>Entrez votre choix : ");
		retour = clavier.nextInt();
		return retour;
	}
	public void SwitchTrie() {
		int test;
		test=menuTrie();
		switch(test) {
		case 1: SA.trierClientParNom();
		case 2 :SA.trierClientParEmail();
		case 3: SA.trierClientParCin();
		case 4 : SA.trierClientParSoldeCompte();
		case 5:SA.trierComptesParDateDeCreation();
		case 6 :SA.trierComptesParNomPropriétaire();
		default :
			System.out.println("\nentrer un nombre valide");
			
	}
	}

	@Override
	public int menuComptabilité() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void GestionMenu() {
	int menuglobal=menuGlobal();
	int test;
	switch(menuglobal) {
	case 1:test= menuCRUD();
	       switch(test) {
	       case 1 :SwitchRecherche();
	       case 4:SwitchAjout();
	       }
	        
	case 2 : menuInformations();
	case 3: SwitchTrie();
	}
	}
}


