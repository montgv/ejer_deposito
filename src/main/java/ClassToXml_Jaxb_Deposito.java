import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;

public class ClassToXml_Jaxb_Deposito {
    public static void main(String[] args) throws JAXBException {
        //Creamos la lista de depositos
        ArrayList<Deposito> listaDeposito = new ArrayList<>();

        //Creamos tres depositos y los añadimos al arrayList
        Deposito deposito1 = new Deposito(40.30f, 50.50f, "Dep_pequeño");
        Deposito deposito2 = new Deposito(100.80f, 150.0f, "Dep_mediano");
        Deposito deposito3 = new Deposito(240.50f, 500.0f, "Dep_grande");
        listaDeposito.add(deposito1);
        listaDeposito.add(deposito2);
        listaDeposito.add(deposito3);

        //Creamos una instancia de ListaDeposito y le asignamos el arrayList anterior
        ListaDeposito miListaDeposito = new ListaDeposito();
        miListaDeposito.setListaDeposito(listaDeposito);

        //Creamos el contexto indicando la clase raiz
        JAXBContext context = JAXBContext.newInstance(ListaDeposito.class);

        //Creamos el marshaller que convierte el JavaBean en una cadena xml
        Marshaller marshaller = context.createMarshaller();

        //Formateamos el xml para que se vea bonito en la creacion
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Lo mostramos por pantalla
        marshaller.marshal(miListaDeposito, System.out);

        //Ahora la salida por pantalla anterior lo guardamos en el archivo que lo tiene que crear porque no existe
        marshaller.marshal(miListaDeposito, new File("deposito.xml"));
    }
}
