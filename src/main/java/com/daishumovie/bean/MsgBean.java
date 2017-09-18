package com.daishumovie.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhuruisong on 2017/9/18
 * @since 1.0
 */
@Data
public class MsgBean implements Serializable {
    private Integer id;
    private String msg;
}
