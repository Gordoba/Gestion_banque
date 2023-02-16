package metier.authentification;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import metier.admin.serviceIHMAdmin;
import metier.clients.ServiceClient;
import metier.clients.ServiceIHMClient;
import presentation.modele.Client;

import presentation.modele.Banque;


public class ServiceAuth implements IAuth {
	
	Banque B;
	Scanner clavier=new Scanner(System.in);
	
	public ServiceAuth() {
	}
	public ServiceAuth(Banque b) {
		this.B=b;
	}

	public Client testerClient(String nom ,String password) {
		for(int i=0;i<B.getClientsDeBanque().size();i++) {
			if((B.getClientsDeBanque().get(i).getNom().equals(nom)==true) && ((B.getClientsDeBanque().get(i).getMotDePasse().equals(password)==true)))
					return B.getClientsDeBanque().get(i) ;
		  }
			
				return null;
		}
	public boolean testerAdmin(String nom , String password) {
		if(nom.compareTo("admin")==0 && password.compareTo("1234")==0)
					return true;	
		else
		   		return false;
		}
	@Override
	public void seConnecter() {
		String nom , password;
		int test;
		System.out.println("********************************************");
		System.out.println("\n|******Formulaire de login****************|");
		System.out.println("\n*****************************************");
		
		do{
			System.out.println("\n|Nom d'utilisateur:");
		    nom=clavier.nextLine();
		    if(nom.length()<4) {
		    System.out.println("\nLogin doit etre de plus de 4 caractères");
		    test=0;
		    }
		    else
		    	test=1;
		}while(test==0);
		
		
		do {
		   System.out.println("\n|Mot de passe:");
		   password=clavier.nextLine();
		    if(password.length()==0) {
			    System.out.println("\nLe champs Mot de passe est obligatoire :");
			    test=0;
			    }
			    else
			    	test=1;
			}while(test==0);
		
		System.out.println("\n|Administrateur:(oui/non):");
		String response =clavier.nextLine();
		Client currentclient=new Client();
		
		if(response.compareTo("non")==0) {
			currentclient=testerClient(nom,password);
			if(currentclient!=null) {
			System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			System.out.println("\n     Bienvenue Cher(e) Client(e) :");
			Date date =new Date();
			SimpleDateFormat d =new SimpleDateFormat("/dd/MM/yy HH:mm:ss");
			String time = d.format(date);
			System.out.println("["+time+"]");
			System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			System.out.println("\n   Session ouverte pour [Client :"+currentclient.getPrenom()+currentclient.getNom()+"]");
			ServiceIHMClient SC =new ServiceIHMClient( B);
		
		  
			}
		}
		if(response.compareTo("oui")==0) {
			if(testerAdmin(nom,password)) {
			System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			System.out.println("\n     Bienvenue Cher(e) Admin(e) :");
			Date date =new Date();
			SimpleDateFormat d =new SimpleDateFormat("/dd/MM/yy :: HH:mm:ss");
			String time = d.format(date);
			System.out.println("=*=               "+time+"             =*=");
			System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			serviceIHMAdmin SA = new serviceIHMAdmin(this.B);
		    SA.GestionMenu();
			}
		}
		else
			System.out.println("Mot de passe ou Nom d'utilisateur est incorrecte!!");
	}

	@Override
	public void SeDéconnecter() {
		// TODO Auto-generated method stub
		
	}

}
