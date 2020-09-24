package com.myshop.springjava.controller;

import com.myshop.springjava.dtos.GoodsDTO;
import com.myshop.springjava.model.Goods;
import com.myshop.springjava.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public GoodsDTO getGoods(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,
                             HttpServletRequest request,
                             Principal principal) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return goodsService.getGoods(pageRequest);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Goods createGoods(@RequestBody @Valid Goods goods) {
        return goodsService.insertGoods(goods);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Goods updateGoods(@RequestBody Goods goods, @PathVariable int id) {
        goods.setId(id);
        return goodsService.updateGoods(goods);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGoods(@PathVariable int id) {
        goodsService.deleteGoods(id);
    }

}
