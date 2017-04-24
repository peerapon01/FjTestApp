package peerapon.me.fjtestapp.adapter;

/**
 * Created by peerapon01 on 4/24/2017 AD.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;


import java.util.ArrayList;
import java.util.List;


import butterknife.ButterKnife;
import butterknife.BindView;
import peerapon.me.fjtestapp.R;
import peerapon.me.fjtestapp.dto.ListResult;

public class FungjaiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String ITEM_VIEW_TYPE_ADS_STRING = "ads";
    private static final int ITEM_VIEW_TYPE_ADS = 0;
    private static final String ITEM_VIEW_TYPE_VIDEO_STRING = "video";
    private static final int ITEM_VIEW_TYPE_VIDEO = 1;
    private static final String ITEM_VIEW_TYPE_TRACK_STRING = "track";
    private static final int ITEM_VIEW_TYPE_TRACK = 2;
    private List<ListResult> listResults = new ArrayList<>();


    public FungjaiListAdapter(List<ListResult> listResults) {
        this.listResults = listResults;


    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_VIEW_TYPE_ADS) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ads, parent, false);
            //view.setOnClickListener(this);
            AdsViewHolder adsViewHolder = new AdsViewHolder(view);
            // adsViewHolder.cardViewAds.setOnClickListener(this);
            return adsViewHolder;
        } else if (viewType == ITEM_VIEW_TYPE_VIDEO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_video, parent, false);
            // view.setOnClickListener(this);
            VideoViewHolder videoViewHolder = new VideoViewHolder(view);
            //  videoViewHolder.cardViewVideo.setOnClickListener(this);
            return videoViewHolder;

        } else if (viewType == ITEM_VIEW_TYPE_TRACK) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_track, parent, false);
            //   view.setOnClickListener(this);
            TrackViewHolder trackViewHolder = new TrackViewHolder(view);
            //   trackViewHolder.cardViewTrack.setOnClickListener(this);
            return trackViewHolder;
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {
        int ITEM_VIEW_TYPE = 0;
        String type = listResults.get(position).getType();
        if (type.equals(ITEM_VIEW_TYPE_ADS_STRING)) {
            ITEM_VIEW_TYPE = 0;
        } else if (type.equals(ITEM_VIEW_TYPE_TRACK_STRING)) {
            ITEM_VIEW_TYPE = 2;
        } else if (type.equals(ITEM_VIEW_TYPE_VIDEO_STRING)) {
            ITEM_VIEW_TYPE = 1;
        }


        return ITEM_VIEW_TYPE;

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        Context context = viewHolder.itemView.getContext();
        if (viewHolder.getItemViewType() == ITEM_VIEW_TYPE_VIDEO) {
            final VideoViewHolder holder = (VideoViewHolder) viewHolder;
            Glide.with(context).load(listResults.get(position).getCoverUrl()).centerCrop().error(R.mipmap.ic_error_black_48dp)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            holder.play_video_icon.setVisibility(View.INVISIBLE);
                            holder.play_video_text.setVisibility(View.INVISIBLE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(holder.videoImg);


        } else if (viewHolder.getItemViewType() == ITEM_VIEW_TYPE_TRACK) {
            TrackViewHolder holder = (TrackViewHolder) viewHolder;
            Glide.with(context).load(listResults.get(position).getCoverUrl()).centerCrop().error(R.mipmap.ic_error_black_48dp).into(holder.trackImg);
            holder.trackName.setText(listResults.get(position).getName());


        } else if (viewHolder.getItemViewType() == ITEM_VIEW_TYPE_ADS) {
            AdsViewHolder holder = (AdsViewHolder) viewHolder;
            Glide.with(context).load(listResults.get(position).getCoverUrl()).centerCrop().error(R.mipmap.ic_error_black_48dp).into(holder.adsImg);

        }

    }


    public static class TrackViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_view_track)
        CardView cardViewTrack;

        @BindView(R.id.track_name)
        TextView trackName;

        @BindView(R.id.track_img)
        ImageView trackImg;

        TrackViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class AdsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_view_ads)
        CardView cardViewAds;

        @BindView(R.id.ads_img)
        ImageView adsImg;

        AdsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_view_video)
        CardView cardViewVideo;


        @BindView(R.id.video_img)
        ImageView videoImg;

        @BindView(R.id.video_play)
        ImageView play_video_icon;
        @BindView(R.id.play_video_text)
        TextView play_video_text;

        VideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public int getItemCount() {
        return listResults.size();
    }
}

