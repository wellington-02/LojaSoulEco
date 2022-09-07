package br.ufpb.souleco;

import br.ufpb.souleco.bd.ClienteDAO;
import br.ufpb.souleco.bd.Conexao;
import br.ufpb.souleco.classes.Cliente;
import br.ufpb.souleco.service.ClienteService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastrarController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    private String caminhoFoto;

    @FXML
    private Label resulCadMessageLabel;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField cadCepCliente;

    @FXML
    private TextField cadCpfCliente;

    @FXML
    private TextField cadNomeDeUsuaCliente;

    @FXML
    private TextField cadNomeCliente;

    @FXML
    private PasswordField cadRepetirSenhaCliente;

    @FXML
    private PasswordField cadSenhaCliente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Conexao con = new Conexao();

    }


    @FXML
    void cadastrarButtonOnAction(ActionEvent event) {

        String cepString = cadCepCliente.getText();
        int cep = 0;
        if(cepString.equals("")){

        }else {
            cep = Integer.parseInt(cepString);
        }

        if (!cadNomeDeUsuaCliente.getText().isBlank() &&
                !cadNomeCliente.getText().isBlank() &&
                !cadCpfCliente.getText().isBlank() &&
                !cadCepCliente.getText().isBlank() &&
                !cadSenhaCliente.getText().isBlank() &&
                !cadRepetirSenhaCliente.getText().isBlank()) {

            if (cadSenhaCliente.getText().equals(cadRepetirSenhaCliente.getText())) {
                Cliente c = new Cliente(cadNomeCliente.getText(), cadCpfCliente.getText(),
                        cep, cadNomeDeUsuaCliente.getText(),cadSenhaCliente.getText());

                boolean cadastrou = ClienteService.cadastrar(c);
                if (cadastrou) {
                    resulCadMessageLabel.setText("Cadastrado com sucesso!");
                } else {
                    resulCadMessageLabel.setText("Cpf já cadastrado ");
                }
            } else {
                resulCadMessageLabel.setText("Senhas diferentes");
            }
        }else{
            resulCadMessageLabel.setText("Por favor preencha todos os campos");
        }
    }

    @FXML
    private void voltarButtonOnAction(ActionEvent event) {
        Stage cadastrarStage = (Stage) botaoVoltar.getScene().getWindow();
        cadastrarStage.close();
        ecoPainelLogin();


    }

    public void ecoPainelLogin() {

        try {
            Parent painelLogin = FXMLLoader.load(getClass().getResource("ecoLogin.fxml"));
            Stage loginStage = new Stage();

            painelLogin.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();

            });

            painelLogin.setOnMouseDragged(event -> {

                loginStage.setX(event.getScreenX() - xOffset);
                loginStage.setY(event.getScreenY() - yOffset);

            });

            loginStage.initStyle(StageStyle.UNDECORATED);
            loginStage.setScene(new Scene(painelLogin));
            loginStage.show();


        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
