package xyz.redbooks.kouluni.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xyz.redbooks.kouluni.R;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notice, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        holder.noticeDate.setText(R.string.holiday_date_string);
        holder.noticeText.setText(R.string.dummy_text);
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder{

        TextView noticeDate;
        TextView noticeText;

        NoticeViewHolder(View itemView) {
            super(itemView);
            noticeDate = itemView.findViewById(R.id.notice_date);
            noticeText = itemView.findViewById(R.id.notice_text);
        }
    }
}
