package com.hoang.lvhco.moneylover.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hoang.lvhco.moneylover.R;
import com.hoang.lvhco.moneylover.dao.KhoanThuDao;
import com.hoang.lvhco.moneylover.model.KhoanThu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdapterKhoanThu extends RecyclerView.Adapter<AdapterKhoanThu.ViewHolder> {
    private Context context;
    private ArrayList<KhoanThu> khoanThuArrayList;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private KhoanThuDao khoanThuDao;

    public AdapterKhoanThu(Context context,ArrayList<KhoanThu> khoanThuArrayList){
        this.context = context;
        this.khoanThuArrayList = khoanThuArrayList;
        khoanThuDao = new KhoanThuDao(context);
    }
    @NonNull
    @Override
    public AdapterKhoanThu.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_khoan_thu,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKhoanThu.ViewHolder viewHolder, final int i) {
           KhoanThu khoanThu = khoanThuArrayList.get(i);
           viewHolder.tvTenKhoanThu.setText(khoanThuArrayList.get(i).getTenKhoanThu());
           viewHolder.tvSoTienThu.setText(khoanThuArrayList.get(i).getSoTienKhoanThu()+"");
           viewHolder.tvNgayThu.setText(sdf.format(khoanThuArrayList.get(i).getNgayThu()));
           viewHolder.imgKhoanThu.setImageResource(R.drawable.doanhthu);
           viewHolder.suaKhoaThu.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
           viewHolder.xoaKhoanThu.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   khoanThuDao = new KhoanThuDao(context);
                   khoanThuDao.deleteKhoanThuByID(khoanThuArrayList.get(i).getTenKhoanThu());
                   khoanThuArrayList.remove(i);
                   notifyDataSetChanged();
               }
           });


    }

    @Override
    public int getItemCount() {
        return khoanThuArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenKhoanThu,tvNgayThu,tvSoTienThu;
        ImageView xoaKhoanThu,suaKhoaThu;
        private ImageView imgKhoanThu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        tvNgayThu = itemView.findViewById(R.id.tvNgayThu);
        tvTenKhoanThu= itemView.findViewById(R.id.tvTenKhoanThu);
        tvSoTienThu = itemView.findViewById(R.id.tvSoTienThu);
        xoaKhoanThu = itemView.findViewById(R.id.xoaKhoanThu);
        suaKhoaThu = itemView.findViewById(R.id.suaKhoanThu);
        imgKhoanThu = itemView.findViewById(R.id.imgKhoanThu);
        }
    }
    public void changeDataset(List<KhoanThu> khoanThuList){
        this.khoanThuArrayList = (ArrayList<KhoanThu>) khoanThuList;
        notifyDataSetChanged();
    }
}
