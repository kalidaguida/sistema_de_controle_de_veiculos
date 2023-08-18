public class VelocException extends Exception {

    public void impMsgVelocMax() {
        System.out.println("\n======================= ATENCAO! =======================");
        System.out.println("A velocidade máxima está fora dos limites brasileiros\n");
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

