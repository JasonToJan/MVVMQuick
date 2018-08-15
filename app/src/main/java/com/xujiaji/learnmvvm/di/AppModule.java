/*
 *    Copyright 2018 XuJiaji
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.xujiaji.learnmvvm.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.xujiaji.learnmvvm.service.repository.Api;
import com.xujiaji.learnmvvm.module.projectlist.ProjectListViewModel;
import com.xujiaji.learnmvvm.module.projectdetail.ProjectViewModel;
import com.xujiaji.learnmvvm.service.repository.Net;
import com.xujiaji.mvvmquick.viewmodel.ProjectViewModelFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: xujiaji
 * created on: 2018/6/12 11:51
 * description:
 */
@Module(subcomponents = ViewModelSubComponent.class)
public abstract class AppModule {

    @Singleton
    @Provides
    static Api provideApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(Net.TIME_OUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(Net.TIME_OUT_READ, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(Api.URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
    }

    @Singleton
    @Provides
    static Map<Class<?>, Callable<Lazy<? extends ViewModel>>> providesViewModel(ViewModelSubComponent.Builder viewModelSubComponent) {
        ViewModelSubComponent vmsc = viewModelSubComponent.build();
        Map<Class<?>, Callable<Lazy<? extends ViewModel>>> creators = new HashMap<>();
        creators.put(ProjectViewModel.class, vmsc::projectViewModel);
        creators.put(ProjectListViewModel.class, vmsc::projectListViewModel);
        return creators;
    }

    @Singleton
    @Binds
    abstract ViewModelProvider.Factory provideViewModelFactory(ProjectViewModelFactory factory);
}
