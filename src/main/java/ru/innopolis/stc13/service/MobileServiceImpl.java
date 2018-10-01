package ru.innopolis.stc13.service;

import ru.innopolis.stc13.pojo.Mobile;
import ru.innopolis.stc13.repository.dao.MobileDao;
import ru.innopolis.stc13.repository.dao.MobileDaoJdbcImpl;

import java.util.List;

public class MobileServiceImpl implements MobileService {
    MobileDao mobileDao;

    public MobileServiceImpl() {
        mobileDao = new MobileDaoJdbcImpl();
    }

    @Override
    public List<Mobile> getMobilesByBrand(String brand) {
        return mobileDao.getMobileList(Integer.valueOf(brand));
    }
}
