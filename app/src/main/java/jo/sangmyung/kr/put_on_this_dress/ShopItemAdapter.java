package jo.sangmyung.kr.put_on_this_dress;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ShopItemAdapter extends ArrayAdapter<ShopItem> {

    private List<ShopItem> mObjects;
    private int mResource;
    private int count = 0;

    public ShopItemAdapter(@NonNull Context context, int resource, @NonNull List<ShopItem> objects) {
        super(context, resource, objects);

        mObjects = objects;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = convertView;

        if (v == null) {
            v = inflater.inflate(mResource, parent, false);

            LinearLayout layout = (LinearLayout) v.findViewById(R.id.layout_store_clothes);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    (int) parent.getResources().getDimension(R.dimen.cloth_image_size_in_shop_item),
                    (int) parent.getResources().getDimension(R.dimen.cloth_image_size_in_shop_item)
            );
            params.rightMargin = (int) parent.getResources().getDimension(R.dimen.cloth_image_right_margin_in_shop_item);

            for (int i = 0; i < mObjects.size(); ++i) {
                ImageView imageView = new ImageView(parent.getContext());

                Picasso.get().load(StaticValue.WEBSERVER_URI + mObjects.get(position).getImages()[i]).placeholder(R.drawable.iu).into(imageView);

                if (i == mObjects.size() - 1) params.rightMargin = 0;
                layout.addView(imageView, params);
            }
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
