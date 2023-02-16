package presentation.controleur;
import metier.admin.ServiceAdmin;
import metier.authentification.IAuth;
import metier.authentification.ServiceAuth;
import presentation.modele.Banque;
import java.util.Scanner;

public class MaBanque {
        public static IAuth loginService;

        public static void main(String[] args) {

                Banque maBanque
                        = new Banque(   "BP",
                                        "Hassan Rabat",
                                        "212535224433",
                                        "bp@banquePop.ma");


                Scanner clavier = new Scanner(System.in);
                loginService = new ServiceAuth(maBanque);
                loginService.seConnecter();
                ServiceAdmin admin=new ServiceAdmin(maBanque);
               /* Client c=new Client();
                c=admin.nouveauClient();
                System.out.println(c.getId());
                admin.nouveauCompteClientExistant();
                admin.nouveauClient();
                admin.chercherClientParNom("M");*/

                clavier.close();

        }

}
