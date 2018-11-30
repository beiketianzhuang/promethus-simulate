package com.bektz.simulator.promethussimulate.controller;

import com.bektz.simulator.promethussimulate.simulator.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimulatorController {
    @Autowired
    private SimulatorService simulatorService;


    @RequestMapping(value = "/opts")
    public @ResponseBody
    String getOps() {
        return simulatorService.getSimulatorOpts().getOpts().toString();
    }

    @RequestMapping(value = "/spike/{mode}", method = RequestMethod.POST)
    public @ResponseBody
    String setSpikeMode(@PathVariable("mode") String mode) {
        boolean result = simulatorService.getSimulatorOpts().setSpikeMode(mode);
        if (result) {
            return "ok";
        } else {
            return "wrong " + mode;
        }
    }

    @RequestMapping(value = "error_rate/{error_rate}", method = RequestMethod.POST)
    public @ResponseBody
    String setErrorRate(@PathVariable("error_rate") int errorRate) {
        simulatorService.getSimulatorOpts().setErrorRate(errorRate);
        return "ok";
    }

}
