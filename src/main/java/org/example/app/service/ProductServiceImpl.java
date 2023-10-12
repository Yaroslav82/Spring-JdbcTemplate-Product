package org.example.app.service;

import org.example.app.entity.Product;
import org.example.app.repository.ProductRepositoryImpl;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service("productService")
public class ProductServiceImpl implements BaseService<Product> {

    @Autowired
    private Product product;

    @Autowired
    private ProductRepositoryImpl repository;

    @Override
    public String create(Product product) {
        String errors = validateProduct(product);
        if (!errors.isEmpty()) {
            return errors;
        }

        if (repository.create(product)) {
            return Constants.DATA_INSERT_MSG;
        } else {
            return Constants.SMTH_WRONG_MSG;
        }
    }

    @Override
    public String getAll() {
        Optional<List<Product>> optional = repository.getAll();

        if (optional.isPresent()) {
            List<Product> products = optional.get();
            return productsToString(products);
        }

        return Constants.DATA_ABSENT_MSG;
    }

    @Override
    public String getById(String id) {
        if (IdValidator.isIdValid(id)) {
            return Constants.ID_ERR_MSG;
        }

        Optional<Product> optional = repository.getById(Integer.parseInt(id));

        if (optional.isPresent()) {
            return optional.get().toString();
        }
        return Constants.DATA_ABSENT_MSG;
    }

    @Override
    public String update(Product product) {
        String errors = validateProduct(product);
        if (!errors.isEmpty()) {
            return errors;
        }

        if (repository.update(product)) {
            return Constants.DATA_UPDATE_MSG;
        } else {
            return Constants.SMTH_WRONG_MSG;
        }
    }

    @Override
    public String delete(String id) {
        if (IdValidator.isIdValid(id)) {
            return Constants.ID_ERR_MSG;
        }

        product.setId(Integer.parseInt(id));
        if (repository.delete(product)) {
            return Constants.DATA_DELETE_MSG;
        }
        return Constants.SMTH_WRONG_MSG;
    }

    private String productsToString(List<Product> products) {
        AtomicInteger count = new AtomicInteger(0);
        StringBuilder stringBuilder = new StringBuilder();
        products.forEach((product) ->
                stringBuilder.append(count.incrementAndGet())
                        .append(") ")
                        .append(product.toString())
        );
        return stringBuilder.toString();
    }

    private String validateProduct(Product product) {
        StringBuilder stringBuilder = new StringBuilder();

        if (product.getName().isEmpty()) {
            stringBuilder.append(errorMsgBuilder("name"));
        }
        if (Objects.isNull(product.getQuota())) {
            stringBuilder.append(errorMsgBuilder("quota"));
        }
        if (Objects.isNull(product.getPrice())) {
            stringBuilder.append(errorMsgBuilder("price"));
        }

        return stringBuilder.toString();
    }

    private String errorMsgBuilder(String inputName) {
        return "\n>> " + inputName + ": " + Constants.INPUT_REQ_MSG;
    }
}
