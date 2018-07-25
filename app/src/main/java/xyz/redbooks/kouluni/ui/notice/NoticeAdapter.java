package xyz.redbooks.kouluni.ui.notice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

        final ImageButton noticeDropdown = holder.notice_dropdown;
        final TextView noticeText = holder.noticeText;

        holder.noticeDate.setText(R.string.holiday_date_string);
        holder.noticeHeading.setText(R.string.parent_message_heading_string);
        noticeText.setText(R.string.dummy_text);

        noticeDropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(noticeText.getVisibility() == View.GONE){
                    noticeText.setVisibility(View.VISIBLE);
                    noticeDropdown.setImageResource(R.drawable.arrow_drop_up);
                }
                else {
                    noticeText.setVisibility(View.GONE);
                    noticeDropdown.setImageResource(R.drawable.arrow_drop_down);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder{

        TextView noticeDate;
        TextView noticeText;
        TextView noticeHeading;
        ImageButton notice_dropdown;

        NoticeViewHolder(View itemView) {
            super(itemView);
            noticeDate = itemView.findViewById(R.id.notice_date);
            noticeText = itemView.findViewById(R.id.notice_text);
            noticeHeading = itemView.findViewById(R.id.notice_heading);
            notice_dropdown = itemView.findViewById(R.id.notice_dropdown);
        }
    }
}
