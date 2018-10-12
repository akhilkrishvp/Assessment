package com.assessment.Core.Home.UI;

import android.app.Activity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.assessment.Core.Home.Model.Products;
import com.assessment.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akhil on 12/10/18.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private Activity activity;
    private List<Products> productsList;
    public ProductListAdapter(Activity activity, List<Products> productsList1) {
        this.activity = activity;
        this.productsList = productsList1;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.product_list_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ProductListAdapter.ViewHolder holder, final int position) {
        holder.productNameTV.setText(productsList.get(position).getProductName());
        holder.priceTextView.setText("₹ "+productsList.get(position).getPrice());
        if(!TextUtils.isEmpty(productsList.get(position).getProductUrl())){
            Picasso.with(activity).
                    load(productsList.get(position).getProductUrl()).fit().
                    centerCrop().into(holder.productImageView);
        }
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.productNameTV)
        AppCompatTextView productNameTV;
        @BindView(R.id.priceTextView)
        AppCompatTextView priceTextView;
        @BindView(R.id.productImageView)
        ImageView productImageView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }
}