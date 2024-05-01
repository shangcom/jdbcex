package org.zerock.jdbcex.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import lombok.extern.log4j.Log4j2;
import org.zerock.jdbcex.service.TodoService;


@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

}
