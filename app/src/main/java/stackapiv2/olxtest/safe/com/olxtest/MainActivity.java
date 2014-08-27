package stackapiv2.olxtest.safe.com.olxtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import junit.framework.Assert;

import org.json.JSONObject;

import stackapiv2.olxtest.safe.com.olxtest.adapters.BrowseAdapter;
import stackapiv2.olxtest.safe.com.olxtest.models.BrowseModel;
import stackapiv2.olxtest.safe.com.olxtest.requests.BaseRequest;
import stackapiv2.olxtest.safe.com.olxtest.requests.BrowseRequest;
import stackapiv2.olxtest.safe.com.olxtest.requests.SearchRequest;

/**
 * @author Pudit Prasert
 * safefy@gmail.com
 **/

public class MainActivity extends ActionBarActivity {
    private ListView mListView;
    private EditText mSearchEt;
    private ImageButton mSearchBtn;
    private BrowseAdapter mAdapter;
    private ProgressBar mPb;
    private Gson mGson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.activity_main_lv);
        mSearchEt = (EditText) findViewById(R.id.activity_main_search_et);
        mSearchBtn = (ImageButton) findViewById(R.id.activity_main_search_btn);
        mPb = (ProgressBar) findViewById(R.id.activity_main_pb);

        Assert.assertNotNull(mListView);
        Assert.assertNotNull(mSearchEt);
        Assert.assertNotNull(mSearchBtn);
        Assert.assertNotNull(mPb);

        new BrowseRequest(this, new BaseRequest.ResponseCallback() {
            @Override
            public void onComplete(final JSONObject jsonObject) {
                mPb.setVisibility(View.GONE);
                mAdapter = new BrowseAdapter(MainActivity.this, mGson.fromJson(jsonObject.toString(), BrowseModel.class).items);
                mListView.setAdapter(mAdapter);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mGson.fromJson(jsonObject.toString(), BrowseModel.class).items.get((int)l).link));
                        startActivity(browserIntent);
                    }
                });
            }

            @Override
            public void onError(String error) {
                mPb.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
            }
        });

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListView.setAdapter(null);
                mPb.setVisibility(View.VISIBLE);
                new SearchRequest(MainActivity.this, mSearchEt.getText().toString(), new BaseRequest.ResponseCallback() {
                    @Override
                    public void onComplete(final JSONObject jsonObject) {
                        mPb.setVisibility(View.GONE);
                        mAdapter = new BrowseAdapter(MainActivity.this, mGson.fromJson(jsonObject.toString(), BrowseModel.class).items);
                        mListView.setAdapter(mAdapter);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mGson.fromJson(jsonObject.toString(), BrowseModel.class).items.get((int)l).link));
                                startActivity(browserIntent);
                            }
                        });
                    }

                    @Override
                    public void onError(String error) {
                        mPb.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
