import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {
    private static Leitura LeituraUnico;

    private Leitura() {

    }

    public static Leitura getLeituraUnico() {
        if (LeituraUnico == null) {
            LeituraUnico = new Leitura();
        }
        return LeituraUnico;
    }

    public String entDados(String rotulo) {
        System.out.println(rotulo);

        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(teclado);

        String ret = "";
        try {
            ret = buff.readLine();
        } catch (IOException ioe) {
            System.out.println("\n Erro de sistema");
        }
        return ret;

    }
}
