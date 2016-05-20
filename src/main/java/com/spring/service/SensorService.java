package com.spring.service;

import com.spring.model.Sensor;
import com.spring.model.User;

import java.util.List;

/**
 * Created by LiuZhu on 2015/5/14.
 */
public interface SensorService {
    public List<Sensor> findSensors();
}
