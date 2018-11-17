package com.hoang.lvhco.moneylover;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class KhoanChiFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private EditText edNgayChi,edTenChi,edSoTienChi;
    private ImageView imgLich;
    static private DatePickerDialog.OnDateSetListener onDateSetListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_khoan_chi_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onDateSetListener= this;
        FloatingActionButton fab = view.findViewById(R.id.fabThemKhoanChi);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                View view1 =getLayoutInflater().inflate(R.layout.dialog_them,null);
                dialog.setView(view1);
                dialog.setCancelable(false);
                edNgayChi = view1.findViewById(R.id.edTenThem);
                edSoTienChi = view1.findViewById(R.id.edSoTienThem);
                edNgayChi = view1.findViewById(R.id.edNgayThem);
                imgLich = view1.findViewById(R.id.imgLich);

                imgLich.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       datePicker(v);
                    }
                });

                dialog.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        save(edTenChi.getText().toString(), edSoTienChi.getText().toString(),edNgayChi.getText().toString());
                    }
                });

                dialog.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                AlertDialog dialog1 = dialog.create();
                dialog1.setTitle("Thêm khoản chi");
                dialog1.show();
            }
        });
    }

//    private void save(String string, String string1, String string2) {
//    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = new GregorianCalendar(year,month,dayOfMonth);
        setDate(cal);
    }
    private void setDate(final Calendar calendar){
        edNgayChi.setText(sdf.format(calendar.getTime()));
    }
    public void datePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getFragmentManager(), "date");
    }
    public static class DatePickerFragment extends android.support.v4.app.DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(),
                    onDateSetListener, year, month, day);
        }
    }
}
