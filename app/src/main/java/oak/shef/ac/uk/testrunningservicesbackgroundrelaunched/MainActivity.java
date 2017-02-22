/**
 * created by Fabio Ciravegna, The University of Sheffield, f.ciravegna@shef.ac.uk
 * LIcence: MIT
 * Copyright (c) 2016 (c) Fabio Ciravegna

 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package oak.shef.ac.uk.testrunningservicesbackgroundrelaunched;


import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    Context ctx;
    RecyclerView.LayoutManager mLayoutManager ;

    public Context getCtx() {
        return ctx;
    }
    private List<Datum> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    String url="https://reqres.in";
    EditText userPageNumber;
    Button clickEntery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_main);
        mLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView = (RecyclerView) findViewById(R.id.userDynamicList);
        userPageNumber= (EditText) findViewById(R.id.tvPageNumber);
        clickEntery= (Button) findViewById(R.id.clickEntery);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        clickEntery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=userPageNumber.getText().toString();

                if(value!=null)
                {
                    Integer result = Integer.valueOf(value);
                    getRetrofitObject(url,result);
                }
                else
                {
                    getRetrofitObject(url,1);
                }


            }
        });




    }

    void getRetrofitObject(String url,Integer value) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);


        Call<Example> call = service.getUserDetails(value);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Response<Example> response, Retrofit retrofit) {

                movieList=response.body().getData();
                Log.d("onResponse: ",movieList+"");
                mAdapter=new MoviesAdapter(movieList,getCtx());
                recyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ctx, "Sorry Wrong Data Entered...!! ", Toast.LENGTH_SHORT).show();
            }
        });
    }


}


