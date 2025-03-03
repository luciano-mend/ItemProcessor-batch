package br.luciano.ItemProcessor_batch.processor;

import br.luciano.ItemProcessor_batch.dominio.ClienteTransacao;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<ClienteTransacao, ClienteTransacao> {
    @Override
    public ClienteTransacao process(ClienteTransacao cliente) throws Exception {
        System.out.println(String.format("\nAplicando regras de negócio no cliente %s", cliente.getEmail()));
        return cliente;
    }
}
