package com.rachel.junit.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rachel.junit.mapper.OrderMapper;
import com.rachel.junit.po.OrderReceive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @date 2024/5/20 17:23
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderReceive> implements OrderService{

}
