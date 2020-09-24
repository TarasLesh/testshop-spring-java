package com.myshop.springjava.service;

import com.myshop.springjava.dtos.GoodsDTO;
import com.myshop.springjava.model.Goods;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IGoodsService {

    void deleteGoods(Integer id);

    GoodsDTO getGoods(PageRequest pageRequest);

    Goods insertGoods(Goods goods);

    Goods updateGoods(Goods goods);

}
