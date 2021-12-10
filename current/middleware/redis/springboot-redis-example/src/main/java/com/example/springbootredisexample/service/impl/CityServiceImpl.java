package com.example.springbootredisexample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootredisexample.dal.mapper.CityMapper;
import com.example.springbootredisexample.dal.model.City;
import com.example.springbootredisexample.service.ICityService;
import org.springframework.stereotype.Service;

/**
 * @author ld
 * @date 2021/7/19 22:56
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {
}
