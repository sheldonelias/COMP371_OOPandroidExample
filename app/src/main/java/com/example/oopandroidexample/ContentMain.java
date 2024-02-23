package com.example.oopandroidexample;

import android.os.Bundle;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ContentMain extends Fragment {

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }

}