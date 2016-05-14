package com.example.jdolan.listyview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int totalSteps = 0;
    private int maxSteps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.listView);
        final TextView textView = (TextView) findViewById(R.id.textView);

        String[] values = new String[]{"3/4/2016", "450", "5/4/2016",
                "1039", "10/4/2016", "2334", "10/4/2016", "1578",
                "10/4/2016", "2342", "10/4/2016", "6565", "10/4/2016", "6771",
                "12/4/2016", "4234", "15/4/2016", "1211", "17/4/2016", "4334",
                "22/4/2016", "1211", "20/4/2016", "232", "21/4/2016", "3311"
        };

        final ArrayList<String> list = new ArrayList<String>();

        list.add ("DATE       :   STEPS");

        for (int i = 0; i < (values.length)/2; i += 2) {
            totalSteps = totalSteps + Integer.parseInt(values[i+1]);
            // now adding one String made from date : steps
            list.add(values[i] + "  :  " + values[i+1]);
        }
       // textView.setText(String.format("%s", "Total Step Count = " + totalSteps));
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);



    /*    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                list.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        }); */

    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }


    }

}