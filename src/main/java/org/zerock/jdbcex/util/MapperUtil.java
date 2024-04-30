package org.zerock.jdbcex.util;

import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;

public enum MapperUtil {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;
}
