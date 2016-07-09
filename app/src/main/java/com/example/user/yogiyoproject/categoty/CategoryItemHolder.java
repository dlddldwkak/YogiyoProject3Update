package com.example.user.yogiyoproject.categoty;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.yogiyoproject.R;


/**
 * Created by user on 2016-07-01.
 */
public class CategoryItemHolder extends RecyclerView.ViewHolder {

    OnItemClickListener mClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mClickListener = onItemClickListener;
    }

    //어떤 이미지인지? 어떤텍스트 인지?

  /*  ImageView image;
    TextView name;
    CategoryItemData itemData;
*/

    ImageView categoryItmImg;
    TextView categoryItmName;
    CategoryItemData itemData;

    public CategoryItemHolder(View itemView) {
        super(itemView);


        categoryItmImg = (ImageView) itemView.findViewById(R.id.category_item_image);
        categoryItmName = (TextView) itemView.findViewById(R.id.category_item_name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mClickListener != null) {
                    mClickListener.OnItemClicked(CategoryItemHolder.this, v, itemData, position);
                }
                }
        });
    }

    public void setItemData(CategoryItemData itemData) {

        categoryItmImg.setBackgroundResource(itemData.getIconId());
        categoryItmName.setText(itemData.getName());
    }

}
