package br.ufpb.souleco;

import br.ufpb.souleco.bd.ClienteDAO;
import br.ufpb.souleco.bd.ProdutoDAO;
import br.ufpb.souleco.bd.QuemSomosDAO;
import br.ufpb.souleco.bd.VendaDAO;
import br.ufpb.souleco.classes.Cliente;
import br.ufpb.souleco.classes.Produto;
import br.ufpb.souleco.classes.Venda;
import br.ufpb.souleco.service.ClienteService;
import br.ufpb.souleco.service.ProdutoService;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class EcoPainelAdminController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    private String caminhoFoto;


    @FXML
    private Label menu;
    @FXML
    private Label menuClose;
    @FXML
    private Label cadProdutoMessageLabel;
    @FXML
    private Label resultadoPesMessageLabel;
    @FXML
    private Label resulPesClienteMessageLabel;
    @FXML
    private Label removerMessageLabel;
    @FXML
    private Label removerUserMessageLabel;
    @FXML
    private Label homeMessageLabel;
    @FXML
    private Label todosClientesMessageLabel;
    @FXML
    private Label editarMessageLabel;
    @FXML
    private Label vendasMessageLabel;
    @FXML
    private Label valorTotalRecebidoMessageLabel;
    @FXML
    private VBox slider;
    @FXML
    private TextField nomeCadProduto;
    @FXML
    private TextField precoCadProduto;
    @FXML
    private TextField quantidadeCadProduto;
    @FXML
    private TextField produtoPesField;
    @FXML
    private TextField clientePesTextField;
    @FXML
    private TextField removerUserField;
    @FXML
    private TextField removerProdutoField;
    @FXML
    private TextArea editarQuemSomosMessage;
    @FXML
    private ImageView addCadProdutoIcon;
    @FXML
    private ImageView pesUserIcon;
    @FXML
    private ImageView removerUserIcon;
    @FXML
    private ImageView homeIcon;
    @FXML
    private ImageView addIcon;
    @FXML
    private ImageView pesquisarIcon;
    @FXML
    private ImageView removerIcon;
    @FXML
    private ImageView arvoreIcon;
    @FXML
    private ImageView fecharIcon;
    @FXML
    private ImageView pesquisarIcon2;
    @FXML
    private ImageView pesquisarClienteIcon2;
    @FXML
    private ImageView removerIcon2;
    @FXML
    private ImageView removerUserIcon2;
    @FXML
    private ImageView logoutIcon;
    @FXML
    private ImageView imgFoto;
    @FXML
    private ImageView fotoProdPes;
    @FXML
    private ImageView todosClientesIcon;
    @FXML
    private ImageView quemSomosIcon;
    @FXML
    private ImageView vendasIcon;
    @FXML
    private Button btnFechar;
    @FXML
    private Button btnPesUser;
    @FXML
    private Button btnRemoverUser;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnPesquisar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnTodosClientes;
    @FXML
    private Button btnQuemSomos;
    @FXML
    private Button btnVendas;
    @FXML
    private GridPane pnlCadProduto;
    @FXML
    private AnchorPane pnlPesquisaProduto;
    @FXML
    private AnchorPane pnlPesquisaCliente;
    @FXML
    private AnchorPane pnlRemoverProduto;
    @FXML
    private AnchorPane pnlRemoverUser;
    @FXML
    private ScrollPane pnlHome;
    @FXML
    private AnchorPane pnlTodosClientes;
    @FXML
    private AnchorPane pnlQuemSomos;
    @FXML
    private AnchorPane pnlVendas;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File arvoreFile = new File("imgs/arvoreIcon.png");
        Image arvoreImage = new Image(arvoreFile.toURI().toString());
        arvoreIcon.setImage(arvoreImage);

        File fecharFile = new File("imgs/closeRed.png");
        Image fecharImage = new Image(fecharFile.toURI().toString());
        fecharIcon.setImage(fecharImage);

        File homeFile = new File("imgs/homeB2.png");
        Image homeImage = new Image(homeFile.toURI().toString());
        homeIcon.setImage(homeImage);

        File addFile = new File("imgs/addBlack.png");
        Image addImage = new Image(addFile.toURI().toString());
        addIcon.setImage(addImage);

        File addCadProdutoFile = new File("imgs/add.png");
        Image addCadProdutoImage = new Image(addCadProdutoFile.toURI().toString());
        addCadProdutoIcon.setImage(addCadProdutoImage);

        File pesquisarFile = new File("imgs/searchB.png");
        Image pesquisarImage = new Image(pesquisarFile.toURI().toString());
        pesquisarIcon.setImage(pesquisarImage);

        File pesquisar2File = new File("imgs/searchW.png");
        Image pesquisar2Image = new Image(pesquisar2File.toURI().toString());
        pesquisarIcon2.setImage(pesquisar2Image);

        File pesUserFile = new File("imgs/searchUserW.png");
        Image pesUserImage = new Image(pesUserFile.toURI().toString());
        pesUserIcon.setImage(pesUserImage);

        File pesClienteFile = new File("imgs/searchUserW.png");
        Image pesClienteImage = new Image(pesClienteFile.toURI().toString());
        pesquisarClienteIcon2.setImage(pesClienteImage);

        File removerFile = new File("imgs/removeB.png");
        Image removerImage = new Image(removerFile.toURI().toString());
        removerIcon.setImage(removerImage);

        File remover2File = new File("imgs/removeW.png");
        Image remover2Image = new Image(remover2File.toURI().toString());
        removerIcon2.setImage(remover2Image);

        File removerUserFile = new File("imgs/removeW.png");
        Image removerUserImage = new Image(removerUserFile.toURI().toString());
        removerUserIcon.setImage(removerUserImage);

        File removerUser2File = new File("imgs/removeW.png");
        Image removerUser2Image = new Image(removerUser2File.toURI().toString());
        removerUserIcon2.setImage(removerUser2Image);

        File logoutFile = new File("imgs/logout.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutIcon.setImage(logoutImage);

        File imgFotoFile = new File("imgs/sem-foto.jpg");
        Image imgFotoImage = new Image(imgFotoFile.toURI().toString());
        imgFoto.setImage(imgFotoImage);

        File todosClientesFile = new File("imgs/todosClientes.png");
        Image todosClientesImage = new Image(todosClientesFile.toURI().toString());
        todosClientesIcon.setImage(todosClientesImage);

        File quemSomosFile = new File("imgs/quemSomos.png");
        Image quemSomosImage = new Image(quemSomosFile.toURI().toString());
        quemSomosIcon.setImage(quemSomosImage);

        File vendasFile = new File("imgs/vendas.png");
        Image vendasImage = new Image(vendasFile.toURI().toString());
        vendasIcon.setImage(vendasImage);


        imgFoto.setOnMouseClicked((MouseEvent e) -> {
            selecionarFoto();
        });


        slider.setTranslateX(-209);
        menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-209);

            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(false);
                menuClose.setVisible(true);
            });
        });
        menuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(slider);

            slide.setToX(-209);
            slide.play();

            slider.setTranslateX(-209);

            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(true);
                menuClose.setVisible(false);

            });
        });


    }

    public void selecionarFoto() {
        FileChooser f = new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.jpg", "*.png", "*.jpeg"));
        File file = f.showOpenDialog(new Stage());
        if (file != null) {
            imgFoto.setImage(new Image("file:///" + file.getAbsolutePath()));
            caminhoFoto = file.getAbsolutePath();
        }
    }

    @FXML
    public void CadProdutoButtonOnAction(ActionEvent event) {

        if (!nomeCadProduto.getText().isBlank() && !precoCadProduto.getText().isBlank() && !quantidadeCadProduto.getText().isBlank()) {

            String precoString = precoCadProduto.getText();
            double preco = Double.parseDouble(precoString);
            String quantString = quantidadeCadProduto.getText();
            int quant = Integer.parseInt(quantString);

            Produto p = new Produto(nomeCadProduto.getText(), preco, quant, caminhoFoto);

            boolean cadastrou = ProdutoService.cadastrar(p);
            if (cadastrou) {
                cadProdutoMessageLabel.setText("Produto cadastrado com sucesso");

            } else {
                cadProdutoMessageLabel.setText("Já existe produto com esse nome");
            }
        } else {
            cadProdutoMessageLabel.setText("Por favor digite todas as informações do produto");
        }
    }

    @FXML
    public void PesquisarProdutoButtonOnAction(ActionEvent event) {
        if (!produtoPesField.getText().isBlank()) {

            Produto produto = ProdutoService.procurarProduto(produtoPesField.getText());
            if (produto != null) {
                if (produto.getFoto() != null) {
                    fotoProdPes.setImage(new Image(produto.getFoto()));
                }
                resultadoPesMessageLabel.setText(produto.toString());
            } else {
                resultadoPesMessageLabel.setText("Não existe produto com esse nome");
            }
        } else {
            resultadoPesMessageLabel.setText("Por favor digite um nome");
        }
    }

    @FXML
    public void PesquisarClienteButtonOnAction(ActionEvent event) {

        if (!clientePesTextField.getText().isBlank()) {
            List<Cliente> clientes = ClienteService.clientesComOnome(clientePesTextField.getText());

            if (clientes != null) {
                StringBuffer stringBuffer = new StringBuffer();

                for (Cliente c : clientes) {
                    stringBuffer.append(c.getNome().toUpperCase());
                    stringBuffer.append("\nCPF: ");
                    stringBuffer.append(c.getCpf());
                    stringBuffer.append("\nCep: ");
                    stringBuffer.append(c.getCep());
                    stringBuffer.append("\n");
                    stringBuffer.append("-------------------------------------");
                    stringBuffer.append("\n");
                }
                resulPesClienteMessageLabel.setText(stringBuffer.toString());
            } else {
                resulPesClienteMessageLabel.setText("Não existe produto com esse nome");
            }
        } else {
            resulPesClienteMessageLabel.setText("Por favor digite um nome");
        }
    }

    @FXML
    public void RemoverProdutoButtonOnAction(ActionEvent event) {

        if (!removerProdutoField.getText().isBlank()) {
            boolean produto = ProdutoService.removerProduto(removerUserField.getText());
            if (produto) {
                removerMessageLabel.setText("Deletado com sucesso");
            } else {
                removerMessageLabel.setText("Não existe produto com esse nome");
            }
        } else {
            removerMessageLabel.setText("Digite um nome");
        }
    }

    @FXML
    public void RemoverUserButtonOnAction(ActionEvent event) {

        if (!removerUserField.getText().isBlank()) {
            boolean clienteRemovido = ClienteService.removerCliente(removerUserField.getText());
            if (clienteRemovido) {
                removerUserMessageLabel.setText("Deletado com sucesso");
            } else {
                removerUserMessageLabel.setText("Não existe cliente com esse Cpf");
            }
        } else {
            removerUserMessageLabel.setText("Digite um Cpf");
        }
    }
    @FXML
    public void salvarQuemSomosOnAction(ActionEvent event) {
        QuemSomosDAO.atualizar(editarQuemSomosMessage.getText());
        editarMessageLabel.setText("Edição Salva");
    }

    @FXML
    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void logoutButtonOnAction(ActionEvent event) {
        closeButtonOnAction(event);
        ecoPainelLogin();
    }

    @FXML
    private void handleClicks(ActionEvent event) {

        if (event.getSource() == btnPesUser) {
            pnlPesquisaCliente.toFront();

        } else if (event.getSource() == btnRemoverUser) {
            pnlRemoverUser.toFront();

        } else if (event.getSource() == btnTodosClientes) {
            pnlTodosClientes.toFront();

            StringBuffer stringBuffer = new StringBuffer();

            Collection<Cliente> todosClientes = ClienteDAO.todosClientes();

            for (Cliente c : todosClientes) {
                stringBuffer.append(c.getNome().toUpperCase());
                stringBuffer.append("\nCpf: ");
                stringBuffer.append(c.getCpf());
                stringBuffer.append("\nCep: ");
                stringBuffer.append(c.getCep());
                stringBuffer.append("\n");
                stringBuffer.append("-------------------------------------");
                stringBuffer.append("\n");

            }
            todosClientesMessageLabel.setText(stringBuffer.toString());

        } else if (event.getSource() == btnAdd) {
            pnlCadProduto.toFront();

        } else if (event.getSource() == btnPesquisar) {
            pnlPesquisaProduto.toFront();

        } else if (event.getSource() == btnRemover) {
            pnlRemoverProduto.toFront();

        } else if (event.getSource() == btnVendas) {
            pnlVendas.toFront();

            List<Venda> todasVendas = VendaDAO.todasVendas();
            StringBuffer stringBuffer = new StringBuffer();
            double precoTotal = 0;

            for (Venda venda : todasVendas) {
                Produto produto = ProdutoDAO.procurarProdutoNome(venda.getNomeProduto());
                Cliente cliente = ClienteDAO.procurarClienteCpf(venda.getCpfCliente());
                precoTotal += produto.getPreco();

                stringBuffer.append(venda.getNomeProduto());
                stringBuffer.append("\nPreço: ");
                stringBuffer.append(produto.getPreco());
                stringBuffer.append("\nData da Compra: ");
                stringBuffer.append(venda.getDataDaVenda());
                stringBuffer.append("\nCliente que Comprou: ");
                stringBuffer.append(cliente.getNome());
                stringBuffer.append("\nCpf: ");
                stringBuffer.append(venda.getCpfCliente());
                stringBuffer.append("\nCep: ");
                stringBuffer.append(cliente.getCep());
                stringBuffer.append("\n");
                stringBuffer.append("-------------------------------------------");
                stringBuffer.append("\n");
            }
            vendasMessageLabel.setText(stringBuffer.toString());
            valorTotalRecebidoMessageLabel.setText("R$: " + precoTotal);

        } else if (event.getSource() == btnQuemSomos) {
            pnlQuemSomos.toFront();

            String textoQuemSomos = QuemSomosDAO.pegarDescricao();

            editarQuemSomosMessage.setText(textoQuemSomos);

        } else if (event.getSource() == btnHome) {
            pnlHome.toFront();
            StringBuffer stringBuffer = new StringBuffer();

            Collection<Produto> todosProdutos = ProdutoDAO.todosProdutos();

            for (Produto p : todosProdutos) {
                stringBuffer.append(p.getNome().toUpperCase());
                stringBuffer.append("\nPreço: ");
                stringBuffer.append(p.getPreco());
                stringBuffer.append("\nQuantidade: ");
                stringBuffer.append(p.getQuantidadeEmEstoque());
                stringBuffer.append("\n");
                stringBuffer.append("-------------------------------------");
                stringBuffer.append("\n");

            }
            homeMessageLabel.setText(stringBuffer.toString());
        }
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
