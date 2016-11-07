package org.beckoning.web.loading.management.mapper;

import java.util.List;
import org.beckoning.web.loading.management.modle.MenuInfo;

public interface MenuInfoMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(MenuInfo record);

    MenuInfo selectByPrimaryKey(Integer menuId);

    List<MenuInfo> selectAll();

    int updateByPrimaryKey(MenuInfo record);
}