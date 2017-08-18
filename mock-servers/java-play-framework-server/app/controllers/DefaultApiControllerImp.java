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
import java.io.FileInputStream;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2017-08-18T14:49:51.188Z")

public class DefaultApiControllerImp implements DefaultApiControllerImpInterface {
    @Override
    public InlineResponse200 addTodo(Todo1 todo) throws Exception {
        //Do your magic!!!
        return new InlineResponse200();
    }

    @Override
    public InlineResponse200 addUser(User1 user) throws Exception {
        //Do your magic!!!
        return new InlineResponse200();
    }

    @Override
    public InlineResponse200 deleteTodo(Long id) throws Exception {
        //Do your magic!!!
        return new InlineResponse200();
    }

    @Override
    public InlineResponse2001 deleteUser(Long id) throws Exception {
        //Do your magic!!!
        return new InlineResponse2001();
    }

    @Override
    public List<InlineResponse200> retrieveTodos(Integer limit) throws Exception {
        //Do your magic!!!
        return new ArrayList<InlineResponse200>();
    }

    @Override
    public List<InlineResponse2001> retrieveUsers(Integer limit) throws Exception {
        //Do your magic!!!
        return new ArrayList<InlineResponse2001>();
    }

    @Override
    public InlineResponse200 updateTodo(Long id, Todo2 todo) throws Exception {
        //Do your magic!!!
        return new InlineResponse200();
    }

    @Override
    public InlineResponse2001 updateUser(Long id, User2 user) throws Exception {
        //Do your magic!!!
        return new InlineResponse2001();
    }

}
