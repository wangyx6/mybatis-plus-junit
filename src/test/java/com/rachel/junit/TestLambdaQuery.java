package com.rachel.junit;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rachel.junit.mapper.OrderMapper;
import com.rachel.junit.po.OrderReceive;
import com.rachel.junit.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * @author nanzhi
 * @date 2024/5/20 17:29
 */
@RunWith(MockitoJUnitRunner.class)
public class TestLambdaQuery {
    @Mock
    private OrderService orderService;


    @Before
    public void setUp() {
        // Mock 数据准备
        OrderReceive orderReceive = new OrderReceive();
        orderReceive.setRequestId("testRequestId");
        orderReceive.setRequestOrderNo("testRequestOrderNo");
        orderReceive.setOrderNo("testOrderNo");

        Page<OrderReceive> mockPage = new Page<>();
        mockPage.setRecords(Collections.singletonList(orderReceive));
        mockPage.setSize(1);
        LambdaQueryChainWrapper<OrderReceive> orderReceiveLambdaQueryChainWrapper = new LambdaQueryChainWrapper<>(mock(OrderMapper.class));

        when(orderService.lambdaQuery()).thenReturn(orderReceiveLambdaQueryChainWrapper);
        when(orderReceiveLambdaQueryChainWrapper.page(mockPage)).thenReturn(mockPage);
    }

    @Test
    public void testQuery() throws Exception {
        Page<OrderReceive> page = orderService.lambdaQuery().page(new Page<>(1, 20));
        Assert.assertNotNull(page);

    }


}
