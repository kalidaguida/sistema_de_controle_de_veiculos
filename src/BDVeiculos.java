import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
    private static List<Passeio> listaPasseio = new ArrayList<>();
    private static List<Carga> listaCarga = new ArrayList<>();

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
            if (ps.getPlaca().contains(placa)) {
                throw new VeicExistException();
            }
        }

        for (Carga cg : listaCarga) {
            if (cg.getPlaca().contains(placa)) {
                throw new VeicExistException();
            }
        }
    }
}


