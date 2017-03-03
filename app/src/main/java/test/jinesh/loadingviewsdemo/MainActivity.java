package test.jinesh.loadingviewsdemo;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import test.jinesh.loadingviews.LoadingImageView;
import test.jinesh.loadingviews.LoadingTextView;
import test.jinesh.loadingviewsdemo.bean.Data;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Data> dataArrayList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        dataArrayList = new ArrayList<>();
        prepareDummyDataForLoading();
        adapter = new Adapter();
        listView.setAdapter(adapter);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataArrayList.clear();
                prepareSomeDataForLoading();
                adapter.notifyDataSetChanged();
            }
        },4000);

    }

    private void prepareDummyDataForLoading() {
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), true));
    }
    private void prepareSomeDataForLoading() {
        dataArrayList.add(new Data("First City", "First State", "First Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Secnd City", "Secnd State", "Secnd Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Thrd City", "Thrd State", "Thrd Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Fourth City", "Fourth State", "Fourth Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Fifth City", "Fifth State", "Fifth Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Sixh City", "Sixh State", "Sixh Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Sevn City", "Sevn State", "Sevn Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
    }

    private class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return dataArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.adapter_row, viewGroup, false);
            LoadingTextView cityText = (LoadingTextView) view.findViewById(R.id.city);
            LoadingTextView stateText = (LoadingTextView) view.findViewById(R.id.state);
            LoadingTextView countryText = (LoadingTextView) view.findViewById(R.id.country);
            LoadingImageView cityImage = (LoadingImageView) view.findViewById(R.id.cityImage);
            cityText.setText(dataArrayList.get(i).getCityName());
            stateText.setText(dataArrayList.get(i).getStateName());
            countryText.setText(dataArrayList.get(i).getCountryName());
            cityImage.setImageDrawable(dataArrayList.get(i).getCityImage());
            if (dataArrayList.get(i).isLoading()) {
                cityText.startLoading();
                stateText.startLoading();
                countryText.startLoading();
                cityImage.startLoading();
            } else {
                cityText.stopLoading();
                stateText.stopLoading();
                countryText.stopLoading();
                cityImage.stopLoading();
            }
            return view;
        }
    }
}
