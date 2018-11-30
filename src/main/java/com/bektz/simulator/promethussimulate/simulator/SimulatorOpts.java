package com.bektz.simulator.promethussimulate.simulator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Data
@Configuration
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SimulatorOpts {

    @Value("${opts.endpoints}")
    private String[] endopints;

    @Value("${opts.request_rate}")
    private int requestRate;

    @Value("${opts.request_rate_uncertainty}")
    private int requestRateUncertainty;

    @Value("${opts.latency_min}")
    private int latencyMin;

    @Value("${opts.latency_p50}")
    private int latencyP50;

    @Value("${opts.latency_p90}")
    private int latencyP90;

    @Value("${opts.latency_p99}")
    private int latencyP99;

    @Value("${opts.latency_max}")
    private int latencyMax;

    @Value("${opts.latency_uncertainty}")
    private int latencyUncertainty;

    @Value("${opts.error_rate}")
    private int errorRate;

    @Value("${opts.spike_start_chance}")
    private int spikeStartChance;

    @Value("${opts.spike_end_chance}")
    private int spikeEndChance;

    private SpikeMode spikeMode = SpikeMode.OFF;

    public enum SpikeMode {

        OFF, ON, RANDOM

    }

    @Override
    public String toString() {
        return "SimulatorOpts{" +
                "endopints=" + Arrays.toString(endopints) +
                ", requestRate=" + requestRate +
                ", requestRateUncertainty=" + requestRateUncertainty +
                ", latencyMin=" + latencyMin +
                ", latencyP50=" + latencyP50 +
                ", latencyP90=" + latencyP90 +
                ", latencyP99=" + latencyP99 +
                ", latencyMax=" + latencyMax +
                ", latencyUncertainty=" + latencyUncertainty +
                ", errorRate=" + errorRate +
                ", spikeStartChance=" + spikeStartChance +
                ", spikeEndChance=" + spikeEndChance +
                ", spikeMode=" + spikeMode +
                '}';
    }
}
