package com.myshop.springjava.repository;

import com.myshop.springjava.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {

    Optional<Goods> findByArticle(String article);

    Optional<Goods> findByTitle(String title);

//    Optional<Goods> findAllByCategory(String category);

//    Optional<Goods> findAllBySubcategory(String subcategory);

}
