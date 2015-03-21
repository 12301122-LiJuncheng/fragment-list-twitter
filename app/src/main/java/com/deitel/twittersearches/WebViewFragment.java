package com.deitel.twittersearches;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.deitel.twittersearches.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {

    private static WebViewFragment sInstance = null;
    private String urlString = null;

    private WebViewFragment() {
        // Required empty public constructor
    }

    public static WebViewFragment getInstance(){
        if(sInstance == null){
            sInstance = new WebViewFragment();
        }
        return sInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview,container,false);
        WebView webview = (WebView) view.findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl(urlString);

        return view;
    }

    public void setUrlString(String urlString){ this.urlString = urlString;}
}
