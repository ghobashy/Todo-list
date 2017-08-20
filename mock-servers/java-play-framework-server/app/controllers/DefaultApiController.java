package controllers;

import apimodels.InlineResponse200;
import apimodels.InlineResponse2001;
import apimodels.InlineResponseDefault;
import apimodels.Todo1;
import apimodels.Todo2;
import apimodels.User1;
import apimodels.User2;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import java.io.IOException;
import swagger.SwaggerUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.validation.constraints.*;

import swagger.SwaggerUtils.ApiAction;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPlayFrameworkCodegen", date = "2017-08-18T14:49:51.188Z")

public class DefaultApiController extends Controller {

    private final DefaultApiControllerImp imp;
    private final ObjectMapper mapper;

    @Inject
    private DefaultApiController(DefaultApiControllerImp imp) {
        this.imp = imp;
        mapper = new ObjectMapper();
    }


    @ApiAction
    public Result addTodo() throws Exception {
        JsonNode nodetodo = request().body().asJson();
        Todo1 todo;

        todo = mapper.readValue(nodetodo.toString(), Todo1.class);

        InlineResponse200 obj = imp.addTodo(todo);
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
        
    }

    @ApiAction
    public Result addUser() throws Exception {
        JsonNode nodeuser = request().body().asJson();
        User1 user;

        user = mapper.readValue(nodeuser.toString(), User1.class);

        InlineResponse200 obj = imp.addUser(user);
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
        
    }

    @ApiAction
    public Result deleteTodo(Long id) throws Exception {
        InlineResponse200 obj = imp.deleteTodo(id);
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
        
    }

    @ApiAction
    public Result deleteUser(Long id) throws Exception {
        InlineResponse2001 obj = imp.deleteUser(id);
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
        
    }

    @ApiAction
    public Result retrieveTodos() throws Exception {
        String valuelimit = request().getQueryString("limit");
        Integer limit;
        if (valuelimit != null) {
            limit = Integer.parseInt(valuelimit);
        
        } else {
            limit = 0;
        }
        List<InlineResponse200> obj = imp.retrieveTodos(limit);
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
        
    }

    @ApiAction
    public Result retrieveUsers() throws Exception {
        String valuelimit = request().getQueryString("limit");
        Integer limit;
        if (valuelimit != null) {
            limit = Integer.parseInt(valuelimit);
        
        } else {
            limit = 0;
        }
        List<InlineResponse2001> obj = imp.retrieveUsers(limit);
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
        
    }

    @ApiAction
    public Result updateTodo(Long id) throws Exception {
        JsonNode nodetodo = request().body().asJson();
        Todo2 todo;

        todo = mapper.readValue(nodetodo.toString(), Todo2.class);

        InlineResponse200 obj = imp.updateTodo(id, todo);
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
        
    }

    @ApiAction
    public Result updateUser(Long id) throws Exception {
        JsonNode nodeuser = request().body().asJson();
        User2 user;

        user = mapper.readValue(nodeuser.toString(), User2.class);

        InlineResponse2001 obj = imp.updateUser(id, user);
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
        
    }
}
