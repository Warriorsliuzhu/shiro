package com.spring.controller;

import com.spring.model.Sensor;
import com.spring.service.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by Administrator on 15-5-28.
 */
@Controller
public class LoginController {
    private final String _pagePath = "index.ftl";
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SensorService sensorService;

//    @RequestMapping("")
//    public String index(Model model) {
//        System.out.println("----------------------");
//        model.addAttribute("test", "渴望光荣");
//
//        model.addAttribute("_pagePath", _pagePath);
//        return "layout";
//
//    }

//    @RequestMapping(value = "")
//    public String index(Model model) {
//        System.out.println("+++++++++++++++++++++++");
//        return "test";
//    }

    @RequestMapping(value = "login")
    public String manageView(Model model) {
        return "register";
    }

    @RequestMapping(value = "register")
    public String register(Model model) {
        return "register";
    }

    @RequestMapping(value = "getSensors")
    @ResponseBody
    List<Sensor> findSensors() {
        List<Sensor> sensors = sensorService.findSensors();
        return sensors.subList(0,2);
    }

    @RequestMapping(value = "getSensors2")
    @ResponseBody
    List<Sensor> findSensors2() {
        List<Sensor> sensors = sensorService.findSensors();
        return sensors.subList(0,2);
    }

}
