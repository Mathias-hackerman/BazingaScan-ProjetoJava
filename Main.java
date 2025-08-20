class Main {

  public static void main(String[] args) {
    //Definindo o alvo
    String ipAlvo = "127.0.0.1";

    //Construir Scanner usando a classe
    ScannerDeRede meuScanner = new ScannerDeRede(ipAlvo);

    //Executando método de escanear
    meuScanner.escanear(1, 100);
  }
}
