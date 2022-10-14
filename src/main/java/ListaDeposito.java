import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement()
public class ListaDeposito {
    //Declaramos los atributos de la clase
    private ArrayList<Deposito> listaDeposito;

    //Creamos el constructor con los atributos
    public ListaDeposito(ArrayList<Deposito> listaDeposito) {
        this.listaDeposito = listaDeposito;
    }

    //Creamos el constructor vacio
    public ListaDeposito() {
    }

    //Creamos los getter y los setter de los atributos
    //Definimos el wrapper que es la envoltura alrededor de la representacion xml
    @XmlElementWrapper(name = "depositos")
    @XmlElement(name = "deposito")
    public ArrayList<Deposito> getListaDeposito() {
        return listaDeposito;
    }
    public void setListaDeposito(ArrayList<Deposito> listaDeposito) {
        this.listaDeposito = listaDeposito;
    }
}
