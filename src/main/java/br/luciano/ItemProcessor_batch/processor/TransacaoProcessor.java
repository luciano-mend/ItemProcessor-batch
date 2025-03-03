package br.luciano.ItemProcessor_batch.processor;

import br.luciano.ItemProcessor_batch.dominio.Transacao;
import org.springframework.batch.item.ItemProcessor;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {

    @Override
    public Transacao process(Transacao transacao) throws Exception {
        System.out.println("\nAplicando regras de negócio na transação " + transacao.getId());
        return transacao;
    }
}
