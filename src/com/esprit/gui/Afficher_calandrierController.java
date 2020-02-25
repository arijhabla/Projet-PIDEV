/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

import com.esprit.Entite.Calandrier_e;
import com.esprit.Service.ServiceCalandrier_e;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.shaded.apache.poi.hssf.usermodel.HeaderFooter.tab;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class Afficher_calandrierController implements Initializable {
    
    @FXML
    private TableColumn<Calandrier_e, Integer> idc;
    @FXML
    private TableColumn<Calandrier_e, Integer> idex;
    @FXML
    private TableColumn<Calandrier_e, Integer> idm;
    @FXML
    private TableColumn<Calandrier_e, Integer> ids;
    @FXML
    private TableColumn<Calandrier_e, Integer> idcl;
    @FXML
    private TableColumn<Calandrier_e, String> nomex;
    @FXML
    private TableColumn<Calandrier_e, Timestamp> datee;
    
     ObservableList<Calandrier_e> data=FXCollections.observableArrayList();
     @FXML
    private TableView<Calandrier_e> table;
    @FXML
    private Button sup;
    @FXML
    private Button modifierca;
   public static Integer id_c;
    public static Integer id_ex;
public static Integer id_mat;
public static Integer id_sal;
public static Integer id_clas;
public static String nom_e;
public static Timestamp date_e;
    @FXML
    private Button annuler;
    @FXML
    private TextField filterField;
    @FXML
    private Button save;
      private Connection con;
    private Statement ste;
    private ResultSet rs;

   
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             ServiceCalandrier_e ce= new ServiceCalandrier_e();
           // List<Command> list = sp.readAll();
            
            data.addAll(ce.readAll());
            
         idc.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_calandrier"));
            idex.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_examen"));
            idm.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_matiere"));
                       ids.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_salle"));
                       idcl.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_classe"));
                       nomex.setCellValueFactory(new PropertyValueFactory<Calandrier_e,String>("nom"));
                       datee.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Timestamp>("date_ex"));

            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_calandrierController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        FilteredList<Calandrier_e> filteredData = new FilteredList<>(data, b -> true);
          filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(emp -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (emp.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				
				}
				else if (String.valueOf(emp.getId_classe()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Calandrier_e> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
table.setItems(sortedData);
        // TODO
    } 

    public TableColumn<Calandrier_e, Integer> getIdc() {
        return idc;
    }

    public void setIdc(TableColumn<Calandrier_e, Integer> idc) {
        this.idc = idc;
    }

    public TableColumn<Calandrier_e, Integer> getIdex() {
        return idex;
    }

    public void setIdex(TableColumn<Calandrier_e, Integer> idex) {
        this.idex = idex;
    }

    public TableColumn<Calandrier_e, Integer> getIdm() {
        return idm;
    }

    public void setIdm(TableColumn<Calandrier_e, Integer> idm) {
        this.idm = idm;
    }

    public TableColumn<Calandrier_e, Integer> getIds() {
        return ids;
    }

    public void setIds(TableColumn<Calandrier_e, Integer> ids) {
        this.ids = ids;
    }

    public TableColumn<Calandrier_e, Integer> getIdcl() {
        return idcl;
    }

    public void setIdcl(TableColumn<Calandrier_e, Integer> idcl) {
        this.idcl = idcl;
    }

    public TableColumn<Calandrier_e, String> getNomex() {
        return nomex;
    }

    public void setNomex(TableColumn<Calandrier_e, String> nomex) {
        this.nomex = nomex;
    }

    public TableColumn<Calandrier_e, Timestamp> getDatee() {
        return datee;
    }

    public void setDatee(TableColumn<Calandrier_e, Timestamp> datee) {
        this.datee = datee;
    }

   

    public ObservableList<Calandrier_e> getData() {
        return data;
    }

    public void setData(ObservableList<Calandrier_e> data) {
        this.data = data;
    }

    public TableView<Calandrier_e> getTable() {
        return table;
    }

    public void setTable(TableView<Calandrier_e> table) {
        this.table = table;
    }

    public Button getSup() {
        return sup;
    }

    public void setSup(Button sup) {
        this.sup = sup;
    }
    


    @FXML
    private void supprimer(ActionEvent event) {
        try {
             Calandrier_e c = (Calandrier_e) table.getSelectionModel().getSelectedItem();
             ServiceCalandrier_e ce = new ServiceCalandrier_e();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               ce.delete(c);
              
              table.getItems().removeAll(c);

         } catch (SQLException ex) {
             Logger.getLogger(Afficher_calandrierController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    

    @FXML
    private void modifierca(ActionEvent event) {
     modifierca.setOnAction(e-> {
 Calandrier_e ref = table.getSelectionModel().getSelectedItem();
 Afficher_calandrierController.id_c=ref.getId_calandrier();
 Afficher_calandrierController.id_ex=ref.getId_examen();
 Afficher_calandrierController.id_mat=ref.getId_matiere();
 Afficher_calandrierController.id_sal=ref.getId_salle();
 Afficher_calandrierController.id_clas=ref.getId_classe();
 Afficher_calandrierController.nom_e=ref.getNom();
  Afficher_calandrierController.date_e=ref.getDate_ex();

 
 
           // AfficheremployeController.vv = selectedItems.toString().split(",")[0].substring(1);
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Modifier_calandrier.fxml"));
            Stage stage = (Stage) modifierca.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
           
        } catch (IOException ex) {
            Logger.getLogger(Afficher_calandrierController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
     
      
        
    }

    @FXML
    private void annuler(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mcalandrier.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) annuler.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
/*
    private void tel(ActionEvent event)throws IOException,FileNotFoundException, DocumentException, SQLException {
       
       {
        try {
            String file_name="N:\\PDF\\Admin.pdf";
            Document document = new Document();
            
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            
            document.open();
            DataBase db = new DataBase();
            Connection cnx = db.getConnection();
            PreparedStatement ps =null;
            ResultSet rs =null;
            String req = "Select * from calandrier_e";
            ps = cnx.prepareCall(req);
            rs=ps.executeQuery();
            PdfPTable t = new PdfPTable(7);
            PdfPCell c1 = new PdfPCell(new Phrase("id_calandrier"));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("id_examen"));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("id_matiere"));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("id_salle"));
            t.addCell(c4);
            PdfPCell c5 = new PdfPCell(new Phrase("id_classe"));
            t.addCell(c5);
             PdfPCell c6 = new PdfPCell(new Phrase("nom"));
            t.addCell(c6);
            PdfPCell c7 = new PdfPCell(new Phrase("date_ex"));
            t.addCell(c7);
            t.setHeaderRows(1);
            while(rs.next()){
                t.addCell(rs.getString(1));
                t.addCell(rs.getString(2));
                t.addCell(rs.getString(3));
                t.addCell(rs.getString(4));
                t.addCell(rs.getString(5));
                t.addCell(rs.getString(6));
                t.addCell(rs.getString(7));
                
                document.add(t);
            }
            document.close();
            System.out.println("finished");
        } catch (DocumentException ex) {
            System.out.println(ex); 
        }
       // Notification.showNotif("Pdf Telechargé","verifier votre dossier :N");
    }
    }*/
    
    
 

    @FXML
    private void save(ActionEvent event) throws FileNotFoundException, IOException {
         
        try {
           // String query = "Select * from calandrier_e";
            //ste = con.prepareStatement(query);
           //  Statement stl = con.createStatement();
          // int rs =stl.executeUpdate(sql);
             // rs = ste.executeQuery();
            // ste=con.createStatement();
           //  rs=ste.executeQuery(query);
             
             List<Calandrier_e> arr=new ArrayList<>();
    ste=con.createStatement();
     rs=ste.executeQuery("select * from calandrier_e");
            XSSFWorkbook wb =new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("user details");
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("id_calandrier");
            header.createCell(1).setCellValue("id_examen");
            header.createCell(2).setCellValue("id_matiere");
            header.createCell(3).setCellValue("id_salle");
            header.createCell(4).setCellValue("id_classe");
            header.createCell(5).setCellValue("nom");
            header.createCell(6).setCellValue("date_ex");
         //   arr.add(index, null);
       int index = 1;
            while(rs.next()){
            XSSFRow row =sheet.createRow(index);
            row.createCell(0).setCellValue(rs.getInt("id_calandrier"));
            row.createCell(1).setCellValue(rs.getInt("id_examen"));
            row.createCell(2).setCellValue(rs.getInt("id_matiere"));
            row.createCell(3).setCellValue(rs.getInt("id_salle"));
            row.createCell(4).setCellValue(rs.getInt("id_classe"));
            row.createCell(5).setCellValue(rs.getString("nom"));
            row.createCell(6).setCellValue(rs.getTimestamp("date_ex"));
            index ++;
            }
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\BEN SAID\\Desktop\\projetmonta\\userDetails.xlsx");
        wb.write(fileOut);
        fileOut.close();
        ste.close();
        rs.close();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_calandrierController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
} 
    
     
    
    

