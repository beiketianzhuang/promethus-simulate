package com.bektz.simulator.promethussimulate.simulator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SimulatorOpts {
}
