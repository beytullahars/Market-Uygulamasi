package com.android.sepeteeklefirebase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ShowCart_Adapter extends RecyclerView.Adapter<ShowCart_Adapter.ViewHolder> {
  private Context context;
  private List<ShowCart_Model> showCart_modelList;


  public ShowCart_Adapter(Context context,List<ShowCart_Model> showCart_models) {
    this.context = context;
    this.showCart_modelList = showCart_models;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_order, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
    ShowCart_Model prod = showCart_modelList.get(position);

    ShowCart_Model showCart_model = showCart_modelList.get(position);
    holder.product_name.setText(showCart_model.getProduct_Name());
    holder.price.setText(showCart_model.getPrice());
    holder.ButtonSil.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Silme işlemleri yapılacak
      }
    });
  }

  @Override
  public int getItemCount() {
    return showCart_modelList.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    private TextView product_name;
    private TextView price;
    private Button ButtonSil;
    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      product_name = itemView.findViewById(R.id.product_name);
      price = itemView.findViewById(R.id.product_price);
      //ButtonSil = itemView.findViewById(R.id.ButtonSil);
    }
  }
}
