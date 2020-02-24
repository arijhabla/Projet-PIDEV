/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Service.Serviceclasse;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.RomanList;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AfficherclasseController implements Initializable {

    @FXML
    private TableColumn<classe, Integer> tfid;
    @FXML
    private Button afficher;
    @FXML
    private TableView<classe> table;
    private ObservableList<classe> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<classe, Integer> tff;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    public static Integer nbr_eleves;
    public static Integer id_classe;
    public static String niveau;
    @FXML
    private Button back;
    @FXML
    private TableColumn<classe, String> tfniveau;
    @FXML
    private Button exportPdf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher(null);
        // TODO
    }

    public void setTab(TableView<classe> table) {
        this.table = table;
    }

    public void setId(TableColumn<classe, Integer> id_classe) {
        this.tfid = id_classe;
    }

    public void setNbre(TableColumn<classe, Integer> nbr_eleves) {
        this.tff = nbr_eleves;
    }

    public void setNiveau(TableColumn<classe, String> niveau) {
        this.tfniveau = niveau;
    }

    public void setAff(Button affcher) {
        this.afficher = afficher;
    }

    public void setData(ObservableList<classe> data) {
        this.data = data;
    }

    @FXML
    private void afficher(ActionEvent event) {
        try {
            Serviceclasse sc = new Serviceclasse();
            // List<Command> list = sp.readAll();

            data.addAll(sc.readAll());

            tfid.setCellValueFactory(new PropertyValueFactory<classe, Integer>("id_classe"));
            tff.setCellValueFactory(new PropertyValueFactory<classe, Integer>("nbr_eleves"));
            tfniveau.setCellValueFactory(new PropertyValueFactory<classe, String>("niveau"));

            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherclasseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void supprimer(ActionEvent event) {

        try {
            classe e = (classe) table.getSelectionModel().getSelectedItem();
            Serviceclasse as = new Serviceclasse();

            as.delete(e);
            table.getItems().removeAll(e);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherclasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
        modifier.setOnAction(e -> {
            classe ref = table.getSelectionModel().getSelectedItem();
            AfficherclasseController.id_classe = ref.getId_classe();
            AfficherclasseController.nbr_eleves = ref.getNbr_eleves();
            AfficherclasseController.niveau = ref.getNiveau();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Modifierclasse.fxml"));
                Stage stage = (Stage) modifier.getScene().getWindow();
                stage.close();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherclasseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void back(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("gotoclasse.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void exportPdf(ActionEvent event) {
        Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Table_classes.pdf"));
            document.open();

            PdfPTable table = new PdfPTable(2); // 3 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table

            //Set Column widths
            float[] columnWidths = {1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Nom de la classe"));
            cell1.setBorderColor(BaseColor.BLUE);
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Nombre des élèves"));
            cell2.setBorderColor(BaseColor.GREEN);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            Paragraph test = new Paragraph("Liste des classes");
            document.add(test);

            table.addCell(cell1);
            table.addCell(cell2);

            List<classe> classes = new ArrayList<classe>();
            Serviceclasse sc = new Serviceclasse();
            classes = sc.readAll();
            RomanList romanList = new RomanList();

            PdfPTable table2 = new PdfPTable(2);
            table2.setWidths(columnWidths);
            table2.setWidthPercentage(100); //Width 100%

            classes.stream().forEach((classe) -> {
                table2.addCell(new PdfPCell(new Paragraph(classe.getNiveau())));
                table2.addCell(new PdfPCell(new Paragraph(String.valueOf(classe.getNbr_eleves()))));

            });
            Image image = Image.getInstance("logo.png");
            image.scaleAbsolute(200, 200);

            image.setAbsolutePosition(370f, 10f);
            document.addTitle("Liste des classes");
            document.add(table);
            document.add(table2);
            document.addAuthor("EasyChool");
            document.add(image);

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
