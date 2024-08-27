package controller;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillProcess {
	
	public KillProcess() {
		super();
	}
	
	private String os() {
		return System.getProperty("os.name").toLowerCase();
	}
	
	public void readProcess(String proc) {
			String[] procArr = proc.split(" ");
			try {
				Process p = Runtime.getRuntime().exec(procArr);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("dia")) {
						String[] ping = linha.split(",");
						String[] media = ping[2].split("=");
						System.out.println(media[1]);
					}
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
	public void mataPid(String valor) {
		String os = System.getProperty("os.name").toLowerCase();
		//String cmdNome = "TASKKILL /IM";
		String cmdPid = "TASKKILL /PID";
		
		StringBuffer buffer = new StringBuffer();
		int pid = 0;
		try {
			pid = Integer.parseInt(valor);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		} catch (Exception e1) {
			System.err.println(e1.getMessage());
		}


		String matar = buffer.toString();
		readProcess(matar);
	}
	
	public void mataNome(String proc) {
		String cmdNome = "TASKKILL /IM";
		//String cmdPid = "TASKKILL /PID";
		
		StringBuffer buffer = new StringBuffer();
		String nome = null;
		try {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(nome);
		} catch (Exception e2) {
			System.err.println(e2.getMessage());
		}
		
		String matar = buffer.toString();
		readProcess(matar);
	}
}
