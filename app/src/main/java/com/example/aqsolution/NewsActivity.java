package com.example.aqsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsActivity extends AppCompatActivity {

    ListView listView;
    AdapternewsClass adapternewsClass;
    ArrayList<DocbaoClass> mangdocbao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        listView=(ListView) findViewById(R.id.lv_Tieude);

        mangdocbao=new ArrayList<DocbaoClass>();


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Readdata().execute("https://vnexpress.net/rss/giao-duc.rss");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(NewsActivity.this,mangdocbao.get(position).link,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(NewsActivity.this,NewsdetailActivity.class);
                intent.putExtra("link",mangdocbao.get(position).link);
                startActivity(intent);
            }
        });
    }
    class Readdata extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            XMLDOMParser parser =new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList= document.getElementsByTagName("item");
//            đọc Cdata
            NodeList nodeListdescription = document.getElementsByTagName("description");
            String hinhanh="";
            String title = "";
            String link ="";
            for (int i=0; i<nodeList.getLength(); i++){
                String cdata=nodeListdescription.item(i + 1).getTextContent();
                Pattern p=Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher=p.matcher(cdata);
                if (matcher.find()){
                    hinhanh=matcher.group(1);
//                    Log.d("hinhanh",hinhanh + "......."+i);
                }

                Element element = (Element) nodeList.item(i);
                title = parser.getValue(element,"title");
//                Toast.makeText(NewsActivity.this,title,Toast.LENGTH_LONG).show();
                link= parser.getValue(element,"link");
//                Log.d("link",link);

                mangdocbao.add(new DocbaoClass(title,link,hinhanh));
            }
            adapternewsClass =new AdapternewsClass(NewsActivity.this,R.layout.support_simple_spinner_dropdown_item,mangdocbao);
            listView.setAdapter(adapternewsClass);

            super.onPostExecute(s);

//            Toast.makeText(NewsActivity.this,s,Toast.LENGTH_SHORT).show();
        }
    }
    private String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
    }
}
