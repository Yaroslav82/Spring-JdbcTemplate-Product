package org.example.app.controller;

import org.example.app.entity.Product;
import org.example.app.service.ProductServiceImpl;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("productControllerImpl")
public class ProductControllerImpl implements BaseController {

    @Autowired
    private AppView appView;
    @Autowired
    private ProductCreateView createView;
    @Autowired
    private ProductReadView readView;
    @Autowired
    private ProductReadByIdView readByIdView;
    @Autowired
    private ProductUpdateView updateView;
    @Autowired
    private ProductDeleteView deleteView;
    @Autowired
    private ProductServiceImpl serviceImpl;

    public void getOption() {
        int option = appView.getOption();
        switch (option) {
            case 1 -> create();
            case 2 -> getAll();
            case 3 -> getById();
            case 4 -> update();
            case 5 -> delete();
            case 0 -> appView.getOutput(Constants.APP_CLOSE_MSG);
            default -> AppStarter.startApp();
        }
    }

    @Override
    public void create() {
        Map<String, String> data = createView.getData();
        Product product = new Product();
        product.setName(data.get("name"));
        product.setQuota(Integer.parseInt(data.get("quota")));
        product.setPrice(Double.parseDouble(data.get("price")));
        createView.getOutput(serviceImpl.create(product));
        AppStarter.startApp();
    }

    @Override
    public void getAll() {
        readView.getOutput(serviceImpl.getAll());
        AppStarter.startApp();
    }

    @Override
    public void getById() {
        readByIdView.getOutput(serviceImpl.getById(readByIdView.getData()));
        AppStarter.startApp();
    }

    @Override
    public void update() {
        Map<String, String> data = updateView.getData();
        Product product = new Product();
        product.setId(Integer.parseInt(data.get("id")));
        product.setName(data.get("name"));
        product.setQuota(Integer.parseInt(data.get("quota")));
        product.setPrice(Double.parseDouble(data.get("price")));
        updateView.getOutput(serviceImpl.update(product));
        AppStarter.startApp();
    }

    @Override
    public void delete() {
        deleteView.getOutput(serviceImpl
                .delete(deleteView.getData()));
        AppStarter.startApp();
    }
}
