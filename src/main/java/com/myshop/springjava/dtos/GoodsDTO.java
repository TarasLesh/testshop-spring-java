package com.myshop.springjava.dtos;

import com.myshop.springjava.model.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GoodsDTO {
    private List<Goods> goods;
    private int totalElements;
    private int pagesCount;
    private boolean isLast;
    private boolean isEmpty;
}
