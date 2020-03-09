package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;

public class BaseDAO {

    @Resource(name = "sqlSessionSicretTemplate")
    private SqlSession sqlSession;

    protected SqlSession getSqlSession() {
        return sqlSession;
    }
}