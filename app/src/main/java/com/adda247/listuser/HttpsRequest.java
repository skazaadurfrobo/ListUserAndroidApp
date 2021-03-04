package com.adda247.listuser;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;

public class HttpsRequest extends StringRequest {

    public HttpsRequest(int requestMethod, String serverURL, Response.Listener<String> responseListener, Response.ErrorListener errorListener){
        super(requestMethod,serverURL,responseListener,errorListener);
    }


}
