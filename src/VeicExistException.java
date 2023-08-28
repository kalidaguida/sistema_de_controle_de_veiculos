import javax.swing.*;

public class VeicExistException extends Exception {

        public void impVeicExistException() {

        JOptionPane.showMessageDialog(null,
                "Já existe um veículo com esta placa!",
                "Erro de cadastro",
                JOptionPane.ERROR_MESSAGE
        );
    }
}