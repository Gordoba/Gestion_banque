package metier.clients;

import java.util.Scanner;

import presentation.modele.Banque;

public class ServiceIHMClient implements IServiceIHMClient {
	Scanner clavier = new Scanner(System.in);
	Banque B;
	public ServiceIHMClient() {}
	public ServiceIHMClient(Banque b){
		B=b;
	}

	@Override
	public int menuGlobal() {
		int result;
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=Tapez 1 pour faire un versemnet                    =");
		System.out.println("\n=Tapez 2 pour faire un retrait                      =");
		System.out.println("\n=Tapez 3 pour faire un virment                      =");
		System.out.println("\n=Tapez 4 pour modifier votre profil                 =");
		System.out.println("\n=Tapez 5 pour afficher des informations du compte   =");
		System.out.println("\n=Tapez 6 pour afficher le solde actuel              =");
		System.out.println("\n=Tapez 6 pour retourner au menu principale          =");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n==>Entrez votre choix : ");
		result=clavier.nextInt();
		return result;
	}

	@Override
	public int menuModification() {
		int result;
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=Tapez 1 pour modifier vitre nom et prenom          =");
		System.out.println("\n=Tapez 2 pour modifeir votre mot de passe           =");
		System.out.println("\n=Tapez 3 pour modifier votre n°cin                  =");
		System.out.println("\n=Tapez 4 pour modifier votre email                  =");
		System.out.println("\n=Tapez 5 pour modifier votre n° de telephone        =");
		System.out.println("\n=Tapez 6 pour retourner au menu principale          =");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n==>Entrez votre choix : ");
		result=clavier.nextInt();
		return result;
	}

	@Override
	public int menuRetrait() {
		int result;
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=Tapez 1 pour faire un retrait de 100 DH            =");
		System.out.println("\n=Tapez 2 pour faire un retrait de 200 DH            =");
		System.out.println("\n=Tapez 3 faire un retrait de 500 DH                 =");
		System.out.println("\n=Tapez 4 faire un retrait de 1000 DH                =");
		System.out.println("\n=Tapez 5 faire un retrait de 2000 DH                =");
		System.out.println("\n=Tapez 6 faire un retrait d'un autre montant        =");
		System.out.println("\n=Tapez 7 pour retourner au menu principale          =");
		System.out.println("\n=*=                                               =*=");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n==>Entrez votre choix : ");
		result=clavier.nextInt();
		return result;
	}

	@Override
	public int menuInformations() {
		int result;
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n=*=                                                        =*=");
		System.out.println("\n=Tapez 1 pour afficher votre profil                          =");
		System.out.println("\n=Tapez 2 pour afficher le solde de votre compte              =");
		System.out.println("\n=Tapez 3 pour afficher les dernières opérations du compte    =");
		System.out.println("\n=Tapez 4 pour afficher les opérations d'aujourd'hui          =");
		System.out.println("\n=Tapez 5 pour afficher l'archife du virements                =");
		System.out.println("\n=Tapez 6 pour retourner au menu principale                   =");
		System.out.println("\n=*=                                                        =*=");
		System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\n==>Entrez votre choix : ");
		result=clavier.nextInt();
		return result;
	
	}
public void GestionClient() {
	ServiceClient SA =new ServiceClient(B);
	SA.choisirCompte();
	menuGlobal();

}
}
