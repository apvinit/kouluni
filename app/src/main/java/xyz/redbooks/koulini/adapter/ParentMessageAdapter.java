package xyz.redbooks.koulini.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xyz.redbooks.koulini.R;

public class ParentMessageAdapter extends RecyclerView.Adapter<ParentMessageAdapter.ParentMessageViewHolder>{

    @NonNull
    @Override
    public ParentMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_message_card, parent, false);
        return new ParentMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentMessageViewHolder holder, int position) {
        holder.parentMessageDate.setText(R.string.parent_message_date_string);
        holder.parentMessageHeading.setText(R.string.parent_message_heading_string);
        holder.parentMessageBody.setText(R.string.parent_message_body_string);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class ParentMessageViewHolder extends RecyclerView.ViewHolder {

        TextView parentMessageDate;
        TextView parentMessageHeading;
        TextView parentMessageBody;

        public ParentMessageViewHolder(View itemView) {
            super(itemView);
            parentMessageDate = itemView.findViewById(R.id.parent_message_date);
            parentMessageHeading = itemView.findViewById(R.id.parent_message_heading);
            parentMessageBody = itemView.findViewById(R.id.parent_message_body);
        }
    }
}
