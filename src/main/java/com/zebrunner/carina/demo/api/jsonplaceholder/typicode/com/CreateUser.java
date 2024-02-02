package com.zebrunner.carina.demo.api.jsonplaceholder.typicode.com;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/api.jsonplaceholder.typicode.com/_post/rq.json")
@ResponseTemplatePath(path = "api/api.jsonplaceholder.typicode.com/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class CreateUser extends AbstractApiMethodV2 {

    public CreateUser() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("DEMO.api_url"));
    }



}
