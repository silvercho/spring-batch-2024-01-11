package com.ll.springbatch20240111;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.batch.core.Job;

    @Configuration
    @Slf4j
    public class HelloJobConfig {
        @Bean
        public Job simpleJob(JobRepository jobRepository, Step simpleStep) {
            return new JobBuilder("simpleJob", jobRepository)
                    .start(simpleStep)
                    .build();
        }

        @Bean
        public Step simpleStep(JobRepository jobRepository, Tasklet testTasklet,
                               PlatformTransactionManager platformTransactionManager) {
            return new StepBuilder("simpleStep", jobRepository)
                    .tasklet(testTasklet, platformTransactionManager)
                    .build();
        }

        @Bean
        public Tasklet testTasklet() {
            return ((contribution, chunkContext) -> {
                log.info("Hello World");
                return RepeatStatus.FINISHED;
            });
        }
    }
