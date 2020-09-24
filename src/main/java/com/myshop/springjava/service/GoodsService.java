package com.myshop.springjava.service;

import com.myshop.springjava.dtos.GoodsDTO;
import com.myshop.springjava.model.Goods;
import com.myshop.springjava.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GoodsService implements IGoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public void deleteGoods(Integer id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public GoodsDTO getGoods(PageRequest pageRequest) {
        Page<Goods> goodsPage = goodsRepository.findAll(pageRequest);
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setGoods(goodsPage.getContent());
        goodsDTO.setEmpty(goodsPage.isEmpty());
        goodsDTO.setLast(goodsPage.isLast());
        goodsDTO.setPagesCount(goodsPage.getTotalPages());
        goodsDTO.setTotalElements(goodsPage.getNumberOfElements());
        return goodsDTO;
    }

    @Override
    public Goods insertGoods(Goods goods) {
        if (goodsRepository.findByArticle(goods.getArticle()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Goods with this Article already exists!");
        } else if (goodsRepository.findByTitle(goods.getTitle()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Goods with this Title already exists!");
        } else {
            return goodsRepository.save(goods);
        }
    }

    @Override
    public Goods updateGoods(Goods goods) {
        if (!goodsRepository.findByArticle(goods.getArticle()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Goods with this Article");
        } else if (!goodsRepository.findByTitle(goods.getTitle()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Goods with this Title");
        } else {
            return goodsRepository.save(goods);
        }
    }
}
