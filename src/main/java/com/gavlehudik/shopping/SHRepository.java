package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SHRepository {

    @Autowired
    public DataSource dataSource;

}
