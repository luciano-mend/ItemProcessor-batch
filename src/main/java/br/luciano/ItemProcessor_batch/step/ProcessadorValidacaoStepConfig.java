package br.luciano.ItemProcessor_batch.step;

import br.luciano.ItemProcessor_batch.dominio.Cliente;
import br.luciano.ItemProcessor_batch.dominio.ClienteTransacao;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ProcessadorValidacaoStepConfig {
    @Autowired
    public PlatformTransactionManager transactionManager;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public Step processadorValidacaoStep(
            @Qualifier("processadorClassifierReader") ItemReader processadorValidacaoReader,
            @Qualifier("processadorClassifierProcessor") ItemProcessor processadorValidacaoProcessor,
            ItemWriter processadorValidacaoWriter,
            JobRepository jobRepository) {

        return new StepBuilder("processadorValidacaoStep", jobRepository)
                .chunk(1, transactionManager)
                .reader(processadorValidacaoReader)
                .processor(processadorValidacaoProcessor)
                .writer(processadorValidacaoWriter)
                .build();
    }
}
