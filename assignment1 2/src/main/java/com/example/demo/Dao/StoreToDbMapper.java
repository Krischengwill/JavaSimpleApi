package com.example.demo.Dao;
import java.util.List;

import com.example.demo.web.storeToDb;
import org.apache.ibatis.annotations.*;


@Mapper
public interface StoreToDbMapper {

    @Select("SELECT * FROM storeToDb WHERE id = #{id}")
    storeToDb queryById(@Param("id") int id);

    @Select("SELECT * FROM storeToDb")
    List<storeToDb> queryAll();

    @Insert({"INSERT INTO storeToDb(str,strInt) VALUES(#{str},#{strInt})"})
    int add(storeToDb storeToDb);

    @Delete("DELETE FROM storeToDb WHERE id = #{id}")
    int delById(int id);

    @Update("UPDATE storeToDb SET str=#{str},strInt=#{strInt}")
    int updateById(storeToDb storeToDb);
}
