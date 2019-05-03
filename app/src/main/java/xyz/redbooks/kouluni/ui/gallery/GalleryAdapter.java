package xyz.redbooks.kouluni.ui.gallery;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private int[] imagesResource = {
            R.drawable.gallery_image1,
            R.drawable.gallery_image2,
            R.drawable.gallery_image3,
            R.drawable.gallery_image4,
            R.drawable.gallery_image5,
            R.drawable.gallery_image6,
            R.drawable.gallery_image7,
            R.drawable.gallery_image8,
            R.drawable.gallery_image9,
            R.drawable.school1,
            R.drawable.school2,
            R.drawable.school3
    };

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Picasso.get().load(imagesResource[position]).into(holder.galleryImage);
    }

    @Override
    public int getItemCount() {
        return imagesResource.length;
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView galleryImage;

        GalleryViewHolder(View itemView) {
            super(itemView);
            galleryImage = itemView.findViewById(R.id.gallery_image);

        }
    }
}
