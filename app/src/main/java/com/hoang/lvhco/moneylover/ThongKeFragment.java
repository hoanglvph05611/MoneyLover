package com.hoang.lvhco.moneylover;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hoang.lvhco.moneylover.dao.KhoanChiDao;
import com.hoang.lvhco.moneylover.dao.KhoanThuDao;
import com.hoang.lvhco.moneylover.model.KhoanChi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ThongKeFragment extends Fragment {
    private TextView DoanhThuTK,ChiTieuTK,CanDoiTK;
    private KhoanThuDao khoanThuDao;
    private KhoanChiDao khoanChiDao;
    private TextView TatCa,Thang,Nam;
    private TextView tvThang,tvNam;
    private Spinner spinnerThang, spinnerNam;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_thong_ke_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinnerThang = view.findViewById(R.id.spThang);
        spinnerNam = view.findViewById(R.id.spNam);

        khoanThuDao = new KhoanThuDao(getActivity());
        DoanhThuTK = view.findViewById(R.id.DoanhThuTK);

        ChiTieuTK = view.findViewById(R.id.ChiTieuTK);
        CanDoiTK = view.findViewById(R.id.CanDoiTK);

        TatCa = view.findViewById(R.id.TatCa);
        Thang = view.findViewById(R.id.Thang);
        Nam = view.findViewById(R.id.Nam);

        tvThang = view.findViewById(R.id.tvThang);
        tvNam = view.findViewById(R.id.tvNam);


        TatCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvThang.setVisibility(View.GONE);
                tvNam.setVisibility(View.GONE);
                spinnerThang.setVisibility(View.GONE);
                spinnerNam.setVisibility(View.GONE);

                khoanThuDao = new KhoanThuDao(getActivity());
                DoanhThuTK.setText(khoanThuDao.getTongKhoanThu()+"VNĐ");
                //  khoan chi
                khoanChiDao = new KhoanChiDao(getActivity());
                ChiTieuTK.setText(khoanChiDao.getTongKhoanChi()+"VNĐ");
                CanDoiTK.setText(khoanThuDao.getTongKhoanThu()-khoanChiDao.getTongKhoanChi()+"VNĐ");
            }
        });


        Thang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                khoanThuDao = new KhoanThuDao(getActivity());
//                DoanhThuTK.setText(khoanThuDao.getKhoanThuTheoThang̣()+"VNĐ");
//                khoanChiDao = new KhoanChiDao(getActivity());
//                ChiTieuTK.setText(khoanChiDao.getKhoanChiTheoThang̣()+"VNĐ");
//                CanDoiTK.setText(khoanThuDao.getKhoanThuTheoThang̣()-khoanChiDao.getKhoanChiTheoThang̣()+"VNĐ");

                List<String> list = new ArrayList<>();
                list.add("1");
                list.add("2");
                list.add("3");
                list.add("4");
                list.add("5");
                list.add("6");
                list.add("7");
                list.add("8");
                list.add("9");
                list.add("10");
                list.add("11");
                list.add("12");
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,list);

                arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
                spinnerThang.setAdapter(arrayAdapter);
                spinnerThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), spinner.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                List<String> list2 = new ArrayList<>();
                list2.add("2018");
                list2.add("2019");
                list2.add("2020");
                list2.add("2021");
                list2.add("2022");
                ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,list2);

                arrayAdapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
                spinnerNam.setAdapter(arrayAdapter1);
                spinnerNam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), spinner.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }
        });

    Nam.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tvThang.setVisibility(View.INVISIBLE);
            spinnerThang.setVisibility(View.INVISIBLE);
            List<String> list1 = new ArrayList<>();
            list1.add("2018");
            list1.add("2019");
            list1.add("2020");
            list1.add("2021");
            list1.add("2022");
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,list1);

            arrayAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
            spinnerNam.setAdapter(arrayAdapter2);
            spinnerNam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), spinner.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    });
    }
}
