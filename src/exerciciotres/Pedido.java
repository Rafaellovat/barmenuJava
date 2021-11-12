package exerciciotres;

import java.util.*;
import java.time.*;

public class Pedido
{
    private int pedidoId;
    private LocalDateTime dataEmissao = LocalDateTime.MIN;
    private static HashMap<String, Float> itensDoPedido;
    private float valorDoProduto;
    private String descricaoDoProduto;
    public static int contador = 1;
    public Pedido(float valorDoProduto, String descricaoDoProduto)
    {
        itensDoPedido = new HashMap<String, Float>();
        dataEmissao = LocalDateTime.now();
        this.valorDoProduto = valorDoProduto;
        this.descricaoDoProduto = descricaoDoProduto;
        pedidoId = contador;
    }
    public final int getPedidoId()
    {
        return pedidoId;
    }
    public final LocalDateTime getDataEmissao()
    {
        return dataEmissao;
    }
    public final float getValorDoProduto()
    {
        return valorDoProduto;
    }
    public final String getDescricaoDoProduto()
    {
        return descricaoDoProduto;
    }

}
