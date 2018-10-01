package ru.innopolis.stc13.service;

import ru.innopolis.stc13.pojo.Mobile;

import java.util.List;

public interface MobileService {
    List<Mobile> getMobilesByBrand(String brand);
}
