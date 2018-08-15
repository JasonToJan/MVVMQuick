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

import com.xujiaji.learnmvvm.module.main.MainModule;
import com.xujiaji.learnmvvm.module.main.MainActivity;
import com.xujiaji.learnmvvm.module.start.StartActivity;
import com.xujiaji.learnmvvm.module.start.StartModule;
import com.xujiaji.mvvmquick.di.ActivityScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * author: xujiaji
 * created on: 2018/6/12 13:43
 * description:
 */
@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity contributeMainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = StartModule.class)
    abstract StartActivity contributeStartActivity();
}
