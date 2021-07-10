package com.example.recyclerview_article_scroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<Article> articleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvrecyclerView);
        buildArticleList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArticleAdapter articleAdapter = new ArticleAdapter(articleList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(articleAdapter);
    }

    private void buildArticleList() {
        articleList = new ArrayList<>();
        for (int i = 0 ; i<100; i++){
            if (i%2 == 0){
                Article article = new Article(R.drawable.blue_waves, "Blue Ocean Waves Crash",
                        "Featured",R.drawable.ic_logo, "See the beautiful oceans of the " +
                        "Pacific coast where the water is so clean you can see the sand.", "J.K.Rowling");
                articleList.add(article);
            } else {
                Article article = new Article(R.drawable.bridge_photo, "Long Exposure River Bridge",
                        "Featured",R.drawable.ic_logo, "Long exposure photography is when you " +
                        "leave the shutter open longer than usual to pick up more light.", "George R. R. Martin");
                articleList.add(article);
            }
        }
    }

    @Override
    public void onItemClicked(int position, Article article) {
        article.setExpanded(!article.isExpanded());

    }
}