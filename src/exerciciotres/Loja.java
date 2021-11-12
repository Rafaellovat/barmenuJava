package exerciciotres;

import java.util.*;

public class Loja {
    private static ArrayList<Pedido> listaPedidos;
    private String nomeDaLoja;
    private static float valorTotal = 0F;

    public Loja(String nomeDaLoja) {
        this.nomeDaLoja = nomeDaLoja;
        listaPedidos = new ArrayList<Pedido>();
        System.out.println(String.format("Seja bem vindo ao %1$s!", nomeDaLoja));
    }

    public static void Menu() {
        Scanner read = new Scanner(System.in);
        System.out.println("---------- Bem Vindo ao bar ----------");
        System.out.println("1 - Inserir Pedido");
        System.out.println("2 - Buscar Pedido");
        System.out.println("3 - Remover Pedido");
        System.out.println("0 - Fechar o programa");
        System.out.print("Digite a opção desejada: ");
        try {
            String resposta;
            resposta = read.next();
            switch (resposta) {
                case "0":
                    System.out.println("");
                    System.out.println("Obrigado por utilizar o nosso bar!");
                    System.out.println("Volte sempre!");
                    System.exit(-10);
                    break;

                case "1":
                    InserirPedido();
                    break;

                case "2":
                    BuscarPedido();
                    break;

                case "3":
                    RemoverPedido();
                    break;

                default:
                    System.out.println("");
                    System.out.println("ERRO! Escolha uma opção válida!");
                    Menu();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("");
            System.out.println("ERRO! Escolha uma opção válida!");
            Menu();
        }
    }

    public static void InserirPedido() {
        System.out.println("---------- Inserir Pedido ----------");
        System.out.println("");
        System.out.println("1 - Suco = 6.90R$");
        System.out.println("2 - Agua = 2.50R$");
        System.out.println("3 - Fanta = 4.99R$");
        System.out.println("4 - Brahma = 3.99R$");
        System.out.println("5 - Skol = 3.80R$");
        System.out.println("6 - Stella = 7.39R$");
        System.out.println("");
        Escolha();
    }

    public static void Escolha() {
        System.out.print("Qual item você quer inserir? ");
        String opcao = new Scanner(System.in).nextLine();
        System.out.println("");
        switch (opcao) {
            case "1":
                System.out.println("Você inseriu Suco. Valor R$6.90");
                Pedido p1 = new Pedido(6.9F, "Suco");
                listaPedidos.add(p1);
                valorTotal += 6.9F;
                Pedido.contador++;
                break;

            case "2":
                System.out.println("Você inseriu Agua. Valor R$2.50.");
                Pedido p2 = new Pedido(2.5F, "Agua");
                listaPedidos.add(p2);
                valorTotal += 2.5F;
                Pedido.contador++;
                break;

            case "3":
                System.out.println("Você inseriu Fanta. Valor R$4,99.");
                Pedido p3 = new Pedido(4.99F, "Fanta");
                listaPedidos.add(p3);
                valorTotal += 4.99F;
                Pedido.contador++;
                break;

            case "4":
                System.out.println("Você inseriu Brahma. Valor R$3,99.");
                Pedido p4 = new Pedido(3.99F, "Brahma");
                listaPedidos.add(p4);
                valorTotal += 3.99F;
                Pedido.contador++;
                break;

            case "5":
                System.out.println("Você inseriu Skol. Valor R$3,80.");
                Pedido p5 = new Pedido(3.8F, "Skol");
                listaPedidos.add(p5);
                valorTotal += 3.8F;
                Pedido.contador++;
                break;

            case "6":
                System.out.println("Você inseriu Stella. Valor R$7,39.");
                Pedido p6 = new Pedido(7.39F, "Stella");
                listaPedidos.add(p6);
                valorTotal += 7.39F;
                Pedido.contador++;
                break;
            default:
                System.out.println("ERRO! Digite um dos itens acima!");
                Escolha();
        }
        SegundoMenu();
    }

    public static void SegundoMenu() {
        Scanner read = new Scanner(System.in);
        System.out.println("Quer mais alguma bebida ?");
        System.out.println("");
        System.out.println("1 - Adicionar mais bebidas");
        System.out.println("2 - Remover alguma bebida");
        System.out.println("3 - Finalizar compra");
        System.out.println("0 - Voltar ao bar");
        System.out.println("");
        System.out.println("Opção: ");

        String resposta = read.next();
        switch (resposta) {
            case "1":
                InserirPedido();
                break;

            case "2":
                RemoverPedido();
                break;

            case "3":
                CalcularPrecoTotal();
                break;

            case "0":
                Menu();
                break;

            default:
                System.out.println("Erro! Opção inválida!");
                System.out.println("");
				SegundoMenu();
        }
    }

    public static void BuscarPedido()
    {
        System.out.println("---------- Buscar Pedido ----------");
        System.out.println("");

        for (var item : listaPedidos)
        {
            System.out.println(String.format("ID: %1$s\t Data de Emissão: %2$s\tValor: R$%3$s \tDesc. Produto: %4$s", item.getPedidoId(), item.getDataEmissao(), item.getValorDoProduto(), item.getDescricaoDoProduto()));
        }
        System.out.println("");
        Menu();
    }

    public static void RemoverPedido() {
        System.out.println("---------- Remover Item ----------");
        System.out.println("");
        for (var item : listaPedidos) {
            System.out.println(String.format("ID: %1$s\t Data de Emissão: %2$s\tValor: R$%3$s \tDesc. Produto: %4$s", item.getPedidoId(), item.getDataEmissao(), item.getValorDoProduto(), item.getDescricaoDoProduto()));
        }
        System.out.println("");
        RemoverPedido2();
    }
    public static void RemoverPedido2(){
        System.out.print("Qual o número do item que você deseja remover? ");
        int resposta = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("");
        boolean encontrou = false;
        for (var item : listaPedidos)
        {
            if (resposta == item.getPedidoId())
            {
                listaPedidos.remove(item);
                System.out.println(String.format("item %1$s foi removido com sucesso!", item.getDescricaoDoProduto()));
                System.out.println();
                valorTotal -= item.getValorDoProduto();
                encontrou = true;
                CalcularPrecoTotal();
                break;
            }
        }
        if (encontrou == false)
        {
            System.out.println("ERRO! Digite um ID de item válido!");
			RemoverPedido2();
        }
    }

    public static void CalcularPrecoTotal() {
        System.out.println("-------- Total --------");
        System.out.println("");
        for (var item : listaPedidos) {
            System.out.println(String.format("ID: %1$s\t Data de Emissão: %2$s\tValor: R$%3$s \tDesc. Produto: %4$s", item.getPedidoId(), item.getDataEmissao(), item.getValorDoProduto(), item.getDescricaoDoProduto()));
        }
        System.out.println("");
        System.out.println("Valor Total: " + valorTotal);
    }

}