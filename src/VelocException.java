import javax.swing.*;

public class VelocException extends Exception {

    public void impMsgVelocMax() {
        JOptionPane.showMessageDialog(null,
                "A velocidade máxima está fora dos limites brasileiros\n",
                "ATENCAO!",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public Veiculo correcaoVelocMax(Veiculo veiculo) {
        try {
            if (veiculo instanceof Passeio) {
                veiculo.setVelocMax(100);
            } else {
                veiculo.setVelocMax(90);
            }
        } catch (VelocException ve) {
            ve.impMsgVelocMax();
            veiculo = ve.correcaoVelocMax(veiculo);
        }
        return veiculo;
    }
}

