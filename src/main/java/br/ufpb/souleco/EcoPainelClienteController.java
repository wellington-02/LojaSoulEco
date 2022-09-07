package br.ufpb.souleco;

import br.ufpb.souleco.bd.ClienteDAO;
import br.ufpb.souleco.bd.ProdutoDAO;
import br.ufpb.souleco.bd.QuemSomosDAO;
import br.ufpb.souleco.bd.VendaDAO;
import br.ufpb.souleco.classes.Cliente;
import br.ufpb.souleco.classes.Produto;
import br.ufpb.souleco.classes.Venda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class EcoPainelClienteController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    private List<Produto> produtosNoCarrinho = new ArrayList<>();

    @FXML
    private Label resultadoPesMessageLabel;
    @FXML
    private Label homeMessageLabel;
    @FXML
    private Label carrinhoPrecoTotal;
    @FXML
    private TextField produtoPesField;
    @FXML
    private ImageView homeIcon;
    @FXML
    private ImageView pesquisarIcon;
    @FXML
    private ImageView arvoreIcon;
    @FXML
    private ImageView fecharIcon;
    @FXML
    private ImageView pesquisarIcon2;
    @FXML
    private ImageView fotoProdPes;
    @FXML
    private ImageView carrinhoDeCompraIcon;
    @FXML
    private ImageView compraIcon;
    @FXML
    private ImageView quemSomosIcon;
    @FXML
    private ImageView logoutIcon;
    @FXML
    private Button btnPesquisar;
    @FXML
    private Button btnHome;
    @FXML
    private Button addCarrinho;
    @FXML
    private Button btnCarrinho;
    @FXML
    private Button btnCompra;
    @FXML
    private Button btnQuemSomos;
    @FXML
    private Button btnLogout;
    @FXML
    private Pane escondeAddCarrinho;
    @FXML
    private AnchorPane pnlPesquisaProduto;
    @FXML
    private AnchorPane pnlHome;
    @FXML
    private AnchorPane pnlCarrinho;
    @FXML
    private AnchorPane pnlCompra;
    @FXML
    private AnchorPane pnlQuemSomos;
    @FXML
    private Label scrollCarrinho;
    @FXML
    private Label scrollCompra;
    @FXML
    private Label scrollQuemSomos;
    @FXML
    private Label mensagemBtnAddCarrinho;


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

        File pesquisarFile = new File("imgs/searchB.png");
        Image pesquisarImage = new Image(pesquisarFile.toURI().toString());
        pesquisarIcon.setImage(pesquisarImage);

        File pesquisar2File = new File("imgs/searchW.png");
        Image pesquisar2Image = new Image(pesquisar2File.toURI().toString());
        pesquisarIcon2.setImage(pesquisar2Image);

        File carrinhoDeCompraFile = new File("imgs/carrinhoDeCompra.png");
        Image carrinhoDeCompraImage = new Image(carrinhoDeCompraFile.toURI().toString());
        carrinhoDeCompraIcon.setImage(carrinhoDeCompraImage);

        File compraFile = new File("imgs/compra.png");
        Image compraImage = new Image(compraFile.toURI().toString());
        compraIcon.setImage(compraImage);

        File quemSomosFile = new File("imgs/quemSomos.png");
        Image quemSomosImage = new Image(quemSomosFile.toURI().toString());
        quemSomosIcon.setImage(quemSomosImage);

        File logoutFile = new File("imgs/logout.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutIcon.setImage(logoutImage);

    }

    public void PesquisarProdutoButtonOnAction(ActionEvent event) {
        escondeAddCarrinho.toFront();
        mensagemBtnAddCarrinho.setText(" ");

        if (!produtoPesField.getText().isBlank()) {
            Produto produto = ProdutoDAO.procurarProdutoNome(produtoPesField.getText());
            if (produto != null) {
                if (produto.getFoto() == null || produto.getFoto().equals("")) {
                    File fotoProdPesFile = new File("imgs/branco.jpg");
                    Image fotoProdPesImage = new Image(fotoProdPesFile.toURI().toString());
                    fotoProdPes.setImage(fotoProdPesImage);

                } else {
                    fotoProdPes.setImage(new Image(produto.getFoto()));
                }
                resultadoPesMessageLabel.setText(produto.toString());
                addCarrinho.toFront();
            } else {
                resultadoPesMessageLabel.setText("Não existe produto com esse nome");

                File fotoProdPesFile = new File("imgs/branco.jpg");
                Image fotoProdPesImage = new Image(fotoProdPesFile.toURI().toString());
                fotoProdPes.setImage(fotoProdPesImage);
            }
        } else {
            resultadoPesMessageLabel.setText("Por favor digite um nome");

            File fotoProdPesFile = new File("imgs/branco.jpg");
            Image fotoProdPesImage = new Image(fotoProdPesFile.toURI().toString());
            fotoProdPes.setImage(fotoProdPesImage);

        }
    }

    public void closeButtonOnAction(ActionEvent event) {
        Cliente c = ClienteDAO.procurarUsuarioLogado(true);
        c.setLogado(false);
        ClienteDAO.atualizar(c);

        Stage stage = (Stage) fecharIcon.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addProdCarrinhoOnAction(ActionEvent event) {
        Produto produto = ProdutoDAO.procurarProdutoNome(produtoPesField.getText());
        produtosNoCarrinho.add(produto);
        mensagemBtnAddCarrinho.setText("Produto adicionado ao carrinho");
    }

    @FXML
    public void ComprarButtonOnAction(ActionEvent event) {
        Cliente c = ClienteDAO.procurarUsuarioLogado(true);

        for (Produto p : produtosNoCarrinho) {
            int quanti = p.getQuantidadeEmEstoque();
            quanti = quanti - 1;
            p.setQuantidadeEmEstoque(quanti);
            ProdutoDAO.atualizarQuanti(p);

            VendaDAO.inserir(p, c);
        }
    }
    @FXML
    public void logoutButtonOnAction(ActionEvent event){
        closeButtonOnAction(event);
        ecoPainelLogin();
    }

    @FXML
    private void handleClicks(ActionEvent event) {

        if (event.getSource() == btnHome) {
            pnlHome.toFront();
            StringBuffer stringBuffer = new StringBuffer();

            Collection<Produto> todosProdutos = ProdutoDAO.todosProdutos();
            for (Produto p : todosProdutos) {
                stringBuffer.append(p.getNome().toUpperCase());
                stringBuffer.append("\nPreço: ");
                stringBuffer.append(p.getPreco());
                stringBuffer.append("\nQuantidade disponivel: ");
                stringBuffer.append(p.getQuantidadeEmEstoque());
                stringBuffer.append("\n");
                stringBuffer.append("-----------------------------------------");
                stringBuffer.append("\n");
            }
            homeMessageLabel.setText(stringBuffer.toString());
        }
        else if (event.getSource() == btnPesquisar) {
            pnlPesquisaProduto.toFront();

        }
        else if (event.getSource() == btnCarrinho) {
            pnlCarrinho.toFront();

            double precoTotalSoma = 0;
            StringBuffer stringBuffer = new StringBuffer();

            for (Produto p : produtosNoCarrinho) {
                stringBuffer.append(p.getNome());
                stringBuffer.append("\nPreço: ");
                stringBuffer.append(p.getPreco());
                stringBuffer.append("\n");
                stringBuffer.append("--------------------------------");
                stringBuffer.append("\n");

                precoTotalSoma += p.getPreco();

            }
            carrinhoPrecoTotal.setText("R$: " + precoTotalSoma);
            scrollCarrinho.setText(stringBuffer.toString());

        }
        else if (event.getSource() == btnCompra) {
            pnlCompra.toFront();
            Cliente clienteLogado = ClienteDAO.procurarUsuarioLogado(true);
            List<Venda> produtosDoCliente = VendaDAO.procurarProdutosDoCliente(clienteLogado.getCpf());


            StringBuffer stringBuffer = new StringBuffer();


            for (Venda v : produtosDoCliente) {
                Produto p = ProdutoDAO.procurarProdutoNome(v.getNomeProduto());

                stringBuffer.append(v.getNomeProduto());
                stringBuffer.append("\nPreço: ");
                stringBuffer.append(p.getPreco());
                stringBuffer.append("\nData da Compra: ");
                stringBuffer.append(v.getDataDaVenda());
                stringBuffer.append("\n");
                stringBuffer.append("-------------------------------------------");
                stringBuffer.append("\n");
            }
            scrollCompra.setText(stringBuffer.toString());
        }
        else if (event.getSource() == btnQuemSomos) {
            pnlQuemSomos.toFront();
            scrollQuemSomos.setText(QuemSomosDAO.pegarDescricao());

        }
    }

    public void ecoPainelLogin(){
        try{
            Parent painelLogin = FXMLLoader.load(getClass().getResource("ecoLogin.fxml"));
            Stage loginStage = new Stage();

            painelLogin.setOnMousePressed(event ->{
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
