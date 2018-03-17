package com.droid.nav.mvvmexample.view.adapter;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 17/03/18.
 */

public class CustomBindingAdapter {

        @BindingAdapter("visibleGone")
        public static void showHide(View view, boolean show) {
            view.setVisibility(show ? View.VISIBLE : View.GONE);
        }
}
