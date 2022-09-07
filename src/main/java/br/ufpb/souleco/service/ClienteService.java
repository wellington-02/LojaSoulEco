package br.ufpb.souleco.service;

import br.ufpb.souleco.bd.ClienteDAO;
import br.ufpb.souleco.bd.VendaDAO;
import br.ufpb.souleco.classes.Cliente;
import br.ufpb.souleco.classes.Venda;

import java.util.List;

public class ClienteService {

    public static boolean cadastrar(Cliente cliente) {
        Cliente clienteRepetido = ClienteDAO.procurarClienteCpf(cliente.getCpf());

        if (clienteRepetido == null) {
            ClienteDAO.inserir(cliente);
            return true;
        } else {
            return false;
        }
    }

    public static boolean removerCliente(String cpf) {
        Cliente cliente = ClienteDAO.procurarClienteCpf(cpf);

        if (cliente != null) {
            List<Venda> comprasDoCliente = VendaDAO.procurarProdutosDoCliente(cliente.getCpf());

            for (Venda v : comprasDoCliente) {
                VendaDAO.delete(v);
            }
            ClienteDAO.delete(cliente);
            return true;
        } else {
            return false;
        }
    }

    public static List<Cliente> clientesComOnome(String nome) {
        List<Cliente> clientes = ClienteDAO.procurarClienteNome(nome);

        if (clientes != null) {
            return clientes;
        } else {
            return null;
        }
    }


}
