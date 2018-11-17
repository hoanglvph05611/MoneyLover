package com.hoang.lvhco.moneylover.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoang.lvhco.moneylover.R;
import com.hoang.lvhco.moneylover.dao.KhoanChiDao;
import com.hoang.lvhco.moneylover.model.KhoanChi;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdapterKhoanChi extends RecyclerView.Adapter<AdapterKhoanChi.ViewHolder> {
    private Context context;
    private ArrayList<KhoanChi> khoanChiArrayList;
    private KhoanChiDao khoanChiDao;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public AdapterKhoanChi (Context context,ArrayList<KhoanChi> khoanChiArrayList){
        this.context = context;
        this.khoanChiArrayList = khoanChiArrayList;
        khoanChiDao = new KhoanChiDao(context);
    }
    @NonNull
    @Override
    public AdapterKhoanChi.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.dialog_them,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKhoanChi.ViewHolder viewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return khoanChiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTenThem;
        private EditText edTenThem;
        private TextView tvSoTienThem;
        private EditText edSoTienThem;
        private TextView tvNgayThem;
        private EditText edNgayThem;
        private ImageView imgLich;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTenThem = itemView.findViewById(R.id.tvTenThem);
            edTenThem = itemView.findViewById(R.id.edTenThem);
            tvSoTienThem = itemView.findViewById(R.id.tvSoTienThem);
            edSoTienThem = itemView.findViewById(R.id.edSoTienThem);
            tvNgayThem = itemView.findViewById(R.id.tvNgayThem);
            edNgayThem = itemView.findViewById(R.id.edNgayThem);
            imgLich = itemView.findViewById(R.id.imgLich);
        }
    }
    public void changeDataset(List<KhoanChi> khoanChiList){
        this.khoanChiArrayList = (ArrayList<KhoanChi>)khoanChiList;
        notifyDataSetChanged();
    }
}
