package com.zebrunner.carina.demo.api.jsonplaceholder.typicode.com;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users/3", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/api.jsonplaceholder.typicode.com/_put/rq.json")
@ResponseTemplatePath(path = "api/api.jsonplaceholder.typicode.com/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateUser extends AbstractApiMethodV2 {

    public UpdateUser() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("DEMO.api_url"));
    }
}

