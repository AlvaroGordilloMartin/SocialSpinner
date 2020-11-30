package com.example.socialspinner.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.socialspinner.R;
import com.example.socialspinner.model.Social;

import java.util.List;
import java.util.Scanner;

public class SocialAdapter extends ArrayAdapter {
    private Context context;
    private List<Social> list;
    public SocialAdapter(@NonNull Context context, List<Social> list) {
        super(context, R.layout.social_item, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        SocialHolder socialHolder;
        if(view==null){

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.social_item,null);
            socialHolder = new SocialHolder();
            socialHolder.imgSocial = view.findViewById(R.id.imgSocial);
            socialHolder.tvName = view.findViewById(R.id.tvName);
            view.setTag(socialHolder);
        }
        else
            socialHolder = (SocialHolder) view.getTag();

        socialHolder.imgSocial.setImageResource(list.get(position).getIcon());
        socialHolder.tvName.setText(list.get(position).getName());
        return view;
    }

    /**
     * Al declarar este metodo se establece el diseño de la lista que aparece cuando se pulsa sobre el spinner
     * @return
     */
    @Nullable
    @Override
    public Resources.Theme getDropDownViewTheme() {
        return super.getDropDownViewTheme();
    }

    /*
        Patron que contiene los widgets del objeto view
         */
    private class SocialHolder{
        private ImageView imgSocial;
        private TextView tvName;
    }
}
