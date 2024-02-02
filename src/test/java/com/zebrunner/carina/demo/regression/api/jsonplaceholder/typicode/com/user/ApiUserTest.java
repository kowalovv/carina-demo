package com.zebrunner.carina.demo.regression.api.jsonplaceholder.typicode.com.user;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.api.jsonplaceholder.typicode.com.CreateUser;
import com.zebrunner.carina.demo.api.jsonplaceholder.typicode.com.DeleteUser;
import com.zebrunner.carina.demo.api.jsonplaceholder.typicode.com.GetUser;
import com.zebrunner.carina.demo.api.jsonplaceholder.typicode.com.UpdateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class ApiUserTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "JIRA#DEMO-1")
    @MethodOwner(owner = "Patryk")
    public void testCreateUser()  {
        LOGGER.info("Test 1");
        CreateUser api = new CreateUser();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(description = "JIRA#DEMO-2")
    @MethodOwner(owner = "Patryk")
    public void testDeleteUser() {
        LOGGER.info("Test 2");
        DeleteUser api = new DeleteUser();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(description = "JIRA#DEMO-3")
    @MethodOwner(owner = "Patryk")
    public void testGetUser() {
        LOGGER.info("Test 3");
        GetUser getUser = new GetUser();
        getUser.callAPIExpectSuccess();
        getUser.validateResponse();
        getUser.validateResponseAgainstSchema("api/api.jsonplaceholder.typicode.com/_get/rs.schema");
    }

    @Test(description = "JIRA#DEMO-4")
    @MethodOwner(owner = "Patryk")
    public void testUpdateUser() {
        LOGGER.info("Test 4");
        UpdateUser api = new UpdateUser();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}
