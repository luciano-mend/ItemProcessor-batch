package br.luciano.ItemProcessor_batch.step;

import br.luciano.ItemProcessor_batch.dominio.Cliente;
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

    @Bean
    public Step processadorValidacaoStep(
            ItemReader<Cliente> processadorValidacaoReader,
            @Qualifier("processadorScriptProcessor") ItemProcessor<Cliente, Cliente> processadorValidacaoProcessor,
            ItemWriter<Cliente> processadorValidacaoWriter,
            JobRepository jobRepository) {

        return new StepBuilder("processadorValidacaoStep", jobRepository)
                .<Cliente, Cliente>chunk(1, transactionManager)
                .reader(processadorValidacaoReader)
                .processor(processadorValidacaoProcessor)
                .writer(processadorValidacaoWriter)
                .build();
    }
}
