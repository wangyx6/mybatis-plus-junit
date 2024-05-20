package com.rachel.junit.po;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author nanzhi
 * @date 2024/5/20 17:25
 */
@Data
public class OrderReceive {

    @TableId(value = "id")
    private Long id;

    private String requestId;

    private String orderNo;

    private String requestOrderNo;
}
