package app.gsusrodbe.com.GsusAPP;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by jjrodrig on 11/08/2016.
 */
public class Mysingleton {

    private static Mysingleton mInstance;
    private static RequestQueue requestQueue;
    private static Context mCtx;

    private Mysingleton (Context context)
    {

        mCtx = context;
        requestQueue = getRequestQueue();

    }


    public RequestQueue getRequestQueue()
    {

        if (requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Mysingleton getmInstance (Context context)
    {

        if (mInstance==null){

            mInstance = new Mysingleton(context);
        }

        return mInstance;

    }

    public <T> void addToRequestque (Request<T> request)
    {

        requestQueue.add(request);


    }
}
