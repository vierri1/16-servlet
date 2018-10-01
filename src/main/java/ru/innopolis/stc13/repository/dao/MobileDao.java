package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.pojo.Mobile;

import java.util.List;

public interface MobileDao {
    public boolean addMobile(Mobile mobile);

    public Mobile getMobileById(Integer id);

    List<Mobile> getMobileList(Integer brandId);

    public boolean updateMobileById(Mobile mobile);

    public boolean deleteMobileById(Integer id);
}
