package com.facai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class MenuVO {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;
    public MenuVO(int code, String msg, int count, List<Menu> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
