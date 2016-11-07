package org.beckoning.web.loading.management.mapper;

import java.util.List;
import org.beckoning.web.loading.management.modle.MenuInfo;

public interface MenuInfoMapper {
    int insert(MenuInfo record);

    List<MenuInfo> selectAll();
}