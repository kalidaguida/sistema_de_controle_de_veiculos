import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
    private static List<Passeio> listaPasseio = new ArrayList<>();
    private static List<Carga> listaCarga = new ArrayList<>();
    private static Passeio passeio = new Passeio();
    private static Carga carga = new Carga();
    private static final Leitura leitura = Leitura.getLeituraUnico();

    public static List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public static List<Carga> getListaCarga() {
        return listaCarga;
    }

    public static void setListaPasseio(List<Passeio> setListaPasseio) {
        listaPasseio = setListaPasseio;
    }

    public static void setListaCarga(List<Carga> setListaCarga) {
        listaCarga = setListaCarga;
    }

    public static void validaPlaca(String placa) throws VeicExistException {

        for (Passeio ps : listaPasseio) {
            if (ps.getPlaca().equalsIgnoreCase(placa)) {
                throw new VeicExistException();
            }
        }

        for (Carga cg : listaCarga) {
            if (cg.getPlaca().equalsIgnoreCase(placa)) {
                throw new VeicExistException();
            }
        }
    }

    public static Passeio cadastrarPasseio(Passeio passeio) {

        System.out.println("\n--------------------------------------------------");
        System.out.println("Cadastro de Veiculos de Passeio");
        System.out.println("--------------------------------------------------");
        System.out.println("\nInsira os dados solicitados abaixo");

        passeio.setPlaca(leitura.entDados("Placa: "));

        while (passeio.getPlaca().isEmpty()){
            System.out.println("A placa não pode ser deixada em branco, digite novamente...\n");
            passeio.setPlaca(leitura.entDados("Placa: "));
        }
        passeio.setPlaca(passeio.getPlaca());

        try {
            validaPlaca(passeio.getPlaca());
        } catch (VeicExistException vee) {
            MenuOpcoes.iniciaMenu();
        }

        passeio.setMarca(leitura.entDados("Marca: "));
        passeio.setModelo(leitura.entDados("Modelo: "));
        passeio.setCor(leitura.entDados("Cor: "));

        try {
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

            getListaPasseio().add(passeio);

        } catch (NumberFormatException nfe) {
            System.out.println("\nPreenchimento inválido, o valor digitado deve ser um numero inteiro!");
            MenuOpcoes.iniciaMenu();
        }
        return passeio;
    }

    public static Carga cadastrarCarga(Carga carga) {

        System.out.println("\n--------------------------------------------------");
        System.out.println("Cadastro de Veiculos de Carga");
        System.out.println("--------------------------------------------------");
        System.out.println("\nInsira os dados solicitados abaixo");

        carga.setPlaca(leitura.entDados("Placa: "));

        while (carga.getPlaca().isEmpty()){
            System.out.println("A placa não pode ser deixada em branco, digite novamente...\n");
            carga.setPlaca(leitura.entDados("Placa: "));
        }
        carga.setPlaca(carga.getPlaca());

        try {
            validaPlaca(carga.getPlaca());
        } catch (VeicExistException ve) {
            MenuOpcoes.iniciaMenu();
        }

        carga.setMarca(leitura.entDados("Marca: "));
        carga.setModelo(leitura.entDados("Modelo: "));
        carga.setCor(leitura.entDados("Cor: "));

        try {
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

            getListaCarga().add(carga);

        } catch (NumberFormatException nfe) {
            System.out.println("\nPreenchimento inválido, o valor digitado deve ser um numero inteiro!");
            MenuOpcoes.iniciaMenu();
        }
        return carga;
    }

    public static void printPasseio(Passeio passeio) {
        passeio.printVeiculo();
    }

    public static void printCarga(Carga carga) {
        carga.printVeiculo();
    }

    public static void printAllPasseio() {
        System.out.println("--------------------------------------------------");
        System.out.println("Impressao de todos os veiculos de passeio");
        System.out.println("--------------------------------------------------");

        for (Passeio ps : getListaPasseio()) {
            printPasseio(ps);
        }
        System.out.println("Impresso todos os veiculos de passeio cadastrados!");
        System.out.println("*******************************************************");
    }

    public static void printAllCarga() {
        System.out.println("--------------------------------------------------");
        System.out.println("Impressao de todos os veiculos de carga");
        System.out.println("--------------------------------------------------");

        for (Carga cg : getListaCarga()) {
            printCarga(cg);
        }
        System.out.println("Impresso todos os veiculos de carga cadastrados!");
        System.out.println("*******************************************************");
    }

    public static void consulPlacaPasseio() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Consulta pela placa - Veiculos de passeio");
        System.out.println("--------------------------------------------------");

        boolean existePlacaPasseio = false;
        String placaPasseio = leitura.entDados("Informe a placa a ser pesquisada: ");
        passeio.setPlaca(placaPasseio);

        for (Passeio ps : getListaPasseio()) {
            if (ps.getPlaca().equalsIgnoreCase(placaPasseio)) {
                System.out.println("========== Veiculo de passeio placa: " + passeio.getPlaca() + "  ==========");
                printPasseio(ps);
                existePlacaPasseio = true;
                leitura.entDados("\nPressione <ENTER> para continuar...");
                break;
            }
        }
        if (!existePlacaPasseio) {
            System.out.println("\nNão existe veiculo de passeio cadastrado com esta placa");
        }
    }

    public static void consulPlacaCarga() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Consulta pela placa - Veiculos de carga");
        System.out.println("--------------------------------------------------");

        boolean existePlacaCarga = false;
        String placaCarga = leitura.entDados("Informe a placa a ser pesquisada: ");
        carga.setPlaca(placaCarga);

        for (Carga cg : getListaCarga()) {
            if (cg.getPlaca().equalsIgnoreCase(placaCarga)) {
                System.out.println("========== Veiculo de carga placa: " + carga.getPlaca() + "  ==========");
                printCarga(cg);
                existePlacaCarga = true;
                leitura.entDados("\nPressione <ENTER> para continuar...");
                break;
            }
        }
        if (!existePlacaCarga) {
            System.out.println("\nNão existe veiculo de carga cadastrado com esta placa");
        }
    }

    public static void excluiPlacaPasseio() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Excluir veiculo pela placa - Veiculo de Passeio");
        System.out.println("--------------------------------------------------");

        boolean existePlacaPasseio = false;

        String placaPasseio = leitura.entDados("Informe a placa a ser excluida: ");

        for (Passeio ps : getListaPasseio()) {
            if (ps.getPlaca().contains(placaPasseio)) {
                getListaPasseio().remove(ps);
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

        for (Carga cg : getListaCarga()) {
            if (cg.getPlaca().contains(placaCarga)) {
                getListaCarga().remove(cg);
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


