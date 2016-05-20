package com.spring.dao;

import com.spring.model.Sensor;

import java.util.List;

/**
 * Created by LiuZhu on 2015/5/14.
 */
public interface SensorDao {
    public List<Sensor> findSensors();
}
