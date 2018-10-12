package com.assessment.Core.Home.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.assessment.Core.Home.Model.Products;
import com.assessment.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akhil on 12/10/18.
 */

public class HomeActivity extends AppCompatActivity{
    @BindView(R.id.productsListRV)
    RecyclerView productsListRV;
    List<Products> productsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setProductsData();
        initRecyclerView();
    }
    public void initRecyclerView() {
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2);
        productsListRV.setLayoutManager(mGridLayoutManager);
        ProductListAdapter listAdapter = new ProductListAdapter(this,productsList);
        productsListRV.setAdapter(listAdapter);
    }
    public void setProductsData(){
        productsList.add(new Products(1,"Acer Predator Gaming Laptops",
                "https://rukminim1.flixcart.com/image/832/832/jmwch3k0/computer/f/g/m/acer-na-gaming-laptop-original-imaf9phahbhzhdr7.jpeg?q=70",77000));
        productsList.add(new Products(2,"Asus Zenfone Max Pro M1",
                "https://rukminim1.flixcart.com/image/832/832/jhp5si80/mobile/h/7/z/asus-zenfone-max-pro-m1-zb601kl-original-imaf5nraywcuea9e.jpeg?q=70",9999));
        productsList.add(new Products(3,"Women Beige Flats",
                "https://rukminim1.flixcart.com/image/832/832/jc6jl3k0/sandal/e/2/q/pcs1199-10-pinkcity-collections-beige-original-imafyuqythjttz2u.jpeg?q=70",499));
        productsList.add(new Products(4,"Round Neck White, Black T-Shirt",
                "https://rukminim1.flixcart.com/image/832/832/jmgmmq80/sweatshirt/q/v/y/xl-ml-mens-rn-fs-checkd-sweatshirt-white-maniac-original-imaf32dgcmdwvurz.jpeg?q=70",799));
        productsList.add(new Products(5,"Furious 4 Ferrari Max Speed (Yellow)",
                "https://rukminim1.flixcart.com/image/832/832/remote-control-toy/u/7/g/max-speed-ferrari-jack-royal-original-imaenxrveyfbjfn8.jpeg?q=70",623));
        productsList.add(new Products(6,"Round Neck White, Black T-Shirt",
                "https://rukminim1.flixcart.com/image/832/832/remote-control-toy/u/7/g/max-speed-ferrari-jack-royal-original-imaenxrveyfbjfn8.jpeg?q=70",1200));
        productsList.add(new Products(7,"SAF Ink Painting",
                "https://rukminim1.flixcart.com/image/832/832/jfyaf0w0/painting/a/k/w/art7515-1artofcreation-original-imaembmyxvdnykgs.jpeg?q=70",715));
        productsList.add(new Products(8,"ADIDAS Boys Lace Football Shoes",
                "https://rukminim1.flixcart.com/image/832/832/jkobte80/kids-shoe/u/t/c/2-cp9218-adidas-original-imaf7z8fruydggch.jpeg?q=70",5555));
        productsList.add(new Products(9,"Matki Shape Terracotta Vase",
                "https://rukminim1.flixcart.com/image/832/832/jm573ww0/vase/b/y/a/el-006-015-new1-exclusivelane-original-imaf93jtnfzqae4m.jpeg?q=70",669));
        productsList.add(new Products(10,"Mi LED Smart TV 4A 80 cm",
                "https://rukminim1.flixcart.com/image/832/832/jmux18w0/television/j/k/m/mi-l32m5-ai-original-imaf9zf8gfgh4wvz.jpeg?q=70",13500));

    }
}
