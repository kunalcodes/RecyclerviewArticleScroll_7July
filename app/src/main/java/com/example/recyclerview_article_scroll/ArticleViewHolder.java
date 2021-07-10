package com.example.recyclerview_article_scroll;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvImage;
    private TextView mTvSection;
    private TextView mTvTitle;
    private View mIvLogo;
    private TextView mTvBody;
    private TextView mTvAuthor;
    private ItemClickListener itemClickListener;
    private LinearLayout linearLayout;


    public ArticleViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.ivMainImage);
        mTvSection = itemView.findViewById(R.id.tvSection);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
        mIvLogo = itemView.findViewById(R.id.ivLogo);
        mTvBody = itemView.findViewById(R.id.tvBody);
        mTvAuthor = itemView.findViewById(R.id.tvAuthor);
        linearLayout = itemView.findViewById(R.id.lvArticle);

    }

    public void setData(Article article){
        mIvImage.setImageResource(article.getImage());
        mIvLogo.setBackgroundResource(article.getLogo());
        mTvTitle.setText(article.getTitle());
        mTvSection.setText(article.getSection());
        mTvBody.setText(article.getBody());
        mTvAuthor.setText((article.getAuthor()));
        mTvAuthor.setVisibility(View.GONE);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), article);
                boolean isExpanded = article.isExpanded();
                if (isExpanded){
                    mTvAuthor.setVisibility(View.VISIBLE);
                } else {
                    mTvAuthor.setVisibility(View.GONE);
                }
            }
        });

    }
}
