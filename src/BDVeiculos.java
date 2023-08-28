import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
    private static List<Passeio> listaPasseio = new ArrayList<>();
    private static List<Carga> listaCarga = new ArrayList<>();
    private static Passeio passeio = new Passeio();
    private static Carga carga = new Carga();

    private static String[] tabelaPasseio = {"Placa", "Marca", "Modelo", "Cor", "Qtd de Rodas", "Velocidade Máxima", "Qtd de Pistões", "Potência", "Qtd de Passageiros"};
    private static String[] tabelaCarga = {"Placa", "Marca", "Modelo", "Cor", "Qtd de Rodas", "Velocidade Máxima", "Qtd de Pistões", "Potência", "Tara", "Carga Máxima"};
    private static DefaultTableModel modelPasseio = new DefaultTableModel(tabelaPasseio, 0);
    private static DefaultTableModel modelCarga = new DefaultTableModel(tabelaCarga, 0);
    private static JTable tableDadosPasseio = new JTable(modelPasseio);
    private static JTable tableDadosCarga = new JTable(modelCarga);
    private static JScrollPane barraRolagemListaPasseio = new JScrollPane(tableDadosPasseio);
    private static JScrollPane barraRolagemListaCarga = new JScrollPane(tableDadosCarga);

    private static JPanel panelBotoesCadPasseio = new JPanel(new GridLayout(1, 4));
    private static JPanel panelBotoesCadCarga = new JPanel(new GridLayout(1, 4));
    private static JPanel panelBotoesConsulExcPasseio = new JPanel(new GridLayout(1, 3));
    private static JPanel panelBotoesConsulExcCarga = new JPanel(new GridLayout(1, 3));
    private static JPanel panelBotoesImpExcPasseio = new JPanel(new GridLayout(1, 3));
    private static JPanel panelBotoesImpExcCarga = new JPanel(new GridLayout(1, 3));
    private static JPanel panelPasseio = new JPanel(new GridLayout(9, 2));
    private static JPanel panelCarga = new JPanel(new GridLayout(10, 2));
    private static JPanel panelConsultaPasseio = new JPanel(new GridLayout(9, 2));
    private static JPanel panelConsultaCarga = new JPanel(new GridLayout(10, 2));

    private static JFrame janCadastroPasseio = new JFrame("Cadastro de Veículos de Passeio");
    private static JFrame janCadastroCarga = new JFrame("Cadastro de Veículos de Carga");
    private static JFrame janConsultarExcluirPasseio = new JFrame("Consultar ou excluir veículo pela placa");
    private static JFrame janConsultarExcluirCarga = new JFrame("Consultar ou excluir veículo pela placa");
    private static JFrame janImprimirExcluirPasseio = new JFrame("Imprimir/Excluir todos os veículos");
    private static JFrame janImprimirExcluirCarga = new JFrame("Imprimir/Excluir todos os veículos");

    private static JLabel rtPlaca = new JLabel("Placa:");
    private static JLabel rtConsultaPlaca = new JLabel("Informe a placa:");
    private static JLabel rtMarca = new JLabel("Marca:");
    private static JLabel rtModelo = new JLabel("Modelo:");
    private static JLabel rtCor = new JLabel("Cor:");
    private static JLabel rtQtdRodas = new JLabel("* Quantidade de rodas:");
    private static JLabel rtVeloxMax = new JLabel("* Velocidade Máxima:");
    private static JLabel rtQtdPist = new JLabel("* Quantidade de Pistões do motor:");
    private static JLabel rtPotencia = new JLabel("* Potência do motor:");
    private static JLabel rtQtdPassageiros = new JLabel("* Quantidade de Passageiros:");
    private static JLabel rtTara = new JLabel("* Tara:");
    private static JLabel rtCargaMax = new JLabel("* Carga Máxima:");

    private static int larg = 550;
    private static int alt = 300;
    private static int larg1 = 900;
    private static int alt1 = 600;

    private static JButton btCadastrarPasseio = new JButton("\nCadastrar");
    private static JButton btCadastrarCarga = new JButton("\nCadastrar");
    private static JButton btLimparPasseio = new JButton("\nLimpar");
    private static JButton btLimparCarga = new JButton("\nLimpar");
    private static JButton btNovoCadastroPasseio = new JButton("\nNovo Cadastro");
    private static JButton btNovoCadastroCarga = new JButton("\nNovo Cadastro");
    private static JButton btConsultarPasseio = new JButton("\nConsultar");
    private static JButton btConsultarCarga = new JButton("\nConsultar");
    private static JButton btImprimirTodosPasseio = new JButton("Imprimir Todos");
    private static JButton btImprimirTodosCarga = new JButton("Imprimir Todos");
    private static JButton btExcluirTodosPasseio = new JButton("Excluir Todos");
    private static JButton btExcluirTodosCarga = new JButton("Excluir Todos");
    private static JButton btExcluirPasseio = new JButton("\nExcluir");
    private static JButton btExcluirCarga = new JButton("\nExcluir");
    private static JButton btSairCadPasseio = new JButton("\nSair");
    private static JButton btSairConsulPasseio = new JButton("\nSair");
    private static JButton btSairImpPasseio = new JButton("\nSair");
    private static JButton btSairCadCarga = new JButton("\nSair");
    private static JButton btSairConsulCarga = new JButton("\nSair");
    private static JButton btSairImpCarga = new JButton("\nSair");

    private static JTextField cxPlacaCadPasseio = new JTextField(25);
    private static JTextField cxPlacaCadCarga = new JTextField(25);
    private static JTextField cxConsultaPlacaPasseio = new JTextField(25);
    private static JTextField cxConsultaPlacaCarga = new JTextField(25);
    private static JTextField cxMarcaCadPasseio = new JTextField(25);
    private static JTextField cxMarcaCadCarga = new JTextField(25);
    private static JTextField cxMarcaConsulPasseio = new JTextField(25);
    private static JTextField cxMarcaConsulCarga = new JTextField(25);
    private static JTextField cxModeloCadPasseio = new JTextField(25);
    private static JTextField cxModeloCadCarga = new JTextField(25);
    private static JTextField cxModeloConsulPasseio = new JTextField(25);
    private static JTextField cxModeloConsulCarga = new JTextField(25);
    private static JTextField cxCorCadPasseio = new JTextField(25);
    private static JTextField cxCorCadCarga = new JTextField(25);
    private static JTextField cxCorConsulPasseio = new JTextField(25);
    private static JTextField cxCorConsulCarga = new JTextField(25);
    private static JTextField cxQtdRodasCadPasseio = new JTextField(25);
    private static JTextField cxQtdRodasCadCarga = new JTextField(25);
    private static JTextField cxQtdRodasConsulPasseio = new JTextField(25);
    private static JTextField cxQtdRodasConsulCarga = new JTextField(25);
    private static JTextField cxVeloxMaxCadPasseio = new JTextField(25);
    private static JTextField cxVeloxMaxCadCarga = new JTextField(25);
    private static JTextField cxVeloxMaxConsulPasseio = new JTextField(25);
    private static JTextField cxVeloxMaxConsulCarga = new JTextField(25);
    private static JTextField cxQtdPistCadPasseio = new JTextField(25);
    private static JTextField cxQtdPistCadCarga = new JTextField(25);
    private static JTextField cxQtdPistConsulPasseio = new JTextField(25);
    private static JTextField cxQtdPistConsulCarga = new JTextField(25);
    private static JTextField cxPotenciaCadPasseio = new JTextField(25);
    private static JTextField cxPotenciaCadCarga = new JTextField(25);
    private static JTextField cxPotenciaConsulPasseio = new JTextField(25);
    private static JTextField cxPotenciaConsulCarga = new JTextField(25);
    private static JTextField cxQtdPassageirosCadPasseio = new JTextField(25);
    private static JTextField cxQtdPassageirosConsulPasseio = new JTextField(25);
    private static JTextField cxTaraCadCarga = new JTextField(25);
    private static JTextField cxTaraConsulCarga = new JTextField(25);
    private static JTextField cxCargaMaxCadCarga = new JTextField(25);
    private static JTextField cxCargaMaxConsulCarga = new JTextField(25);


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

    public static void janCadrastoPasseio() {

        janCadastroPasseio.setSize(larg, alt);
        janCadastroPasseio.setDefaultCloseOperation(janCadastroPasseio.EXIT_ON_CLOSE);

        panelPasseio.add(rtPlaca);
        panelPasseio.add(cxPlacaCadPasseio);
        panelPasseio.add(rtMarca);
        panelPasseio.add(cxMarcaCadPasseio);
        panelPasseio.add(rtModelo);
        panelPasseio.add(cxModeloCadPasseio);
        panelPasseio.add(rtCor);
        panelPasseio.add(cxCorCadPasseio);
        panelPasseio.add(rtQtdRodas);
        panelPasseio.add(cxQtdRodasCadPasseio);
        panelPasseio.add(rtVeloxMax);
        panelPasseio.add(cxVeloxMaxCadPasseio);
        panelPasseio.add(rtQtdPist);
        panelPasseio.add(cxQtdPistCadPasseio);
        panelPasseio.add(rtPotencia);
        panelPasseio.add(cxPotenciaCadPasseio);
        panelPasseio.add(rtQtdPassageiros);
        panelPasseio.add(cxQtdPassageirosCadPasseio);

        panelBotoesCadPasseio.add(btCadastrarPasseio);
        panelBotoesCadPasseio.add(btLimparPasseio);
        panelBotoesCadPasseio.add(btNovoCadastroPasseio);
        panelBotoesCadPasseio.add(btSairCadPasseio);

        janCadastroPasseio.add(panelPasseio);
        janCadastroPasseio.add(panelBotoesCadPasseio);
        janCadastroPasseio.setLayout(new FlowLayout());
        janCadastroPasseio.setVisible(true);

        btCadastrarPasseio.addActionListener(
                evt -> {
                    passeio = new Passeio();
                    boolean cadastroRealizado = cadastrarPasseio(passeio);
                    if (cadastroRealizado) {
                        getListaPasseio().add(passeio);
                        JOptionPane.showMessageDialog(
                                null,
                                "Cadastro realizado com sucesso!",
                                "Cadastro",
                                JOptionPane.INFORMATION_MESSAGE);
                        limpar();
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Cadastro não realizado, tente novamente!",
                                "Erro Cadastro",
                                JOptionPane.INFORMATION_MESSAGE);
                        limpar();
                    }
                }
        );

        btLimparPasseio.addActionListener(
                evt -> limpar()
        );

        btNovoCadastroPasseio.addActionListener(
                evt -> {
                    passeio = new Passeio();
                    boolean cadastroRealizado = cadastrarPasseio(passeio);
                    if (cadastroRealizado) {
                        getListaPasseio().add(passeio);
                        JOptionPane.showMessageDialog(
                                null,
                                "Cadastro realizado com sucesso!",
                                "Cadastro",
                                JOptionPane.INFORMATION_MESSAGE);
                        limpar();
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Cadastro não realizado, tente novamente!",
                                "Erro Cadastro",
                                JOptionPane.INFORMATION_MESSAGE);
                        limpar();
                    }
                }
        );

        btSairCadPasseio.addActionListener(
                evt -> {
                    janCadastroPasseio.dispose();
                    panelPasseio.removeAll();
                }
        );
    }

    public static void janCadrastoCarga() {

        janCadastroCarga.setSize(larg, alt);
        janCadastroCarga.setDefaultCloseOperation(janCadastroCarga.EXIT_ON_CLOSE);

        panelCarga.add(rtPlaca);
        panelCarga.add(cxPlacaCadCarga);
        panelCarga.add(rtMarca);
        panelCarga.add(cxMarcaCadCarga);
        panelCarga.add(rtModelo);
        panelCarga.add(cxModeloCadCarga);
        panelCarga.add(rtCor);
        panelCarga.add(cxCorCadCarga);
        panelCarga.add(rtQtdRodas);
        panelCarga.add(cxQtdRodasCadCarga);
        panelCarga.add(rtVeloxMax);
        panelCarga.add(cxVeloxMaxCadCarga);
        panelCarga.add(rtQtdPist);
        panelCarga.add(cxQtdPistCadCarga);
        panelCarga.add(rtPotencia);
        panelCarga.add(cxPotenciaCadCarga);
        panelCarga.add(rtTara);
        panelCarga.add(cxTaraCadCarga);
        panelCarga.add(rtCargaMax);
        panelCarga.add(cxCargaMaxCadCarga);

        panelBotoesCadCarga.add(btCadastrarCarga);
        panelBotoesCadCarga.add(btLimparCarga);
        panelBotoesCadCarga.add(btNovoCadastroCarga);
        panelBotoesCadCarga.add(btSairCadCarga);

        janCadastroCarga.add(panelCarga);
        janCadastroCarga.add(panelBotoesCadCarga);
        janCadastroCarga.setLayout(new FlowLayout());
        janCadastroCarga.setVisible(true);

        btCadastrarCarga.addActionListener(
                evt -> {
                    carga = new Carga();
                    boolean cadastroRealizado = cadastrarCarga(carga);
                    if (cadastroRealizado) {
                        getListaCarga().add(carga);
                        JOptionPane.showMessageDialog(
                                null,
                                "Cadastro realizado com sucesso!",
                                "Cadastro",
                                JOptionPane.INFORMATION_MESSAGE);
                        limpar();
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Cadastro não realizado, tente novamente!",
                                "Erro Cadastro",
                                JOptionPane.INFORMATION_MESSAGE);
                        limpar();
                    }
                }
        );

        btLimparCarga.addActionListener(
                evt -> limpar()
        );

        btNovoCadastroCarga.addActionListener(
                evt -> {
                    carga = new Carga();
                    boolean cadastroRealizado = cadastrarCarga(carga);
                    if (cadastroRealizado) {
                        getListaCarga().add(carga);
                        JOptionPane.showMessageDialog(
                                null,
                                "Cadastro realizado com sucesso!",
                                "Cadastro",
                                JOptionPane.INFORMATION_MESSAGE);
                        limpar();
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Cadastro não realizado, tente novamente!",
                                "Erro Cadastro",
                                JOptionPane.INFORMATION_MESSAGE);
                        limpar();
                    }
                }
        );

        btSairCadCarga.addActionListener(
                evt -> {
                    janCadastroCarga.dispose();
                    panelCarga.removeAll();
                }
        );
    }

    public static void janConsultarExcluirPasseio() {

        janConsultarExcluirPasseio.setSize(larg, alt);
        janConsultarExcluirPasseio.setDefaultCloseOperation(janConsultarExcluirPasseio.EXIT_ON_CLOSE);

        rtConsultaPlaca.setForeground(Color.RED);
        cxConsultaPlacaPasseio.setBackground(Color.YELLOW);

        panelConsultaPasseio.add(rtConsultaPlaca);
        panelConsultaPasseio.add(cxConsultaPlacaPasseio);
        panelConsultaPasseio.add(rtMarca);
        panelConsultaPasseio.add(cxMarcaConsulPasseio);
        panelConsultaPasseio.add(rtModelo);
        panelConsultaPasseio.add(cxModeloConsulPasseio);
        panelConsultaPasseio.add(rtCor);
        panelConsultaPasseio.add(cxCorConsulPasseio);
        panelConsultaPasseio.add(rtQtdRodas);
        panelConsultaPasseio.add(cxQtdRodasConsulPasseio);
        panelConsultaPasseio.add(rtVeloxMax);
        panelConsultaPasseio.add(cxVeloxMaxConsulPasseio);
        panelConsultaPasseio.add(rtQtdPist);
        panelConsultaPasseio.add(cxQtdPistConsulPasseio);
        panelConsultaPasseio.add(rtPotencia);
        panelConsultaPasseio.add(cxPotenciaConsulPasseio);
        panelConsultaPasseio.add(rtQtdPassageiros);
        panelConsultaPasseio.add(cxQtdPassageirosConsulPasseio);

        panelBotoesConsulExcPasseio.add(btConsultarPasseio);
        panelBotoesConsulExcPasseio.add(btExcluirPasseio);
        panelBotoesConsulExcPasseio.add(btSairConsulPasseio);

        janConsultarExcluirPasseio.add(panelConsultaPasseio);
        janConsultarExcluirPasseio.add(panelBotoesConsulExcPasseio);
        janConsultarExcluirPasseio.setLayout(new FlowLayout());
        janConsultarExcluirPasseio.setVisible(true);

        btConsultarPasseio.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        consulPlacaPasseio();
                    }
                }
        );

        btExcluirPasseio.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        excluiPlacaPasseio();
                    }
                }
        );

        btSairConsulPasseio.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        janConsultarExcluirPasseio.dispose();
                        panelConsultaPasseio.removeAll();
                    }
                }
        );
    }

    public static void janConsultarExcluirCarga() {

        janConsultarExcluirCarga.setSize(larg, alt);
        janConsultarExcluirCarga.setDefaultCloseOperation(janConsultarExcluirCarga.EXIT_ON_CLOSE);

        rtConsultaPlaca.setForeground(Color.RED);
        cxConsultaPlacaCarga.setBackground(Color.YELLOW);

        panelConsultaCarga.add(rtConsultaPlaca);
        panelConsultaCarga.add(cxConsultaPlacaCarga);
        panelConsultaCarga.add(rtMarca);
        panelConsultaCarga.add(cxMarcaConsulCarga);
        panelConsultaCarga.add(rtModelo);
        panelConsultaCarga.add(cxModeloConsulCarga);
        panelConsultaCarga.add(rtCor);
        panelConsultaCarga.add(cxCorConsulCarga);
        panelConsultaCarga.add(rtQtdRodas);
        panelConsultaCarga.add(cxQtdRodasConsulCarga);
        panelConsultaCarga.add(rtVeloxMax);
        panelConsultaCarga.add(cxVeloxMaxConsulCarga);
        panelConsultaCarga.add(rtQtdPist);
        panelConsultaCarga.add(cxQtdPistConsulCarga);
        panelConsultaCarga.add(rtPotencia);
        panelConsultaCarga.add(cxPotenciaConsulCarga);
        panelConsultaCarga.add(rtTara);
        panelConsultaCarga.add(cxTaraConsulCarga);
        panelConsultaCarga.add(rtCargaMax);
        panelConsultaCarga.add(cxCargaMaxConsulCarga);

        panelBotoesConsulExcCarga.add(btConsultarCarga);
        panelBotoesConsulExcCarga.add(btExcluirCarga);
        panelBotoesConsulExcCarga.add(btSairConsulCarga);

        janConsultarExcluirCarga.add(panelConsultaCarga);
        janConsultarExcluirCarga.add(panelBotoesConsulExcCarga);
        janConsultarExcluirCarga.setLayout(new FlowLayout());
        janConsultarExcluirCarga.setVisible(true);

        btConsultarCarga.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        consulPlacaCarga();
                    }
                }
        );

        btExcluirCarga.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        excluiPlacaCarga();
                    }
                }
        );

        btSairConsulCarga.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        janConsultarExcluirCarga.dispose();
                        panelConsultaCarga.removeAll();
                    }
                }
        );
    }

    public static void janImprimirExcluirPasseio() {

        janImprimirExcluirPasseio.setSize(larg1, alt1);
        janImprimirExcluirPasseio.setDefaultCloseOperation(janImprimirExcluirPasseio.EXIT_ON_CLOSE);
        janImprimirExcluirPasseio.setLayout(new GridLayout(2, 1, 1, 1));

        janImprimirExcluirPasseio.add(barraRolagemListaPasseio);

        panelBotoesImpExcPasseio.add(btImprimirTodosPasseio);
        panelBotoesImpExcPasseio.add(btExcluirTodosPasseio);
        panelBotoesImpExcPasseio.add(btSairImpPasseio);

        janImprimirExcluirPasseio.add(panelBotoesImpExcPasseio);
        janImprimirExcluirPasseio.setVisible(true);

        btImprimirTodosPasseio.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        printAllPasseio();
                    }
                }
        );

        btExcluirTodosPasseio.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (excluirTodosPasseio()) {
                            JOptionPane.showMessageDialog(null,
                                    "Dados removidos com sucesso!",
                                    "Remover Dados",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            DefaultTableModel model = new DefaultTableModel(tabelaPasseio, 0);
                            tableDadosPasseio.setModel(model);
                        }
                    }
                }
        );

        btSairImpPasseio.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        janImprimirExcluirPasseio.dispose();
                    }
                }
        );
    }

    public static void janImprimirExcluirCarga() {

        janImprimirExcluirCarga.setSize(larg1, alt1);
        janImprimirExcluirCarga.setDefaultCloseOperation(janImprimirExcluirCarga.EXIT_ON_CLOSE);
        janImprimirExcluirCarga.setLayout(new GridLayout(2, 1, 1, 1));

        janImprimirExcluirCarga.add(barraRolagemListaCarga);

        panelBotoesImpExcCarga.add(btImprimirTodosCarga);
        panelBotoesImpExcCarga.add(btExcluirTodosCarga);
        panelBotoesImpExcCarga.add(btSairImpCarga);

        janImprimirExcluirCarga.add(panelBotoesImpExcCarga);
        janImprimirExcluirCarga.setVisible(true);

        btImprimirTodosCarga.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        printAllCarga();
                    }
                }
        );

        btExcluirTodosCarga.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (excluirTodosCarga()) {
                            JOptionPane.showMessageDialog(null,
                                    "Dados removidos com sucesso!",
                                    "Remover Dados",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            DefaultTableModel model = new DefaultTableModel(tabelaCarga, 0);
                            tableDadosCarga.setModel(model);
                        }
                    }
                }
        );

        btSairImpCarga.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        janImprimirExcluirCarga.dispose();
                    }
                }
        );
    }


    public static void limpar() {
        cxPlacaCadPasseio.setText("");
        cxPlacaCadCarga.setText("");
        cxConsultaPlacaPasseio.setText("");
        cxConsultaPlacaCarga.setText("");
        cxMarcaCadPasseio.setText("");
        cxMarcaCadCarga.setText("");
        cxMarcaConsulPasseio.setText("");
        cxMarcaConsulCarga.setText("");
        cxModeloCadPasseio.setText("");
        cxModeloCadCarga.setText("");
        cxModeloConsulPasseio.setText("");
        cxModeloConsulCarga.setText("");
        cxCorCadPasseio.setText("");
        cxCorCadCarga.setText("");
        cxCorConsulPasseio.setText("");
        cxCorConsulCarga.setText("");
        cxQtdRodasCadPasseio.setText("");
        cxQtdRodasCadCarga.setText("");
        cxQtdRodasConsulPasseio.setText("");
        cxQtdRodasConsulCarga.setText("");
        cxVeloxMaxCadPasseio.setText("");
        cxVeloxMaxCadCarga.setText("");
        cxVeloxMaxConsulPasseio.setText("");
        cxVeloxMaxConsulCarga.setText("");
        cxQtdPistCadPasseio.setText("");
        cxQtdPistCadCarga.setText("");
        cxQtdPistConsulPasseio.setText("");
        cxQtdPistConsulCarga.setText("");
        cxPotenciaCadPasseio.setText("");
        cxPotenciaCadCarga.setText("");
        cxPotenciaConsulPasseio.setText("");
        cxPotenciaConsulCarga.setText("");
        cxQtdPassageirosCadPasseio.setText("");
        cxQtdPassageirosConsulPasseio.setText("");
        cxTaraCadCarga.setText("");
        cxTaraConsulCarga.setText("");
        cxCargaMaxCadCarga.setText("");
        cxCargaMaxConsulCarga.setText("");
        cxPlacaCadPasseio.requestFocus();
        cxPlacaCadCarga.requestFocus();
        cxConsultaPlacaPasseio.requestFocus();
        cxConsultaPlacaCarga.requestFocus();
    }

    public static boolean cadastrarPasseio(Passeio passeio) {

        passeio.setPlaca(cxPlacaCadPasseio.getText());

        if (passeio.getPlaca().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "A placa não pode ser deixada em branco, digite novamente...\n",
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        try {
            validaPlaca(passeio.getPlaca());
        } catch (VeicExistException vee) {
            vee.impVeicExistException();
            return false;
        }
        passeio.setMarca(cxMarcaCadPasseio.getText());
        passeio.setModelo(cxModeloCadPasseio.getText());
        passeio.setCor(cxCorCadPasseio.getText());

        try {
            passeio.setQtdRodas(Integer.parseInt(cxQtdRodasCadPasseio.getText()));

            try {
                passeio.setVelocMax(Integer.parseInt(cxVeloxMaxCadPasseio.getText()));
            } catch (VelocException ve) {
                ve.impMsgVelocMax();
                ve.correcaoVelocMax(passeio);
            }

            passeio.getMotor().setQtdPist(Integer.parseInt(cxQtdPistCadPasseio.getText()));
            passeio.getMotor().setPotencia(Integer.parseInt(cxPotenciaCadPasseio.getText()));
            passeio.setQtdPassageiros(Integer.parseInt(cxQtdPassageirosCadPasseio.getText()));

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
                    null,
                    "Os campos com * não podem ficar em branco e devem ser preenchidos com números inteiros!",
                    "Preenchimento inválido",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }


    public static boolean cadastrarCarga(Carga carga) {

        carga.setPlaca(cxPlacaCadCarga.getText());

        if (carga.getPlaca().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "A placa não pode ser deixada em branco, digite novamente...\n",
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        try {
            validaPlaca(carga.getPlaca());
        } catch (VeicExistException vee) {
            vee.impVeicExistException();
            return false;
        }
        carga.setMarca(cxMarcaCadCarga.getText());
        carga.setModelo(cxModeloCadCarga.getText());
        carga.setCor(cxCorCadCarga.getText());

        try {
            carga.setQtdRodas(Integer.parseInt(cxQtdRodasCadCarga.getText()));

            try {
                carga.setVelocMax(Integer.parseInt(cxVeloxMaxCadCarga.getText()));
            } catch (VelocException ve) {
                ve.impMsgVelocMax();
                ve.correcaoVelocMax(carga);
            }

            carga.getMotor().setQtdPist(Integer.parseInt(cxQtdPistCadCarga.getText()));
            carga.getMotor().setPotencia(Integer.parseInt(cxPotenciaCadCarga.getText()));
            carga.setTara(Integer.parseInt(cxTaraCadCarga.getText()));
            carga.setCargaMax(Integer.parseInt(cxCargaMaxCadCarga.getText()));

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
                    null,
                    "Os campos com * não podem ficar em branco e devem ser preenchidos com números inteiros!",
                    "Preenchimento inválido",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }

    public static void printAllPasseio() {

        if (getListaPasseio().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há nenhum veículo de passeio cadastrado.", "ERRO IMPRIMIR", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Passeio ps : getListaPasseio()) {
                String[] dadosPasseio = {ps.getPlaca(), ps.getMarca(), ps.getModelo(), ps.getCor(), String.valueOf(ps.getQtdRodas()),
                        String.valueOf(ps.getVelocMax()), String.valueOf(ps.getMotor().getQtdPist()), String.valueOf(ps.getMotor().getPotencia()),
                        String.valueOf(ps.getQtdPassageiros())};
                modelPasseio.addRow(dadosPasseio);
            }
            tableDadosPasseio.setModel(modelPasseio);
        }
    }

    public static void printAllCarga() {

        if (getListaCarga().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há nenhum veículo de carga cadastrado.", "ERRO IMPRIMIR", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Carga cg : getListaCarga()) {
                String[] dadosCarga = {cg.getPlaca(), cg.getMarca(), cg.getModelo(), cg.getCor(), String.valueOf(cg.getQtdRodas()),
                        String.valueOf(cg.getVelocMax()), String.valueOf(cg.getMotor().getQtdPist()), String.valueOf(cg.getMotor().getPotencia()),
                        String.valueOf(cg.getTara()), String.valueOf(cg.getCargaMax())};
                modelCarga.addRow(dadosCarga);
            }
            tableDadosCarga.setModel(modelCarga);
        }
    }

    public static void consulPlacaPasseio() {
        boolean existePlacaPasseio = false;

        String placaPasseio = cxConsultaPlacaPasseio.getText();

        for (Passeio ps : getListaPasseio()) {
            if (ps.getPlaca().equalsIgnoreCase(placaPasseio)) {
                //   cxPlaca.setText(ps.getPlaca());
                cxMarcaConsulPasseio.setText(ps.getMarca());
                cxModeloConsulPasseio.setText(ps.getModelo());
                cxCorConsulPasseio.setText(ps.getCor());
                cxQtdRodasConsulPasseio.setText(Integer.toString(ps.getQtdRodas()));
                cxVeloxMaxConsulPasseio.setText(Float.toString(ps.getVelocMax()));
                cxQtdPistConsulPasseio.setText(Integer.toString(ps.getMotor().getQtdPist()));
                cxPotenciaConsulPasseio.setText(Integer.toString(ps.getMotor().getPotencia()));
                cxQtdPassageirosConsulPasseio.setText(Integer.toString(ps.getQtdPassageiros()));
                JOptionPane.showMessageDialog(
                        null,
                        "Veículo de Passeio encontrado - Verifique os dados",
                        "Consulta de Veículo pela Placa",
                        JOptionPane.INFORMATION_MESSAGE
                );
                existePlacaPasseio = true;
                break;
            }
        }
        if (!existePlacaPasseio) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não existe veiculo de passeio cadastrado com esta placa!",
                    "Erro Consulta",
                    JOptionPane.ERROR_MESSAGE
            );
            limpar();
        }
    }

    public static void consulPlacaCarga() {
        boolean existePlacaCarga = false;

        String placaCarga = cxConsultaPlacaCarga.getText();

        for (Carga cg : getListaCarga()) {
            if (cg.getPlaca().equalsIgnoreCase(placaCarga)) {
                cxMarcaConsulCarga.setText(cg.getMarca());
                cxModeloConsulCarga.setText(cg.getModelo());
                cxCorConsulCarga.setText(cg.getCor());
                cxQtdRodasConsulCarga.setText(Integer.toString(cg.getQtdRodas()));
                cxVeloxMaxConsulCarga.setText(Float.toString(cg.getVelocMax()));
                cxQtdPistConsulCarga.setText(Integer.toString(cg.getMotor().getQtdPist()));
                cxPotenciaConsulCarga.setText(Integer.toString(cg.getMotor().getPotencia()));
                cxTaraConsulCarga.setText(Integer.toString(cg.getTara()));
                cxCargaMaxConsulCarga.setText(Integer.toString(cg.getCargaMax()));
                JOptionPane.showMessageDialog(
                        null,
                        "Veículo de Carga encontrado - Verifique os dados",
                        "Consulta de Veículo pela Placa",
                        JOptionPane.INFORMATION_MESSAGE
                );
                existePlacaCarga = true;
                break;
            }
        }
        if (!existePlacaCarga) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não existe veiculo de carga cadastrado com esta placa!",
                    "Erro Consulta",
                    JOptionPane.ERROR_MESSAGE
            );
            limpar();
        }
    }

    public static void excluiPlacaPasseio() {

        boolean existePlacaPasseio = false;

        String placaPasseio = cxConsultaPlacaPasseio.getText();

        for (Passeio ps : getListaPasseio()) {
            if (ps.getPlaca().contains(placaPasseio)) {
                getListaPasseio().remove(ps);
                JOptionPane.showMessageDialog(
                        null,
                        "Veiculo de passeio excluido com sucesso!",
                        "Excluir Veículo pela Placa",
                        JOptionPane.INFORMATION_MESSAGE
                );
                existePlacaPasseio = true;
                break;
            }
        }
        if (!existePlacaPasseio) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não existe veiculo de passeio cadastrado com esta placa!",
                    "Erro Consulta",
                    JOptionPane.ERROR_MESSAGE
            );
            limpar();
        }
    }

    public static void excluiPlacaCarga() {

        boolean existePlacaCarga = false;

        String placaCarga = cxConsultaPlacaCarga.getText();

        for (Carga cg : getListaCarga()) {
            if (cg.getPlaca().contains(placaCarga)) {
                getListaCarga().remove(cg);
                JOptionPane.showMessageDialog(
                        null,
                        "Veiculo de carga excluido com sucesso!",
                        "Excluir Veículo pela Placa",
                        JOptionPane.INFORMATION_MESSAGE
                );
                existePlacaCarga = true;
                break;
            }
        }
        if (!existePlacaCarga) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não existe veiculo de carga cadastrado com esta placa!",
                    "Erro Consulta",
                    JOptionPane.ERROR_MESSAGE
            );
            limpar();
        }
    }

    public static boolean excluirTodosPasseio() {
        if (getListaPasseio().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Não há dados a serem removidos.",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        } else {
            listaPasseio = new ArrayList<>();
        }
        return true;
    }

    public static boolean excluirTodosCarga() {
        if (getListaCarga().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Não há dados a serem removidos.",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        } else {
            listaCarga = new ArrayList<>();
        }
        return true;
    }
}


