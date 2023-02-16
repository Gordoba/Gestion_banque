package metier.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import presentation.modele.Banque;
import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.Sexe;
import presentation.modele.TableauDeBord;

public class ServiceAdmin implements IServiceAdmin {
	Banque B;
	public ServiceAdmin() {}
	public ServiceAdmin(Banque b) {
		this.B=b;
	}
	Scanner clavier=new Scanner(System.in);

	@Override
	public void nouveauClient() {
		ObjectOutputStream oos ;
		try {
	            oos =new ObjectOutputStream(
				                    new BufferedOutputStream(
				                    		new FileOutputStream(
				                    				new File("test.txt"))));
	    		
	    		Client c= new Client();
	    		int test;
	    		Sexe s=Sexe.FEMME;
	    		Sexe s1=Sexe.HOMME;
	    		System.out.println("entrer le nom du client:");
	    		c.setNom(clavier.next());
	    		System.out.println("\nentrer le prenom du client:");
	    		c.setPrenom(clavier.next());
	    		System.out.println("\nentrer le CIN du client:");
	    		c.setCin(clavier.next());
	    		System.out.println("\nentrer le Tel du client:");
	    		c.setTel(clavier.next());
	    		System.out.println("\nentrer l'email du client:");
	    		c.setEmail(clavier.next());
	    		do {
	    		System.out.println("\nentrer le sexe du client:");
	    		String s2=clavier.next();
	    		if(s2.equals("F")==true) {
	    			c.setSexe(s);
	    			test=1;
	    			break;
	    		}
	    		if(s2.equals("H")==true) {
	    			c.setSexe(s1);
	    			test=1;
	    			break;
	    		}
	    		else
	    			test=0;
	    		}while(test==0);
	    			
	    		System.out.println("\nenter le mot de passe du client :");
	    		c.setMotDePasse(clavier.next());
	    		System.out.println("\nentrer le login du client :");
	    		c.setLogin(clavier.next());
	    		if(B!=null && B.getClientsDeBanque().contains(c)) {
	    			  System.out.println("\nce client existe déja!");
	    	       }
	    		else
	    			System.out.println("\nclient ajouté avec succès:");
	    		
	    		oos.writeObject(c);
	    		
		       oos.close();
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		

		
		
	}

	@Override
	public Client nouveauCompteClientExistant() {
		Client cl = new Client();
		Compte cmp= new Compte();
		System.out.println("\nenter l'id du client souhaitez vous l'ajouter un nouveau compte");
		Long id= clavier.nextLong();
		cl = chercherClientParId(id) ;
		 if(cl==null ) {
			 System.out.println("\nce client n'existe pas!");
			 return null;
		 }
		 else {
			  System.out.println("\nentrer le premier solde :");
			  cmp.setSolde(clavier.nextDouble());
			 if( cl.getComptesClient().contains(cmp)) {
				 System.out.println("ce compte existe déja ");
				 nouveauCompteClientExistant() ;
			 }
			 else 
				cl.getComptesClient().add(cmp);
			 
		      }
	     
		return cl;
	}

	@Override
	public Client chercherClientParId(Long id) {
		Client c =new Client();
		if(B.getClientsDeBanque()!=null)
		for(Client cl : B.getClientsDeBanque()) {
			if(cl!=null)
			  if(id.equals(cl.getId())==true) {
				     c= cl;
			         break; 
	     	}
			  else
				  return null;
		}
		return c;
	}

	@Override
	public List<Client> chercherClientParNom(String nom) {
		List<Client> cls = new ArrayList<>();
		if(B.getClientsDeBanque()!=null)
		cls.addAll(B.getClientsDeBanque()
				.stream()
				.filter(c-> c.getNom().equalsIgnoreCase(nom))
			     .collect(Collectors.toList()));
		if(cls.isEmpty())
		    return null;
		else
			return cls;
	}

	@Override
	public List<Client> chercherClientParPrénom(String prenom) {
		List<Client> cls = new ArrayList<>();
		if(B.getClientsDeBanque()!=null)
		cls.addAll(B.getClientsDeBanque()
				.stream()
				.filter(c-> c.getPrenom().equalsIgnoreCase(prenom))
			     .collect(Collectors.toList()));
		if(cls.isEmpty())
		    return null;
		else
			return cls;
		
	}

	@Override
	public Client chercherClientParCin(String cin) {
		if(B.getClientsDeBanque()!=null)
		for(Client cl : B.getClientsDeBanque()) {
			if(cl!=null)
			  if(cin.equals(cl.getCin())==true) 
				  return cl;
			  else
				  break;
	
	         }
		return null;
	
		
	}

	@Override
	public Client chercherClientParEmail(String email) {
		if(B.getClientsDeBanque()!=null)
		for(Client cl : B.getClientsDeBanque()) {
			if(cl!=null)
			  if(email.equals(cl.getEmail())==true) 
				  return cl;
			  else
				  break;
	
	         }
		return null;
	}

	@Override
	public Compte chercherCompteParId(Long idCompte) {
		int i;
		if(B.getClientsDeBanque()!=null)
		for(Client cl : B.getClientsDeBanque()) {
			if(cl!=null) {
				i=B.getClientsDeBanque().indexOf(cl);
			     for(Compte cmp : B.getClientsDeBanque().get(i).getComptesClient()) 
			       if((String.valueOf(idCompte)).equals(cmp.getNumeroCompte())==true) 
				        return cmp;
			       else
				         return null;
	
	         }
			else
		       break;
	}
		return null;
	}

	@Override
	public List<Compte> chercherCompteParSolde(double solde) {
		List<Compte> c = new ArrayList<>();
		List<Compte> c1 = new ArrayList<>();
		for(int i=0;i<B.getClientsDeBanque().size();i++) {
			  c1=B.getClientsDeBanque().get(i).getComptesClient();
			 
		     c.add((Compte) c1
				.stream()
				.filter(cmp-> cmp.getSolde().equals(solde))
			     .collect(Collectors.toList()));
		}
		if(c.isEmpty())
		    return null;
		else
		
		return c;
		
	}

	@Override
	public List<Compte> chercherCompteParDateCreation(LocalDateTime date) {
		List<Compte> c = new ArrayList<>();
		List<Compte> c1 = new ArrayList<>();
		for(int i=0;i<B.getClientsDeBanque().size();i++) {
			  c1=B.getClientsDeBanque().get(i).getComptesClient();
			 
		     c.add((Compte) c1
				.stream()
				.filter(cmp-> cmp.getDateCreation().equals(date))
			     .collect(Collectors.toList()));
		}
		if(c.isEmpty())
		    return null;
		else
		
		return c;
		
	}

	@Override
	public List<Compte> chercherCompteParPropriétaire(Client propriétaire) {
		List<Compte> c = new ArrayList<>();
		List<Compte> c1 = new ArrayList<>();
		for(int i=0;i<B.getClientsDeBanque().size();i++) {
			  c1=B.getClientsDeBanque().get(i).getComptesClient();
			 
		     c.add((Compte) c1
				.stream()
				.filter(cmp-> cmp.getPropriétaire().equals(propriétaire))
			     .collect(Collectors.toList()));
		}
		if(c.isEmpty())
		    return null;
		else
		
		return c;
	}

	/*@Override
	public Client modifierClient(String filtre) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public boolean supprimerClient(Long id) {
		for(Client cl : B.getClientsDeBanque()) {
			if(cl!=null)
			  if(id.equals(cl.getId())==true) {
				  B.getClientsDeBanque().remove(cl);
				  return true;  
			  }
			  else
				  break;
	
	         }
		return false;
	}

	@Override
	public TableauDeBord calculerEtAfficherStatistiques() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> trierClientParNom() {
		Comparator <Client> comparatorNom = new Comparator<Client>() {
			public int compare(Client o1, Client o2) {
				return o1.getNom().compareTo(o2.getNom());
			     }
			     };
		    Collections.sort(B.getClientsDeBanque(),comparatorNom);
		    return B.getClientsDeBanque();
	}

	@Override
	public List<Client> trierClientParCin() {
		Comparator <Client> comparatorCin = new Comparator<Client>() {
			public int compare(Client o1, Client o2) {
				return o1.getCin().compareTo(o2.getCin());
			     }
			     };
		    Collections.sort(B.getClientsDeBanque(),comparatorCin);
		    return B.getClientsDeBanque();
	}

	@Override
	public List<Client> trierClientParEmail() {
		Comparator <Client> comparatorEmail = new Comparator<Client>() {
			public int compare(Client o1, Client o2) {
				return o1.getEmail().compareTo(o2.getEmail());
			     }
			     };
		    Collections.sort(B.getClientsDeBanque(),comparatorEmail);
		    return B.getClientsDeBanque();
	}

	/*@Override
	 public List<Client> trierClientParAdresse() {
		return null;
	}*/

	
/*	public List<Client> trierClientParSoldeCompte() {
		int  j;
		List<Compte> AllAccounts = new ArrayList<Compte>();
		for(int i=0;i< B.getClientsDeBanque().size();i++) {
			if(B.getClientsDeBanque()!=null)
			  AllAccounts.addAll(B.getClientsDeBanque().get(i).getComptesClient());
			   
		}
		Comparator <Client> comparatorNom = new Comparator<Client>() {
		//	public int  compare(Client o1, Client o2) {
				
				return ((o1.getComptesClient().get().getSolde().compareTo((o2.getComptesClient().get(j)).getSolde()));
			     }
			     };
		    return B.getClientsDeBanque();
	}
*/
	@Override
	public List<Compte> trierComptesParSolde() {
		List<Compte> AllAccounts = new ArrayList<Compte>();
		for(int i=0;i< B.getClientsDeBanque().size();i++) {
			if(B.getClientsDeBanque()!=null)
			  AllAccounts.addAll(B.getClientsDeBanque().get(i).getComptesClient());
			   
		}
		Comparator <Compte> comparatorSolde = new Comparator<Compte>() {
			public int compare(Compte c, Compte c1) {
				return c1.getSolde().compareTo(c1.getSolde());				
			}};
			if(AllAccounts.isEmpty())
				return null;
			else
			Collections.sort(AllAccounts,comparatorSolde);
			return AllAccounts;
		
	}

	@Override
	public List<Compte> trierComptesParDateDeCreation() {
		List<Compte> AllAccounts = new ArrayList<Compte>();
		for(int i=0;i< B.getClientsDeBanque().size();i++) {
			if(B.getClientsDeBanque()!=null)
			  AllAccounts.addAll(B.getClientsDeBanque().get(i).getComptesClient());
			   
		}
		Comparator <Compte> comparatorDate = new Comparator<Compte>() {
			public int compare(Compte c, Compte c1) {
				return c1.getDateCreation().compareTo(c1.getDateCreation());				
			}};
			if(AllAccounts.isEmpty())
				return null;
			else
			Collections.sort(AllAccounts,comparatorDate);
			return AllAccounts;
	}

	@Override
	public List<Compte> trierComptesParNomPropriétaire() {
		List<Compte> AllAccounts = new ArrayList<Compte>();
		for(int i=0;i< B.getClientsDeBanque().size();i++) {
			if(B.getClientsDeBanque()!=null)
			  AllAccounts.addAll(B.getClientsDeBanque().get(i).getComptesClient());
			   
		}
		Comparator <Compte> comparatorOwner = new Comparator<Compte>() {
			public int compare(Compte c, Compte c1) {
				return String.valueOf(c.getPropriétaire().getId()).compareTo(String.valueOf(c1.getPropriétaire().getId()));				
			}};
			if(AllAccounts.isEmpty())
				return null;
			else
			Collections.sort(AllAccounts,comparatorOwner);
			return AllAccounts;
	}
	@Override
	public List<Client> trierClientParSoldeCompte() {
		// TODO Auto-generated method stub
		return null;
	}

}
