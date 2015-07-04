package gooners.balkan.arsenal.arsenalbalkangoonersandroid;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class StatsFragment5 extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = "stats";

    WebView webView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.statsfragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        webView = (WebView) getView().findViewById(R.id.webView);
        webView.loadUrl("http://192.168.0.100/arsenal");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(false);
        webView.setWebViewClient(new WebViewClient()) ;
        webView.getSettings().setGeolocationEnabled(false);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setBackgroundColor(Color.parseColor("#8B2338"));

        swipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(this);

        }

    @Override
    public void onRefresh() {

        swipeRefreshLayout.setRefreshing(true);

        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {

                swipeRefreshLayout.setRefreshing(false);
                webView.reload();
            }
        }, 4000);
    }


}
