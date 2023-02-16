import javax.swing.JFrame;

public class FormException extends Exception {
	String consigne ;
 public FormException() {}
 public FormException(String errormsg) {
	 
	 this.consigne=errormsg;
	 
 }
}

public class loginframe extends JFrame {
