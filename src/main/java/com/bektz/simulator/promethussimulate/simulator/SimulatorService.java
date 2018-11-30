package com.bektz.simulator.promethussimulate.simulator;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
@EnablePrometheusEndpoint
public class SimulatorService {

    @Autowired
    private SimulatorOpts opts;

    private ActivitySimulator simulator;

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public CommandLineRunner schedulingRunner(@Qualifier("taskExecutor") TaskExecutor executor) {

        return args -> {
            simulator = new ActivitySimulator(opts);
            executor.execute(simulator);
            System.out.println("Simulator thread started...");
        };
    }

    public SimulatorOpts getSimulatorOpts() {
        return opts;
    }

}
