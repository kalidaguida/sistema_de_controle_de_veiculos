import java.text.Collator;
import java.util.Locale;

public class Teste {
    private static Passeio passeio = new Passeio();
    private static Carga carga = new Carga();
    private static final Leitura leitura = Leitura.getLeituraUnico();

    public static void main(String[] args) {

        iniciaMenu();
    }

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
                    passeio = cadastrarPasseio(passeio);
                    System.out.println("\nVeiculo cadastrado!");

                    while (sim) {
                        String respostaPasseio = leitura.entDados("Deseja cadastrar outro veiculo de passeio? <SIM/NÃO>");
                        if (respostaPasseio.equalsIgnoreCase("SIM")) {
                            passeio = new Passeio();
                            passeio = cadastrarPasseio(passeio);
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
                    carga = cadastrarCarga(carga);
                    System.out.println("\nVeiculo cadastrado!");

                    while (sim) {
                        String respostaCarga = leitura.entDados("\nDeseja cadastrar outro veiculo de carga? <SIM/NÃO>");
                        if (respostaCarga.equalsIgnoreCase("SIM")) {
                            carga = new Carga();
                            carga = cadastrarCarga(carga);
                        } else if (ignoreAccent(respostaCarga)) {
                            sim = false;
                        } else {
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Digite <sim> para continuar ou <não> para voltar ao menu...");
                            System.out.println("------------------------------------------------------------");
                        }
                    }
                }

                case 3 -> {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Impressao de todos os veiculos de passeio");
                    System.out.println("--------------------------------------------------");

                    for (int i = 0; i < BDVeiculos.getListaPasseio().size(); i++) {
                        printPasseio(BDVeiculos.getListaPasseio().get(i));

                    }
                    System.out.println("Impresso todos os veiculos de passeio cadastrados!");
                    System.out.println("*******************************************************");
                }

                case 4 -> {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Impressao de todos os veiculos de carga");
                    System.out.println("--------------------------------------------------");

                    for (int i = 0; i < BDVeiculos.getListaCarga().size(); i++) {
                        printCarga(BDVeiculos.getListaCarga().get(i));
                    }
                    System.out.println("Impresso todos os veiculos de carga cadastrados!");
                    System.out.println("*******************************************************");
                }

                case 5 -> {
                    System.out.println("\n--------------------------------------------------");
                    System.out.println("Consulta pela placa - Veiculos de passeio");
                    System.out.println("--------------------------------------------------");

                    passeio = new Passeio();

                    boolean existePlacaPasseio = false;

                    String placaPasseio = leitura.entDados("Informe a placa a ser pesquisada: ");

                    passeio.setPlaca(placaPasseio);

                    for (int i = 0; i < BDVeiculos.getListaPasseio().size(); i++) {
                        if (BDVeiculos.getListaPasseio().get(i).getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
                            System.out.println("========== Veiculo de passeio placa: " + passeio.getPlaca() + "  ==========");
                            printPasseio(BDVeiculos.getListaPasseio().get(i));
                            existePlacaPasseio = true;
                            leitura.entDados("\nPressione <ENTER> para continuar...");
                            break;
                        }
                    }
                    if (!existePlacaPasseio) {
                        System.out.println("\nNão existe veiculo de passeio cadastrado com esta placa");
                    }
                }
                case 6 -> {
                    System.out.println("\n--------------------------------------------------");
                    System.out.println("Consulta pela placa - Veiculos de carga");
                    System.out.println("--------------------------------------------------");

                    carga = new Carga();

                    boolean existePlacaCarga = false;

                    String placaCarga = leitura.entDados("Informe a placa a ser pesquisada: ");

                    carga.setPlaca(placaCarga);

                    for (int i = 0; i < BDVeiculos.getListaCarga().size(); i++) {
                        if (BDVeiculos.getListaCarga().get(i).getPlaca().equalsIgnoreCase(carga.getPlaca())) {
                            System.out.println("========== Veiculo de carga placa: " + carga.getPlaca() + "  ==========");
                            printCarga(BDVeiculos.getListaCarga().get(i));
                            existePlacaCarga = true;
                            leitura.entDados("\nPressione <ENTER> para continuar...");
                            break;
                        }
                    }
                    if (!existePlacaCarga) {
                        System.out.println("\nNão existe veiculo de carga cadastrado com esta placa");
                    }
                }
                case 7 -> excluiPlacaPasseio();

                case 8 -> excluiPlacaCarga();

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

    public static Passeio cadastrarPasseio(Passeio passeio) {

        System.out.println("\n--------------------------------------------------");
        System.out.println("Cadastro de Veiculos de Passeio");
        System.out.println("--------------------------------------------------");
        System.out.println("\nInsira os dados solicitados abaixo");

        passeio.setPlaca(leitura.entDados("Placa: "));

        try {
            BDVeiculos.validaPlaca(passeio.getPlaca());
        } catch (VeicExistException vee) {
            iniciaMenu();
        }

        passeio.setMarca(leitura.entDados("Marca: "));
        passeio.setModelo(leitura.entDados("Modelo: "));
        passeio.setCor(leitura.entDados("Cor: "));
        passeio.setQtdRodas(Integer.parseInt(leitura.entDados("Quantidade de rodas: ")));

        try {
            passeio.setVelocMax(Integer.parseInt(leitura.entDados("Velocidade Maxima: ")));
        } catch (VelocException ve) {
            ve.impMsgVelocMax();
            ve.correcaoVelocMax(passeio);
        }

        passeio.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantidade de Pistoes do motor: ")));
        passeio.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potencia do motor: ")));
        passeio.setQtdPassageiros(Integer.parseInt(leitura.entDados("Quantidade de Passageiros: ")));

        BDVeiculos.getListaPasseio().add(passeio);

        return passeio;


    }

    public static Carga cadastrarCarga(Carga carga) {

        System.out.println("\n--------------------------------------------------");
        System.out.println("Cadastro de Veiculos de Carga");
        System.out.println("--------------------------------------------------");
        System.out.println("\nInsira os dados solicitados abaixo");

        carga.setPlaca(leitura.entDados("Placa: "));

        try {
            BDVeiculos.validaPlaca(carga.getPlaca());
        } catch (VeicExistException ve) {
            iniciaMenu();
        }

        carga.setMarca(leitura.entDados("Marca: "));
        carga.setModelo(leitura.entDados("Modelo: "));
        carga.setCor(leitura.entDados("Cor: "));
        carga.setQtdRodas(Integer.parseInt(leitura.entDados("Quantidade de rodas: ")));

        try {
            carga.setVelocMax(Integer.parseInt(leitura.entDados("Velocidade Maxima: ")));
        } catch (VelocException ve) {
            ve.impMsgVelocMax();
            ve.correcaoVelocMax(carga);
        }

        carga.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantidade de Pistoes do motor: ")));
        carga.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potencia do motor: ")));
        carga.setTara(Integer.parseInt(leitura.entDados("Tara: ")));
        carga.setCargaMax(Integer.parseInt(leitura.entDados("Carga Maxima: ")));

        BDVeiculos.getListaCarga().add(carga);

        return carga;
    }

    public static void printPasseio(Passeio passeio) {
        passeio.printVeiculo();
    }

    public static void printCarga(Carga carga) {
        carga.printVeiculo();
    }

    public static void excluiPlacaPasseio() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Excluir veiculo pela placa - Veiculo de Passeio");
        System.out.println("--------------------------------------------------");

        boolean existePlacaPasseio = false;

        String placaPasseio = leitura.entDados("Informe a placa a ser excluida: ");

        for (Passeio ps : BDVeiculos.getListaPasseio()) {
            if (ps.getPlaca().contains(placaPasseio)) {
                BDVeiculos.getListaPasseio().remove(ps);
                existePlacaPasseio = true;
                System.out.println("========== Veiculo de passeio excluido com sucesso! ==========");
                break;
            }
        }
        if (!existePlacaPasseio) {
            System.out.println("\nNão existe veiculo de passeio cadastrado com esta placa");
        }
    }

    public static void excluiPlacaCarga() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Excluir veiculo pela placa - Veiculo de Carga");
        System.out.println("--------------------------------------------------");

        boolean existePlacaCarga = false;

        String placaCarga = leitura.entDados("Informe a placa a ser excluida: ");

        for (Carga cg : BDVeiculos.getListaCarga()) {
            if (cg.getPlaca().contains(placaCarga)) {
                BDVeiculos.getListaCarga().remove(cg);
                System.out.println("========== Veiculo de carga excluido com sucesso! ==========");
                existePlacaCarga = true;
                break;
            }
        }
        if (!existePlacaCarga) {
            System.out.println("\nNão existe veiculo de carga cadastrado com esta placa");
        }
    }
}





