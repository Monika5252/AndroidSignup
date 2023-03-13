package com.example.loginapp;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static String api = "https://monika5252.pythonanywhere.com/dataCreate";

    private Button btn_register;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            //            @Override
            public void onClick(View v) {
                btnSendPostRequestClicked();
            }

        });
    }

//                Method method = RetrofitInstance.getRetrofitInstance().create(Methods.class);
//                Call<registermodel> call = methods.getallData();
////                call enqueue(new javax.security.auth.callback.Callback<registermodel>() {
//
//            }

    private void btnSendPostRequestClicked() {
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<User> call = apiInterface.getUserInformation("monika", "monika.mobicloud@gmail.com", Integer.parseInt("7719814800"), "Mobicloud@123");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e(TAG, "onResponse: " + response.code());
                Log.e(TAG, "onResponse: name:" + response.body().getName());
                Log.e(TAG, "onResponse: email:" + response.body().getEmail());
                Log.e(TAG, "onResponse: mobile:" + response.body().getMobile());
                Log.e(TAG, "onResponse: password:" + response.body().getPassword());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });

    }
}

//        });
//        RetrofitInstance.getInstance().apiInterface.getregister().enqueue(new Callback<List<registermodel>>(){
//
//            @Override
//            public void onResponse(Call<List<registermodel>> call, Response<List<registermodel>> response) {
//                allregisterList=response.body();
//                for (int i=0;i<allregisterList.size();i++)
//                {
//                    Log.e("api","onResponse:"+ allregisterList.get(i).getEmail());
//                    Log.e("api","onResponse:"+ allregisterList.get(i).getName());
//                    Log.e("api","onResponse:"+ allregisterList.get(i).getMobile());
//                    Log.e("api","onResponse:"+ allregisterList.get(i).getPassword());
//                }
//            }
//            @Override
//            public void onFailure(Call<List<registermodel>> call, Throwable t) {
//                Log.e("api","onFailure:"+ t.getLocalizedMessage());
//
//            }



//            @Override
//            public void onResponse(Call<List<registermodel>> call, Response<List<registermodel>> response) {
//                allregisterList=response.body();
//                        for (int i=0;i<allregisterList.size();i++)
//                        {
//                            Log.e("api","onResponse:"+ allregisterList.get(i).getEmail());
//                            Log.e("api","onResponse:"+ allregisterList.get(i).getName());
//                            Log.e("api","onResponse:"+ allregisterList.get(i).getMobile());
//                            Log.e("api","onResponse:"+ allregisterList.get(i).getPassword());
//                        }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<registermodel>> call, Throwable t) {
//                Log.e("api","onFailure:"+ t.getLocalizedMessage());
//
//            }
//



//        setContentView(R.layout.activity_main);
//
//        ViewPager viewPager = findViewById(R.id.viewPager);
//
//        AuthenticationPagerAdapter pagerAdapter = new AuthenticationPagerAdapter(getSupportFragmentManager());
//        pagerAdapter.addFragmet(new LoginFragment());
//        pagerAdapter.addFragmet(new RegisterFragment());
//        viewPager.setAdapter(pagerAdapter);
//    }
//
//    static class AuthenticationPagerAdapter extends FragmentPagerAdapter {
//        private ArrayList<Fragment> fragmentList = new ArrayList<>();
//
//        public AuthenticationPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            return fragmentList.get(i);
//        }
//
//        @Override
//        public int getCount() {
//            return fragmentList.size();
//        }
//
//        void addFragmet(Fragment fragment) {
//            fragmentList.add(fragment);
//        }
//    }
//}
