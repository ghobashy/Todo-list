package controllers;

import apimodels.InlineResponse200;
import apimodels.InlineResponse2001;
import apimodels.InlineResponseDefault;
import apimodels.Todo1;
import apimodels.Todo2;
import apimodels.User1;
import apimodels.User2;

import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.constraints.*;

public interface DefaultApiControllerImpInterface {
    InlineResponse200 addTodo(Todo1 todo) throws Exception;

    InlineResponse200 addUser(User1 user) throws Exception;

    InlineResponse200 deleteTodo(Long id) throws Exception;

    InlineResponse2001 deleteUser(Long id) throws Exception;

    List<InlineResponse200> retrieveTodos(Integer limit) throws Exception;

    List<InlineResponse2001> retrieveUsers(Integer limit) throws Exception;

    InlineResponse200 updateTodo(Long id, Todo2 todo) throws Exception;

    InlineResponse2001 updateUser(Long id, User2 user) throws Exception;

}
