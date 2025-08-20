import java.net.Socket;

class ScannerDeRede {
	// --- Atributo ---
    // Cada objeto ScannerDeRede terá seu próprio ipAlvo
    String ipAlvo;
    
    // --- MÉTODO CONSTRUTOR ---
    // Configurr o estado inicial do objeto
    public ScannerDeRede(String ip) {
    	this.ipAlvo = ip;
    }
    // --- MÉTODO DE AÇÃO --
    // A ação que nosso scanner sabe fazer
    public void escanear(int portaInicial, int portaFinal) {
    	System.out.println("Iniciando varredura no alvo" + this.ipAlvo + "...")
        
        for (int porta = portaInicial; porta <= portaFinal; porta ++) {
        	try {
            	Socket socket = new Socket(this.ipAlvo, porta);
                System.out.println("Porta " + porta + " está ABERTA");
                socket.close()
            } catch (Exception e) {
            	System.out.println("Porta" + porta + "Fechada ou falhou em conectar");
            }
        }
        System.out.println("Varredura concluída.");
    }
}
