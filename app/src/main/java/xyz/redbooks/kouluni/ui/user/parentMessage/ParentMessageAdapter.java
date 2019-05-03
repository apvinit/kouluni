package xyz.redbooks.kouluni.ui.user.parentMessage;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3
 */

public class ParentMessageAdapter extends RecyclerView.Adapter<ParentMessageAdapter.ParentMessageViewHolder>{

    ParentMessageAdapter(){

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
        final ImageView dropdown = holder.dropdown;
        CardView cardParentMessage = holder.cardParentMessage;

        date.setText(R.string.date);
        heading.setText(R.string.parent_message_heading_string);
        body.setText(R.string.parent_message_body_string);
        cardParentMessage.setOnClickListener(new View.OnClickListener() {
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

        @BindView(R.id.card_parent_message) CardView cardParentMessage;
        @BindView(R.id.parent_message_date) TextView parentMessageDate;
        @BindView(R.id.parent_message_heading) TextView parentMessageHeading;
        @BindView(R.id.parent_message_body) TextView parentMessageBody;
        @BindView(R.id.dropdown) ImageView dropdown;

        ParentMessageViewHolder(View itemView) {
            super(itemView);

            //Inject ButterKnife
            ButterKnife.bind(this,itemView);
        }
    }
}
