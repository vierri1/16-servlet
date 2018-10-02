package ru.innopolis.stc13.service;

import ru.innopolis.stc13.pojo.Brand;
import ru.innopolis.stc13.repository.dao.BrandDao;
import ru.innopolis.stc13.repository.dao.BrandDaoImpl;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    BrandDao brandDao;

    public BrandServiceImpl() {
        this.brandDao = new BrandDaoImpl();
    }

    @Override
    public List<Brand> getBrandList() {
        return brandDao.getBrandList();
    }

    @Override
    public boolean add(String name, String country) {
        Brand brand = new Brand();
        if (name != null && country != null) {
            brand.setName(name);
            brand.setCountry(country);
            return brandDao.add(brand);
        }
        return false;
    }
}
