import java.net.Socket;
import java.net.InetSocketAddres;
import java.concurrent.Executors;
import java.concurrent.ExecutorsService;
import java.concurrent.TimeUnit;

// Classe do Scanner
class ScannerDeRede {
	// --- Atributo ---
    // Cada objeto ScannerDeRede terá seu próprio ipAlvo
    String ipAlvo;
    int timeout = 200; //Tempo máximo de tentativa
    int threads = 50; //Quantidade de processadores
    
    // --- MÉTODO CONSTRUTOR ---
    // Configurr o estado inicial do objeto
    public ScannerDeRede(String ip) {
    	this.ipAlvo = ip;
    }
    // --- MÉTODO DE AÇÃO --
    // A ação que nosso scanner sabe fazer
    public void escanear(int portaInicial, int portaFinal) {
    	System.out.println("Iniciando varredura no alvo" + this.ipAlvo + "...");
        
        //Criando pool com 50 processadores
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        
        for (int porta = portaInicial; porta <= portaFinal; porta ++) {
        	final int portaAtual = porta;
        	
        	executor.submit(() -> {
            	try {
                	//Tentativa de conexão com timeout
                	Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ipAlvo, portaAtual), timeout);
                    socket.close();
                    
                    // Se conectar, imprime o resultado
                    System.out.println("Porta " + porta + " está ABERTA");
                    
                } catch (Exception e) {
                	
                }
        	});
        }
        
        //Desligando o gerenciador de threads
        executor.shutdown();
        try {
            // Espera 10 minutos para as tarefas terminarem
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("A varredura foi interrompida");
        }
        System.out.println("Varredura concluída.");
    }
}
