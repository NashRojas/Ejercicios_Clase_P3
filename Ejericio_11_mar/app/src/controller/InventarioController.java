package app.src.controller

import app.model.Producto;
import javafx.fxml.FXML;
import javafx.collections.*;
import javafx.scene.control;
import javafx.scene.control.*;

public class InventarioController {
    @FXML
    private TextField txtNombre;

    @fxml
    private TextField txtPrecio;

    @FXML   
    private TextField txtCantidad;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnAgregar;

    @FXML
    private TableView<Producto> tabla;

    @FXML
    private TableColumn<Producto, String>  colNombre;

    @FXML
    private TableColumn<Producto, Double>  colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colCantidad;

    @FXML
    private Label lblError;

    private ObservableList<Producto> productos;

    @FXML
    public void initialice() {

        // Vincular columnas con las propiedades del modelo
    colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

    colPrecio.setCellFactory(col -> new TableCell<>() {
        @Override
        protected void updateItem(Double valor, boolean empty){
            super.updateItem(valor, empty);
            setText(empty || valor == null ? null : String.format("%.2f", valor)); 
        }
    });

    ObservableList<Producto> productos = FXCollections.observableArrayList();

    productos.add(new Producto("Laptop", 850.00, 5));
    productos.add(new Producto("Mouse",   12.50, 30));  

    tabla.setItems(productos);
    }

    @FXML
    private void agregarProducto() {

    String nombre = txtNombre.getText().trim();

    try {
        double precio   = Double.parseDouble(txtPrecio.getText().trim());
        int cantidad    = Integer.parseInt(txtCantidad.getText().trim());

        Producto nuevo = new Producto(nombre, precio, cantidad);

        productos.add(nuevo);

        txtNombre.clear();
        txtPrecio.clear();
        txtCantidad.clear();

        lblError.setText("");

    } catch (NumberFormatException ex) {
       lblError.setText("Precio y cantidad deben ser numeros.");
    }
    }

    @FXML 
    private void eliminarProducto() {
        Producto seleccionado = table.getelectionModel().getSelectedItem();

        if (seleccionado != null) {
            productos.remove(seleccionado);
        }
    }
}