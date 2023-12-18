package ma.enset;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.dao.ProductDaoImpl;
import ma.enset.dao.entities.Product;
import ma.enset.service.IProductService;
import ma.enset.service.ProductService;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Product> tableProducts;

    @FXML
    private TableColumn<Integer, Product> columnID;

    @FXML
    private TableColumn<String, Product> columnNom;

    @FXML
    private TableColumn<Double, Product> columnPrix;

    @FXML
    private TableColumn<Integer, Product> columnQuantity;

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldQuantity;

    @FXML
    private TextField fieldPrix;

    ObservableList<Product> data = FXCollections.observableArrayList();

   IProductService service =new ProductService(new ProductDaoImpl());

    @FXML
    public void addProduct(){
        Product p = new Product(fieldNom.getText(),
                Double.parseDouble(fieldPrix.getText()),
                Double.parseDouble(fieldQuantity.getText()));

        service.addProduct(p);
        loadData();
    }

    @FXML
    public void deleteProduct() {
        Product selectedProduct = tableProducts.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            service.deleteProductById((int) selectedProduct.getId());
            loadData();
        }
    }

    public void updateProduct(ActionEvent actionEvent) {
        Product selectedProduct = tableProducts.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            selectedProduct.setName(fieldNom.getText());
            selectedProduct.setPrice(Double.parseDouble(fieldPrix.getText()));
            selectedProduct.setQuantity(Double.parseDouble(fieldQuantity.getText()));
            service.updateProduct(selectedProduct);
            loadData();
        }
    }

    private void loadData(){
        data.clear();
        data.addAll(service.getAllProducts());
        tableProducts.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Specify for each column the value
        columnID.setCellValueFactory((new PropertyValueFactory<>("id")));
        columnNom.setCellValueFactory((new PropertyValueFactory<>("name")));
        columnPrix.setCellValueFactory((new PropertyValueFactory<>("price")));
        columnQuantity.setCellValueFactory((new PropertyValueFactory<>("quantity")));

        service = new ProductService(new ProductDaoImpl());
        loadData();
    }


}