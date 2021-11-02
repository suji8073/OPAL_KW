package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class MainActivity_F1 extends Fragment {
    LinearLayout home, place, person, random_root, want_root, smart_root;
    ImageView home1;
    TextView home2;
    TextView user_name_main, main_1_name, main_2_name, main_1_root, main_2_root;
    private SharedPreferences sp;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(
                R.layout.activity_main_f1, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        sp = this.getActivity().getSharedPreferences("myFile", Activity.MODE_PRIVATE);

        random_root = getView().findViewById(R.id.random_root);
        want_root = getView().findViewById(R.id.want_root);
        smart_root = getView().findViewById(R.id.smart_root);
        user_name_main = getView().findViewById(R.id.user_name_main);
        smart_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(getActivity(), com.kw.opal.area.class);
                start_intent.putExtra("where_check", 4);
                startActivity(start_intent);
            }
        });

        random_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(getActivity(), com.kw.opal.area.class);
                start_intent.putExtra("where_check", 2);
                startActivity(start_intent);
            }
        });

        want_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_i = new Intent(getActivity(), com.kw.opal.area.class);
                start_i.putExtra("where_check", 3);
                startActivity(start_i);
            }
        });
        final String strNickname = sp.getString("strNickname", "");
        if (strNickname != "") user_name_main.setText("\"" + strNickname+ "\" 님");
        else user_name_main.setText("\"" + "비회원"+ "\" 님");




    }
}
