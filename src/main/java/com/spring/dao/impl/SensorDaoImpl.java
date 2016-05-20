package com.spring.dao.impl;

import com.spring.dao.SensorDao;
import com.spring.model.Sensor;
import com.spring.model.User;
import com.spring.sys.BaseDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 15-5-28.
 */
@Repository
@Scope("prototype")
public class SensorDaoImpl extends BaseDao implements SensorDao {

    @Override
    public List<Sensor> findSensors() {
        return super.getSqlSession().selectList("com.spring.dao.findSensors");
    }
}
