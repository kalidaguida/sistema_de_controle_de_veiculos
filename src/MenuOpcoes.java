import java.text.Collator;

public class MenuOpcoes {
    private static Passeio passeio = new Passeio();
    private static Carga carga = new Carga();
    private static final Leitura leitura = Leitura.getLeituraUnico();

    public static void iniciaMenu() {
        boolean continua = true;
        int opcao;

        while (continua) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("Sistema de Gestão de Veículos - Menu Inicial");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Cadastrar Veiculo de Passeio");
            System.out.println("2. Cadastrar Veiculo de Carga");
            System.out.println("3. Imprimir Todos os Veiculos de Passeio");
            System.out.println("4. Imprimir Todos os Veiculos de Carga");
            System.out.println("5. Imprimir Veiculo de Passeio pela Placa");
            System.out.println("6. Imprimir Veiculo de Carga pela Placa");
            System.out.println("7. Excluir Veiculo de Passeio pela Placa");
            System.out.println("8. Excluir Veiculo de Carga pela Placa");
            System.out.println("9. Sair do Sistema");
            System.out.println("--------------------------------------------------");

            try {
                opcao = Integer.parseInt(leitura.entDados("\nEscolha uma opcao: "));
            } catch (NumberFormatException nfe) {
                System.out.println("A opcao informada deve ser um valor inteiro - Pressione <ENTER> para continuar...");
                leitura.entDados("");

                continue;
            }

            switch (opcao) {
                case 1 -> {
                    boolean sim = true;
                    passeio = new Passeio();
                    passeio = BDVeiculos.cadastrarPasseio(passeio);
                    System.out.println("\nVeiculo cadastrado!");

                    while (sim) {

                        String respostaPasseio = leitura.entDados("\nDeseja cadastrar outro veiculo de passeio? <SIM/NÃO>");
                        if (respostaPasseio.equalsIgnoreCase("SIM")) {
                            passeio = new Passeio();
                            passeio = BDVeiculos.cadastrarPasseio(passeio);
                            System.out.println("\nVeiculo cadastrado!");
                        } else if (ignoreAccent(respostaPasseio)) {
                            sim = false;
                        } else {
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Digite <sim> para continuar ou <não> para voltar ao menu...");
                            System.out.println("------------------------------------------------------------");
                        }
                    }
                }

                case 2 -> {
                    boolean sim = true;
                    carga = new Carga();
                    carga = BDVeiculos.cadastrarCarga(carga);
                    System.out.println("\nVeiculo cadastrado!");

                    while (sim) {
                        String respostaCarga = leitura.entDados("\nDeseja cadastrar outro veiculo de carga? <SIM/NÃO>");
                        if (respostaCarga.equalsIgnoreCase("SIM")) {
                            carga = new Carga();
                            carga = BDVeiculos.cadastrarCarga(carga);
                            System.out.println("\nVeiculo cadastrado!");
                        } else if (ignoreAccent(respostaCarga)) {
                            sim = false;
                        } else {
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Digite <sim> para continuar ou <não> para voltar ao menu...");
                            System.out.println("------------------------------------------------------------");
                        }
                    }
                }

                case 3 -> BDVeiculos.printAllPasseio();

                case 4 -> BDVeiculos.printAllCarga();

                case 5 -> BDVeiculos.consulPlacaPasseio();

                case 6 -> BDVeiculos.consulPlacaCarga();

                case 7 -> BDVeiculos.excluiPlacaPasseio();

                case 8 -> BDVeiculos.excluiPlacaCarga();

                case 9 -> System.exit(0);

                default -> leitura.entDados("\nO valor deve ser de 1 a 9. Pressione <ENTER> para continuar...");
            }
        }
    }

    public static boolean ignoreAccent(String s) {
        String a = s.toLowerCase();
        String b = "não";
        boolean isequal = false;

        final Collator instance = Collator.getInstance();
        instance.setStrength(Collator.PRIMARY);

        if (instance.compare(a, b) == 0) {
            isequal = true;
        }
        return isequal;
    }
}
