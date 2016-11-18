package items;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by stas.savinov on 11/8/2016.
 * http://www.vogella.com/tutorials/ApacheHttpClient/article.html
 * http://www.itsalif.info/content/android-volley-tutorial-http-get-post-put - JSON
 *
 * TODO: Create application mocks for POST/GET methods.
 * Try to emulate on real home server at least one POST/GET request which returns JSON data
 */

public class RESTRequests
{
    private String REGISTER_URL = null;
    private RequestQueue requestQueue = null;
    private Context ctx = null;
    private String ClassResponse = null;

    public void RESTRequests(Context context)
    {
        ctx = context;
        requestQueue = Volley.newRequestQueue(context);
        REGISTER_URL = "http://echostarinventory.000webhostapp.com/";
    }

    private void setResponse(String resp)
    {
        ClassResponse = resp;
    }

    public void RESTRequests(Context context, URL url)
    {
        requestQueue = Volley.newRequestQueue(context);
        ctx = context;
        if (url == null)
        {
            // TODO May be hardcode default site wont be a bad idea.
            // or we can add this field in application settings page
            REGISTER_URL = "http://echostarinventory.000webhostapp.com/Login.php";
        }
        else
        {
            REGISTER_URL = url.toString();
        }
    }

    public void POSTRequestSend(Context context)
    {
        final Context ctx = context;
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                                                        REGISTER_URL,
                                                        new Response.Listener<String>()
                                                        {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(ctx,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(ctx,error.toString(),Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String,String> getParams()
            {
                Map<String,String> params = new HashMap<String, String>();
                //params.put(KEY_USERNAME,username);
                //params.put(KEY_PASSWORD,password);
                //params.put(KEY_EMAIL, email);
                return params;
            }

        };
        requestQueue.add(stringRequest);
    }

    public String GETRequestSend(Context context, String url_addon, JSONObject jsonRequest)
    {
        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET,
                                                             REGISTER_URL + url_addon,
                                                             jsonRequest,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                        setResponse(response.toString());
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.d("Error.Response",error.toString());
                        setResponse(error.toString());
                    }
                }
        );
        requestQueue.add(getRequest);

        return ClassResponse;
    }

    public void PUTRequestSend(Context context)
    {
        //url = "http://httpbin.org/put";
        StringRequest putRequest = new StringRequest(Request.Method.PUT, REGISTER_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String> ();
//                params.put("name", "Alif");
//                params.put("domain", "http://itsalif.info");
                return params;
            }
        };

        requestQueue.add(putRequest);
    }

    public void DELETERequestSend(Context context)
    {
        StringRequest dr = new StringRequest(Request.Method.DELETE, REGISTER_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                        Log.d("DELETERequestSend", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.d("DELETERequestSend.Error", error.toString());
                    }
                }
        );
        requestQueue.add(dr);
    }
}
