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

package com.xujiaji.mvvmquick.interfaces;

import android.arch.lifecycle.AndroidViewModel;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

/**
 * author: xujiaji
 * created on: 2018/9/11 15:05
 * description: 定义Activity View相关周期
 */
public interface MQView<B extends ViewDataBinding, VM extends AndroidViewModel> extends BindingViewModel<B, VM> {
    /**
     * 处理上个页面传递过来的数据
     */
    void onIntentHandle(@NonNull Intent intent);
}
