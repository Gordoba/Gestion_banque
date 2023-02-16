package metier.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import presentation.modele.Banque;
import presentation.modele.Compte;
import presentation.modele.Log;

public class ServiceClient implements IServiceClient {
	Scanner clavier= new Scanner(System.in);
	Banque B;
	public ServiceClient() {
		// TODO Auto-generated constructor stub
	}
	public ServiceClient(Banque b) {
		B=b;
	}

	@Override
	public boolean versement() {
		System.out.println("\nEntrez l'id du compte destinataire ");
		return false;
	}

	@Override
	public boolean retrait() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retrait(int choixRetrait) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean virement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierProfile(int choixModification) {
		System.out.println("\n=");
		System.out.println();
		return false;
	}

	@Override
	public void dernièresOpérations() {
		Compte c= new Compte();
		c=choisirCompte();
		if(c!=null) 
			if(c.getLogs().get(c.getLogs().size()-1)!=null)
              System.out.println("\nla dernière operation:"+c.getLogs().get(c.getLogs().size()-1));
				
	}

	@Override
	public Double afficherSolde() {
		Compte c= new Compte();
		c=choisirCompte();
		if(c!=null) 
			return c.getSolde();
		else
		return null;
	}

	@Override
	public Compte choisirCompte() {
		System.out.println("\nEntrer l'id du compte souhaitez vous choisir");
		Long id = clavier.nextLong();
		List<Compte> AllAccounts = new ArrayList<Compte>();
		for(int i=0;i< B.getClientsDeBanque().size();i++) {
			if(B.getClientsDeBanque()!=null)
			  AllAccounts.addAll(B.getClientsDeBanque().get(i).getComptesClient());
			   
		}
		for(Compte c : AllAccounts) {
			if(c!=null)
			  if(id.equals( Long.parseLong(c.getNumeroCompte()))==true)
				  return c;
			  else
				 break;
		}
		return null;
	}

	@Override
	public void afficherTicket() {
		// TODO Auto-generated method stub
		
	}

}
