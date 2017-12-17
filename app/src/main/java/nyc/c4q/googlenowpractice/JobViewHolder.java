package nyc.c4q.googlenowpractice;


import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.googlenowpractice.models.GitHubJob;

public class JobViewHolder extends RecyclerView.ViewHolder {

    private TextView randomJob;
    private TextView jobsLink;
    private ImageView logo;
    private TextView allJobs;

    public JobViewHolder(View itemView) {
        super(itemView);

         randomJob = (TextView) itemView.findViewById(R.id.title);
         jobsLink = (TextView) itemView.findViewById(R.id.jobs_link_itemview);
         logo = (ImageView) itemView.findViewById(R.id.logo_imageview);
         allJobs = (TextView) itemView.findViewById(R.id.job_list);
    }

    public void onBind(GitHubJob gitHubJob, final LinkInterface linkInterface) {

        randomJob.setText("Title: " + gitHubJob.getTitle());
        final String text = gitHubJob.getUrl();
        jobsLink.setText("Apply Here: link");

        jobsLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkInterface.clickLink(text);
            }
        });

        Picasso.with(itemView.getContext()).load(gitHubJob.getCompany_logo()).into(logo);

        if (allJobs != null) {
            allJobs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linkInterface.clickAllJobs();
                }
            });
        }
    }
}
