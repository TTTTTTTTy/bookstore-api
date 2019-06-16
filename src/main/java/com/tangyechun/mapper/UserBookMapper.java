package com.tangyechun.mapper;

import com.tangyechun.model.UserBook;
import com.tangyechun.model.UserBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBookMapper {
    long countByExample(UserBookExample example);

    int deleteByExample(UserBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserBook record);

    int insertSelective(UserBook record);

    List<UserBook> selectByExample(UserBookExample example);

    UserBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserBook record, @Param("example") UserBookExample example);

    int updateByExample(@Param("record") UserBook record, @Param("example") UserBookExample example);

    int updateByPrimaryKeySelective(UserBook record);

    int updateByPrimaryKey(UserBook record);
}