package xyz.redbooks.kouluni.ui.user.parentMessage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3
 */

public class ParentMessageAdapter extends RecyclerView.Adapter<ParentMessageAdapter.ParentMessageViewHolder>{

    public ParentMessageAdapter(){

    }

    @NonNull
    @Override
    public ParentMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent_message, parent, false);
        return new ParentMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ParentMessageViewHolder holder, final int position) {
        TextView date = holder.parentMessageDate;
        final TextView body = holder.parentMessageBody;
        TextView heading = holder.parentMessageHeading;
        final ImageButton dropdown = holder.dropdown;

        date.setText(R.string.parent_message_date_string);
        heading.setText(R.string.parent_message_heading_string);
        body.setText(R.string.parent_message_body_string);
        holder.dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(body.getVisibility() == View.GONE){
                    body.setVisibility(View.VISIBLE);
                    dropdown.setImageResource(R.drawable.arrow_drop_up);
                }
                else {
                    body.setVisibility(View.GONE);
                    dropdown.setImageResource(R.drawable.arrow_drop_down);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ParentMessageViewHolder extends RecyclerView.ViewHolder {

        TextView parentMessageDate;
        TextView parentMessageHeading;
        TextView parentMessageBody;
        ImageButton dropdown;

        ParentMessageViewHolder(View itemView) {
            super(itemView);
            parentMessageDate = itemView.findViewById(R.id.parent_message_date);
            parentMessageHeading = itemView.findViewById(R.id.parent_message_heading);
            parentMessageBody = itemView.findViewById(R.id.parent_message_body);
            dropdown = itemView.findViewById(R.id.dropdown);
        }
    }
}
