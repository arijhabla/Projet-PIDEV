/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.esprit.Entite.Affectation;
import com.esprit.Entite.classe;
import com.esprit.Entite.matiere;
import com.esprit.Entite.salle;
import com.esprit.Service.Serviceaffectation;
import com.esprit.Service.Serviceclasse;
import com.esprit.Service.Servicematiere;
import com.esprit.Service.Servicesalle;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AffectationController implements Initializable {

    @FXML
    private ComboBox<String> Cclasse;
    @FXML
    private ComboBox<String> Cmatiere;
    @FXML
    private ComboBox<String> Csalle;
    @FXML
    private Button affectation;
    @FXML
    private TextField date;
    @FXML
    private TextField heure;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Serviceclasse sc = new Serviceclasse();
        Servicematiere sm = new Servicematiere();

        Servicesalle ss = new Servicesalle();

        List<classe> classes = new ArrayList();
        List<salle> salles = new ArrayList();
        List<matiere> matieres = new ArrayList();

        try {
            classes = sc.readAll();
            salles = ss.readAll();
            matieres = sm.readAll();
            //  classes.forEach(classe->Cmatiere.getItems().add(classe.getId_classe(), classe.getNiveau()));
            for (int i = 0; i < classes.size(); i++) {
                Cclasse.getItems().add(i, classes.get(i).getNiveau());

            }
            for (int i = 0; i < salles.size(); i++) // TODO
            {
                Csalle.getItems().add(i, String.valueOf(salles.get(i).getId_salle()));
            }
            for (int i = 0; i < matieres.size(); i++) // TODO
            {
                Cmatiere.getItems().add(i, matieres.get(i).getNom_matiere());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AffectationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affectation(ActionEvent event) throws SQLException {
        Serviceaffectation sa = new Serviceaffectation();
//    public Affectation(int id, String nv_cl, int id_salle, String nom_matiere, String date) {

        Cclasse.getValue();
        Affectation aff = new Affectation(0, Cclasse.getValue(), Integer.parseInt(Csalle.getValue()), Cmatiere.getValue(), date.getText(), heure.getText());
        String[] splits_date = new String[5];
        String[] splits_heure = new String[5];

        splits_date = date.getText().split("-");
        splits_heure = heure.getText().split("-");
        sa.selectAffection(aff);
//sa.selectAffection(aff)!=404 &&
        if ( sa.selectAffection(aff)==0 &&   splits_date.length == 3 && splits_heure.length==2 && splits_date[0].length()==2 && splits_date[1].length()==2 && splits_date[2].length()==4  ) {
            
            sa.ajouter(aff);

        }
        else if (sa.selectAffection(aff)!=0)
        {
            //instance de alert dialog avec ce message
            System.out.println("tu peux pas inserer car ce classe est deja dans cette salle");
        }
else
        {
            System.out.println("verifier les champs");
        }
    }

}
