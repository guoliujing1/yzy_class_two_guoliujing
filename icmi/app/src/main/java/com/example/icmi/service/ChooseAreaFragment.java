package com.example.icmi.service;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.icmi.R;
import com.example.icmi.db.City;
import com.example.icmi.db.County;
import com.example.icmi.db.Province;

import java.util.ArrayList;
import java.util.List;
/**
 * 遍历全国省、市、县数据并且返回给choose_area.xml显示
 */
public class ChooseAreaFragment extends Fragment {
    /*
        常量-一般大写
     */
    public static final int LEVEL_PROVINCE = 0;
    public static final int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;
    private ProgressDialog progressDialog;
    private TextView titleText;
    private Button backButton;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();
    /**
     * 省列表
     */
    private List<Province> provinceList;
    /**
     * 市列表
     */
    private List<City> cityList;
    /**
     * 县列表
     */
    private List<County> countyList;
    /**
     * 选中的省份
     */
    private Province selectProvince;
    /**
     * 选中的城市
     */
    private City selectCity;
    /**
     * 当前选中的级别
     */
    private int currentLevel;

    /**
     * 碎片初始化
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.choose_area,container,false);
        titleText = (TextView)view.findViewById(R.id.title_text);
        backButton = (Button)view.findViewById(R.id.back_button);
        listView = (ListView)view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        return view;
    }
    /**
     * 链接视图
     */
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //监听listView中的item子项被点击的事件
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel == LEVEL_PROVINCE){
                    selectProvince = provinceList.get(position);
                    //查询服务器省份信息
                    queryCities();
                }else if(currentLevel == LEVEL_CITY){
                    selectCity = cityList.get(position);
                    //查询县份数据
                    queryCounties();
                }
            }
        });
        //当返回按钮被点击时
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if (currentLevel == LEVEL_COUNTY){
                    queryCities();
                }else if(currentLevel == LEVEL_CITY){
                    queryProvinces();
                }
            }
        });
    }

    /**
     * 查询全国所有的省份，优先从本地数据库查询，如果本地数据库没有该数据再到服务器查询
     */
    public void queryProvinces(){

    }
    /**
     * 查询选中的省份对应的所有的市级，优先从本地数据库查询，若没有则从服务器查询
     */
    public void queryCities(){

    }
    /**
     * 查询选中的城市对应的县级，优先从本地数据库查询，若没有则从服务器查询
     */
    public void queryCounties(){

    }
}
