package jo.sangmyung.kr.put_on_this_dress.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jo.sangmyung.kr.put_on_this_dress.R;
import jo.sangmyung.kr.put_on_this_dress.StaticValue;
import jo.sangmyung.kr.put_on_this_dress.item.ShopItem;

public class ShopItemAdapter extends ArrayAdapter<ShopItem> {

    private int mResource;

    public ShopItemAdapter(@NonNull Context context, int resource, @NonNull List<ShopItem> objects) {
        super(context, resource, objects);
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = convertView;

        if (v == null) {
            v = inflater.inflate(mResource, parent, false);

            ImageView storeImageView = (ImageView) v.findViewById(R.id.img_store);
            TextView nameText = (TextView) v.findViewById(R.id.text_store_name);
            TextView likeText = (TextView) v.findViewById(R.id.text_like_count);

            Picasso.get().load(StaticValue.WEBSERVER_URI + getItem(position).getImages()[0]).placeholder(R.drawable.iu).into(storeImageView);

            LinearLayout layout = (LinearLayout) v.findViewById(R.id.layout_store_clothes);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    (int) parent.getResources().getDimension(R.dimen.cloth_image_size_in_shop_item),
                    (int) parent.getResources().getDimension(R.dimen.cloth_image_size_in_shop_item)
            );
            params.rightMargin = (int) parent.getResources().getDimension(R.dimen.cloth_image_right_margin_in_shop_item);

            for (int i = 1; i < getItem(position).getImages().length; ++i) {
                ImageView imageView = new ImageView(parent.getContext());

                Picasso.get().load(StaticValue.WEBSERVER_URI + getItem(position).getImages()[i]).placeholder(R.drawable.iu).into(imageView);

                if (i == getCount() - 1) params.rightMargin = 0;
                layout.addView(imageView, params);
            }

            nameText.setText(getItem(position).getName());
            likeText.setText(String.valueOf(getItem(position).getLikes()));

            /*if (position < getCount()) {
                v.layout
                LinearLayout.LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.bottomMargin = (int) parent.getResources().getDisplayMetrics().density * 16;
                v.setLayoutParams(layoutParams);
            }*/
        }

        return v;
    }

    @Override
    public void add(@Nullable ShopItem object) {
        super.add(object);
    }

    @Override
    public void remove(@Nullable ShopItem object) {
        super.remove(object);
    }

    @Override
    public void clear() {
        super.clear();
    }



    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public ShopItem getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(@Nullable ShopItem item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
