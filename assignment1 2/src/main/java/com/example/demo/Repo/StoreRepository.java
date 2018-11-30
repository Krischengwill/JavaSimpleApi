package com.example.demo.Repo;
import com.example.demo.web.storeToDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepository {
    @Autowired
    JdbcTemplate template;
    /*Adding an item into database table*/
    public int addstoreToDb(int id,String str,int strInt){
        String query = "INSERT INTO STORETODB VALUES(?,?,?)";
        return template.update(query,id,str,strInt);
    }

}
