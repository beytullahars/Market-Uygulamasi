  package com.android.sepeteeklefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

  public class MainActivity extends AppCompatActivity {
  private TextView show_cart;
  private Button button1,button2,button3;
  private DatabaseReference reference;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    reference = FirebaseDatabase.getInstance().getReference("SepeteEkleUygulamasi");

    show_cart = findViewById(R.id.show_cart);
    button1 = findViewById(R.id.button1);
    button2 = findViewById(R.id.button2);
    button3 = findViewById(R.id.button3);

    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String ID_cart = reference.push().getKey();
        HashMap<String,String> parameters = new HashMap<>();
        parameters.put("Product_Name","Elma");
        parameters.put("Price","20");
        reference.child(ID_cart).setValue(parameters);
      }
    });

    button2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String ID_cart = reference.push().getKey();

        HashMap<String,String> parameters = new HashMap<>();
        parameters.put("Product_Name","Armut");
        parameters.put("Price","30");
        reference.child(ID_cart).setValue(parameters);
      }
    });

    button3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String ID_cart = reference.push().getKey();

        HashMap<String,String> parameters = new HashMap<>();
        parameters.put("Product_Name","Portakal");
        parameters.put("Price","25");
        reference.child(ID_cart).setValue(parameters);
      }
    });

    //Sepette kaç adet ürün olduğunu gösterme;
    reference.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot snapshot) {
        //show_cart.setText(""+snapshot.getChildrenCount());
        show_cart.setText("Sepette "+snapshot.getChildrenCount()+" adet ürün var. \n SEPETE BAK");
      }

      @Override
      public void onCancelled(@NonNull DatabaseError error) {

      }
    });
    show_cart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(), ShowCart.class));
      }
    });
  }
}