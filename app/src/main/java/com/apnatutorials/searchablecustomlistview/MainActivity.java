package com.apnatutorials.searchablecustomlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    CustomerAdapter adapter = null;
    ArrayList<Customer> customers = null;
    ListView myCustomListView;
    SearchView mySearchView = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customers = new ArrayList<>();
        customers = populateCustomerData(customers);
        mySearchView = (SearchView) findViewById( R.id.mySearchView ) ;
        myCustomListView = (ListView) findViewById(R.id.myCustomListView);
        adapter = new CustomerAdapter(this, customers);
        myCustomListView.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // Here implement search logic
                adapter.getFilter().filter(s);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private ArrayList<Customer> populateCustomerData(ArrayList<Customer> customers) {
        customers.add(new Customer("Balendra", "Singh", 1, R.drawable.c1));
        customers.add(new Customer("Bipin", "Arora", 2, R.drawable.c2));
        customers.add(new Customer("Babulal", "Marandi", 3, R.drawable.c3));


        customers.add(new Customer("Aishwarya", "Rai", 8, R.drawable.c8));
        customers.add(new Customer("Asin", "Kaif", 9, R.drawable.c9));
        customers.add(new Customer("Arshi", "Khan", 10, R.drawable.c10));

        return customers;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Customer c = adapter.getItem(position);
        Toast.makeText(MainActivity.this, "You clicked " + c.getFirstName() + " " + c.getLastName(), Toast.LENGTH_SHORT).show();
    }
}
