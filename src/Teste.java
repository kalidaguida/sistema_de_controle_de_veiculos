import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teste implements ActionListener {
    static JButton btPasseio = new JButton("Passeio");
    static JButton btCarga = new JButton("Carga");

    public static Teste t1 = new Teste();

    static JPanel panel = new JPanel(new GridLayout(4, 2));
    static JFrame janListarOpcoesPasseio = new JFrame("Lista de Opções Veículos de Passeio");
    static JLabel rtCadastrarPasseio = new JLabel("Cadastrar Veículo de Passeio");
    static JLabel rtConsultarExcluirPlacaPasseio = new JLabel("Consultar ou Excluir veículo de Passeio pela Placa   ");
    static JLabel rtImprimirExcluirTodosPasseio = new JLabel("Imprimir ou Excluir todos os veículos de Passeio");
    static JLabel rtSairPasseio = new JLabel("Sair");

    static JButton btCadastrarPasseio = new JButton("Cadastar");
    static JButton btConsultarExcluirPelaPlacaPasseio = new JButton("\nConsultar/Excluir");
    static JButton btImprimirExcluirTodosPasseio = new JButton("\nImprimir/Excluir");
    static JButton btSairListaOpcoesPasseio = new JButton("\nSair");

    static JPanel panel1 = new JPanel(new GridLayout(4, 2));
    static JFrame janListarOpcoesCarga = new JFrame("Opcoes veículos de Carga");
    static JLabel rtCadastrarCarga = new JLabel("Cadastrar Veículo de Carga");
    static JLabel rtConsultarExcluirPlacaCarga = new JLabel("Consultar ou Excluir veículo de Carga pela Placa   ");
    static JLabel rtImprimirExcluirTodosCarga = new JLabel("Imprimir ou Excluir todos os veículos de Carga");
    static JLabel rtSairCarga = new JLabel("Sair");

    static JButton btCadastrarCarga = new JButton("Cadastar");
    static JButton btConsultarExcluirPelaPlacaPCarga = new JButton("\nConsultar/Excluir");
    static JButton btImprimirExcluirTodosCarga = new JButton("\nImprimir/Excluir");
    static JButton btSairListaOpcoesCarga = new JButton("\nSair");

    public static JFrame janAcessarMenu = new JFrame("Gestão de Cadastro de Veículos");
    public static JLabel rtPasseio = new JLabel("Opções Veículos de Passeio");
    public static JLabel rtCarga = new JLabel("Opções Veículos de Carga");

    public static void main(String[] args) {

        iniciaJanela();
    }

    public static void iniciaJanela() {

        int larg = 400;
        int alt = 150;

        janAcessarMenu.setSize(larg, alt);

        janAcessarMenu.setDefaultCloseOperation(janAcessarMenu.EXIT_ON_CLOSE);

        janAcessarMenu.add(rtPasseio);
        janAcessarMenu.add(btPasseio);

        janAcessarMenu.add(rtCarga);
        janAcessarMenu.add(btCarga);

        janAcessarMenu.setLayout(new FlowLayout());
        janAcessarMenu.setVisible(true);

        btPasseio.addActionListener(t1);
        btCarga.addActionListener(t1);

    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(btPasseio)) {
            listarOpcoesPasseio();
        }
        if (evt.getSource().equals(btCarga)) {
            listarOpcoesCarga();
        }
    }

    private static ActionListener listarPasseioAction = e -> {
        if (e.getSource().equals(btCadastrarPasseio)) {
            BDVeiculos.janCadrastoPasseio();
        }
        if (e.getSource().equals(btConsultarExcluirPelaPlacaPasseio)) {
            BDVeiculos.janConsultarExcluirPasseio();
        }
        if (e.getSource().equals(btImprimirExcluirTodosPasseio)) {
            BDVeiculos.janImprimirExcluirPasseio();
        }
        if (e.getSource().equals(btSairListaOpcoesPasseio)) {
            janListarOpcoesPasseio.dispose();
            panel.removeAll();
        }
    };

    private static ActionListener listarCargaAction = e -> {
        if (e.getSource().equals(btCadastrarCarga)) {
            BDVeiculos.janCadrastoCarga();
        }
        if (e.getSource().equals(btConsultarExcluirPelaPlacaPCarga)) {
            BDVeiculos.janConsultarExcluirCarga();
        }
        if (e.getSource().equals(btImprimirExcluirTodosCarga)) {
            BDVeiculos.janImprimirExcluirCarga();
        }
        if (e.getSource().equals(btSairListaOpcoesCarga)) {
            janListarOpcoesCarga.dispose();
            panel1.removeAll();
        }
    };

    public static void listarOpcoesPasseio() {

        int larg = 700;
        int alt = 200;

        janListarOpcoesPasseio.setSize(larg, alt);
        janListarOpcoesPasseio.setDefaultCloseOperation(janListarOpcoesPasseio.EXIT_ON_CLOSE);

        panel.add(rtCadastrarPasseio);
        panel.add(btCadastrarPasseio);
        panel.add(rtConsultarExcluirPlacaPasseio);
        panel.add(btConsultarExcluirPelaPlacaPasseio);
        panel.add(rtImprimirExcluirTodosPasseio);
        panel.add(btImprimirExcluirTodosPasseio);
        panel.add(rtSairPasseio);
        panel.add(btSairListaOpcoesPasseio);

        janListarOpcoesPasseio.add(panel);
        janListarOpcoesPasseio.setLayout(new FlowLayout());
        janListarOpcoesPasseio.setVisible(true);

        btCadastrarPasseio.addActionListener(listarPasseioAction);

        btConsultarExcluirPelaPlacaPasseio.addActionListener(listarPasseioAction);

        btImprimirExcluirTodosPasseio.addActionListener(listarPasseioAction);

        btSairListaOpcoesPasseio.addActionListener(listarPasseioAction);
    }

    public static void listarOpcoesCarga() {

        int larg = 700;
        int alt = 200;

        janListarOpcoesCarga.setSize(larg, alt);
        janListarOpcoesCarga.setDefaultCloseOperation(janListarOpcoesCarga.EXIT_ON_CLOSE);

        panel1.add(rtCadastrarCarga);
        panel1.add(btCadastrarCarga);
        panel1.add(rtConsultarExcluirPlacaCarga);
        panel1.add(btConsultarExcluirPelaPlacaPCarga);
        panel1.add(rtImprimirExcluirTodosCarga);
        panel1.add(btImprimirExcluirTodosCarga);
        panel1.add(rtSairCarga);
        panel1.add(btSairListaOpcoesCarga);

        janListarOpcoesCarga.add(panel1);
        janListarOpcoesCarga.setLayout(new FlowLayout());
        janListarOpcoesCarga.setVisible(true);

        btCadastrarCarga.addActionListener(listarCargaAction);

        btConsultarExcluirPelaPlacaPCarga.addActionListener(listarCargaAction);

        btImprimirExcluirTodosCarga.addActionListener(listarCargaAction);

        btSairListaOpcoesCarga.addActionListener(listarCargaAction);
    }
}


