package br.ufpb.souleco;

import br.ufpb.souleco.bd.ClienteDAO;
import br.ufpb.souleco.classes.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EcoController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;


    @FXML
    private Button botaoCancelar;
    @FXML
    private Button botaoCadastrar;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView arvoreImageView;
    @FXML
    private ImageView iconImageView;
    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField senhaField;

    public void loginButtonOnAction (ActionEvent event){
        if(!usuarioTextField.getText().isBlank() && !senhaField.getText().isBlank()){
            validarLogin();
        }else{
            loginMessageLabel.setText("Por favor coloque um usuário e senha");
        }
        if(event.getSource() == botaoCadastrar){
            ecoPainelCadastrar();
        }

    }
    public void cancelButtonOnAction(){
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceTree ) {
        File arvoreFile = new File("imgs/arvoreGrande.jpg");
        Image arvoreImage = new Image(arvoreFile.toURI().toString());
        arvoreImageView.setImage(arvoreImage);

        File iconFile = new File("imgs/arvoreIcon.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        iconImageView.setImage(iconImage);

    }
    public void validarLogin(){
        String usuarioAdmin = "admin";
        String senhaAdmin = "admin";

        if(usuarioTextField.getText().equals(usuarioAdmin) && senhaField.getText().equals(senhaAdmin)){
            ecoPainelAdmin();
        }else{
            Cliente cliente = ClienteDAO.procurarUsuario(usuarioTextField.getText());
            if(cliente == null){
                loginMessageLabel.setText("Usuário ou Senha incorreto");

            }else if(cliente.getNome().equals(usuarioTextField.getText()) && cliente.getSenha().equals(senhaField.getText())) {
                ecoPainelCliente();

                cliente.setLogado(true);
                ClienteDAO.atualizar(cliente);
            }
        }
    }

    public void ecoPainelAdmin(){

        try{

            Parent janelaAdmin = FXMLLoader.load(getClass().getResource("ecoPainelAdmin.fxml"));
            Stage adminStage = new Stage();

            janelaAdmin.setOnMousePressed(event ->{
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();

            });

            janelaAdmin.setOnMouseDragged(event -> {

                adminStage.setX(event.getScreenX() - xOffset);
                adminStage.setY(event.getScreenY() - yOffset);

            });

            adminStage.initStyle(StageStyle.UNDECORATED);
            adminStage.setScene(new Scene(janelaAdmin));
            adminStage.show();

            Stage stage = (Stage) botaoCancelar.getScene().getWindow();
            stage.close();


        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ecoPainelCliente(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ecoPainelCliente.fxml"));
            EcoPainelClienteController controller = loader.getController();
            Node root = loader.load();
            Parent janelaCliente = FXMLLoader.load(getClass().getResource("ecoPainelCliente.fxml"));
            Stage clienteStage = new Stage();


            janelaCliente.setOnMousePressed(event ->{
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();

            });

            janelaCliente.setOnMouseDragged(event -> {

                clienteStage.setX(event.getScreenX() - xOffset);
                clienteStage.setY(event.getScreenY() - yOffset);

            });

            clienteStage.initStyle(StageStyle.UNDECORATED);
            clienteStage.setScene(new Scene(janelaCliente));
            clienteStage.show();

            Stage stage = (Stage) botaoCancelar.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ecoPainelCadastrar(){

        try{
            Parent janelaCadastrar = FXMLLoader.load(getClass().getResource("ecoCadastrar.fxml"));
            Stage CadastrarStage = new Stage();


            janelaCadastrar.setOnMousePressed(event ->{
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();

            });

            janelaCadastrar.setOnMouseDragged(event -> {

                CadastrarStage.setX(event.getScreenX() - xOffset);
                CadastrarStage.setY(event.getScreenY() - yOffset);

            });

            CadastrarStage.initStyle(StageStyle.UNDECORATED);
            CadastrarStage.setScene(new Scene(janelaCadastrar));
            CadastrarStage.show();

            Stage stage = (Stage) botaoCancelar.getScene().getWindow();
            stage.close();


        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}