package vuelos;
import java.net.URL;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class MaletasController implements Initializable {

    @FXML
    private Button btnDescargar;

    @FXML
    private Button btnPasarALaBanda;

    @FXML
    private Button btnEntregar;

    @FXML
    private Button btnSalir;

    @FXML
    private TextArea txtA;

    @FXML
    private TextArea txtB;

    @FXML
    private TextArea txtC;

    @FXML
    private TextArea txtBTransportadora;

    @FXML
    private TextArea txtEntrega;

    @FXML
    private TextArea txtEtapa;
    
    @FXML
    private ImageView img1;
    
    @FXML
    private ImageView img2;
    
    @FXML
    private ImageView img3;
  
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        int pasajeros, vuelos;
        int i = 0;

        ArrayList<Integer> vuelo = new ArrayList<Integer>();
        
        vuelo.add(182);
        vuelo.add(402);
        vuelo.add(1344);

        ArrayList<String> Pasajero = new ArrayList<String>();

        Pasajero.add("Brayan");
        Pasajero.add("Aldair");
        Pasajero.add("Cristopher");
        Pasajero.add("Ariel");
        Pasajero.add("Brandon");
        Pasajero.add("Marcos");
        Pasajero.add("Denilson");
        Pasajero.add("Eliam");
        Pasajero.add("Maya");
        Pasajero.add("Jocelin");
        Pasajero.add("Braulio");
        Pasajero.add("Fernanda");

        while (i < 12) {
            Maleta maleta;
            pasajeros = (int) (Math.random() * 12);
            vuelos = (int) (Math.random() * 3);
            if (Pasajero.get(pasajeros) != null) {
                maleta = new Maleta(Pasajero.get(pasajeros), vuelo.get(vuelos));
                maletas.add(maleta);
                Pasajero.set(pasajeros, null);
                i++;
            }
        }
    }
     
    public void OnbtnDescargar(ActionEvent e) {

        if (!maletas.isEmpty()) {
            MaPop = maletas.pop();

            switch (MaPop.getVuelo()) {
                case 182:
                    vueloA.add(MaPop);
                    break;
                case 402:
                    vueloB.add(MaPop);
                    break;
                case 1344:
                    vueloC.add(MaPop);
                    break;
                default:
                    break;
            }

            txtEtapa.setText("Bajando maletas del avión");
            img1.setVisible(true);
        } else {

            txtEtapa.setText("Todas las maletas estan descargadas");
            btnDescargar.setDisable(true);
            btnPasarALaBanda.setDisable(false);
            
        }

        txtA.setText("" + vueloA);
        txtB.setText("" + vueloB);
        txtC.setText("" + vueloC);
        img1.setVisible(true);
    }

    public void OnbtnPasarALaBanda(ActionEvent e) {
        
        int nVuelo = (int) (Math.random() * 3);
        
        if (!vueloA.isEmpty() || !vueloB.isEmpty() || !vueloC.isEmpty()) {
            
            if (nVuelo == 0 && !vueloA.isEmpty())
            { 
                Pasajero.add(vueloA.pop());    
            } 
            else if (nVuelo == 1 && !vueloB.isEmpty()) 
            {   
                Pasajero.add(vueloB.pop());  
            }
            else if (nVuelo == 2 && !vueloC.isEmpty())
            {
                Pasajero.add(vueloC.pop());
            }
            
            txtEtapa.setText("Colocando maletas en la banda transportadora");
            
        } else {
            
            txtEtapa.setText("Todas las maletas estan en la banda transportadora");
            btnPasarALaBanda.setDisable(true);
            btnEntregar.setDisable(false);
            
        }

        txtBTransportadora.setText("" + Pasajero);
        txtA.setText("" + vueloA);
        txtB.setText("" + vueloB);
        txtC.setText("" + vueloC);
        img1.setVisible(false);
        img2.setVisible(true);
    }

    public void OnbtnEntregar(ActionEvent e) {
        if (!Pasajero.isEmpty()) 
        {
            txtEntrega.setText("" + Pasajero.poll());
            txtEtapa.setText("Tome su maleta");
        }
        else 
        {
            txtEtapa.setText("Todas las maletas fueron tomadas");
            btnEntregar.setDisable(true);
        }
        txtBTransportadora.setText("" + Pasajero);
        img1.setVisible(false);
        img2.setVisible(false);
        img3.setVisible(true);
    }

    public void OnbtnSalir(ActionEvent e)
    {
        System.exit(0);
    }

    Stack<Maleta> maletas = new Stack<>();

    Maleta MaPop;

    Stack<Maleta> vueloA = new Stack<>();
    Stack<Maleta> vueloB = new Stack<>();
    Stack<Maleta> vueloC = new Stack<>();

    PriorityQueue<Maleta> Pasajero = new PriorityQueue<>(new ComparatorMaletas());

}
