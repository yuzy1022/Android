package com.example.mydbtest;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateRequest extends StringRequest
{
    final static private String URL = "http://101.101.211.66:8080/2018021097/ValidateRequest.jsp";
    private Map<String, String> parameters;

    public ValidateRequest(String userID, Response.Listener<String> listener)
    {
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("userID", userID);
    }

    protected Map<String, String> getParameters() throws AuthFailureError
    {
        return parameters;
    }
}
