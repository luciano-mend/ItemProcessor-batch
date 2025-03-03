package br.luciano.ItemProcessor_batch.processor;

import br.luciano.ItemProcessor_batch.dominio.ClienteTransacao;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorClassifierProcessorConfig {
    @SuppressWarnings("rawtypes")
    @Bean
    public ItemProcessor processadorClassifierProcessor() {
        return new ClassifierCompositeItemProcessorBuilder<>()
                .classifier(classifier())
                .build();
    }

    private Classifier classifier() {
        return new Classifier<Object, ItemProcessor>() {
            @Override
            public ItemProcessor classify(Object objeto) {
                if (objeto instanceof ClienteTransacao) {
                    return new ClienteProcessor();
                } else {
                    return new TransacaoProcessor();
                }
            }
        };
    }
}
