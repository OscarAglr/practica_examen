/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.fcys.programacion2.depreciacionfx.controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;

/**
 * FXML Controller class
 *
 * @author Sistemas-15
 */
public class DepreciacionFXMLController implements Initializable {

    @FXML
    public TextField txtName;
    @FXML
    public TextField txtValor;
    @FXML
    public TextField txtSalvamento;
    @FXML
    public ComboBox<String> cbTipo;
    @FXML
    public Button btnCalcular;
    @FXML
    public TableView tblActivos;

    private ObservableList<String> tipos;
    private ObservableList<Map<String, Object>> activos;
    private TableColumn<Map, String> activoColumn;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        activos = FXCollections.<Map<String, Object>>observableArrayList();
        tipos = FXCollections.observableArrayList("Edificio", "Vehiculo", "Maquinaria", "Mobiliario", "Equipo oficina");
        cbTipo.setItems(tipos);
        activoColumn = new TableColumn<>("Activo");
        activoColumn.setCellValueFactory(new MapValueFactory<>("Activo"));
        tblActivos.getColumns().add(activoColumn);
        tblActivos.getItems().addAll(activos);
    }

    @FXML
    public void btnCalcularAction(ActionEvent event) {
        Map<String, Object> activos_map = new HashMap<String, Object>();
        String tipo_activo = cbTipo.getValue();
        int x, vida_util = 0;
        String nombre;
        float valor_activo = Float.parseFloat(txtValor.getText());
        float valor_salvamento = Float.parseFloat(txtSalvamento.getText());

        switch (tipo_activo) {
            case "Edificio":
                x = tblActivos.getColumns().size();
                vida_util = 20;
                if (x < vida_util) {
                    add_columns(x, vida_util);
                }

                break;
            case "Vehiculo":
                x = tblActivos.getColumns().size();
                vida_util = 5;
                if (x < vida_util) {
                    add_columns(x, vida_util);
                }
                break;
            case "Maquinaria":
                x = tblActivos.getColumns().size();
                vida_util = 8;
                if (x < vida_util) {
                    add_columns(x, vida_util);
                }
                break;
            case "Mobiliario":
                x = tblActivos.getColumns().size();
                x = tblActivos.getColumns().size();
                vida_util = 2;
                if (x < vida_util) {
                    add_columns(x, vida_util);
                }
                break;
            case "Equipo oficina":
                x = tblActivos.getColumns().size();
                x = tblActivos.getColumns().size();
                vida_util = 1;
                if (x < vida_util) {
                    add_columns(x, vida_util);
                }
                break;
        }
        nombre = txtName.getText();
        activos_map.put("Activo", nombre);
        add_depreciacion(activos_map, vida_util, valor_activo, valor_salvamento);
        activos.add(activos_map);

        tblActivos.getItems().add(activos_map);
    }

    private float depreciacion(float valor_activo, float valor_salvamento, int vida_util) {
        return (valor_activo - valor_salvamento) / vida_util;
    }

    private void add_columns(int x, int n) {
        TableColumn<Map, String> n_column;
        for (int i = x; i <= n; i++) {
            n_column = new TableColumn<>(String.valueOf(i));
            n_column.setCellValueFactory(new MapValueFactory<>(String.valueOf(i)));
            tblActivos.getColumns().add(n_column);
        }
    }

    private void add_depreciacion(Map<String, Object> map, int n, float v, float vs) {
        for (int i = 0; i < n; i++) {
            map.put(String.valueOf(i + 1), depreciacion(v, vs, n));
        }
    }

}
