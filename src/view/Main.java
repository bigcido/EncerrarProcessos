package view;
import controller.KillProcess;
import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		KillProcess kp = new KillProcess();

		kp.readProcess("TASKLIST /FO TABLE");
		
		String proc = JOptionPane.showInputDialog("Informe o nome do processo a ser eliminado: ");
		String valor = JOptionPane.showInputDialog("Obliterar processo nr: ");
		
		kp.mataPid(valor);
		kp.mataNome(proc);
		
	}

}
