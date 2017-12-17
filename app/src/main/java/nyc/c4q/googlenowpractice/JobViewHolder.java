package nyc.c4q.googlenowpractice;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.googlenowpractice.models.GitHubJob;

public class JobViewHolder extends RecyclerView.ViewHolder {

    private TextView randomJob;
    private TextView jobsLink;
    private ImageView logo;

    public JobViewHolder(View itemView) {
        super(itemView);

         randomJob = (TextView) itemView.findViewById(R.id.title);
         jobsLink = (TextView) itemView.findViewById(R.id.jobs_link_itemview);
         logo = (ImageView) itemView.findViewById(R.id.logo_imageview);
    }

    public void onBind(GitHubJob gitHubJob){
        randomJob.setText("Title: " + gitHubJob.getTitle());
        jobsLink.setText("Link to apply: " + gitHubJob.getHow_to_apply());
        Picasso.with(itemView.getContext()).load(gitHubJob.getCompany_logo()).into(logo);
    }
}
