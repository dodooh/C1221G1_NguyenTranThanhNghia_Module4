package com.codegym.repository.impl;

import static java.util.stream.Collectors.toList;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;


@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> getList() {
        TypedQuery<Product> tq = BaseRepository.entityManager.createQuery("select p from Product p", Product.class);
        return tq.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if (product.getId() != null) {
            BaseRepository.entityManager.merge(product);
        } else {
            BaseRepository.entityManager.persist(product);
        }
        entityTransaction.commit();
    }

    @Override
    public void remove(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }


    @Override
    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> search(String keyword) {
        TypedQuery<Product> tq = BaseRepository.entityManager.createQuery(
            "select p from Product p where p.name LIKE '%"+ keyword + "%'",
            Product.class);
        return tq.getResultList();
    }
}
