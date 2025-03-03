package br.luciano.ItemProcessor_batch.writer;

import br.luciano.ItemProcessor_batch.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorValidacaoWriterConfig {
    @Bean
    public ItemWriter processadorValidacaoWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }
}
