package nyc.c4q.googlenowpractice;


import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
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
    private TextView locationTV;
    private TextView typeTV;
    private TextView companyTV;

    public JobViewHolder(View itemView) {
        super(itemView);

         randomJob = (TextView) itemView.findViewById(R.id.title);
         jobsLink = (TextView) itemView.findViewById(R.id.jobs_link_itemview);
         setColor();
         logo = (ImageView) itemView.findViewById(R.id.logo_imageview);
         allJobs = (TextView) itemView.findViewById(R.id.job_list);
         secondSetColor();
         locationTV = (TextView) itemView.findViewById(R.id.location);
         typeTV = (TextView) itemView.findViewById(R.id.type);
         companyTV = (TextView) itemView.findViewById(R.id.company);


    }

    private void setColor(){
        SpannableString wordtoSpan = new SpannableString("Apply Here: link");

        wordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 12, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordtoSpan.setSpan(new UnderlineSpan(), 12, 16, 0);

        jobsLink.setText(wordtoSpan);

    }

    private void secondSetColor(){
        if(allJobs == null) {
            return;
        }
        SpannableString wordtoSpan1 = new SpannableString("Click here to view more jobs");

        wordtoSpan1.setSpan(new ForegroundColorSpan(Color.BLUE), 6, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordtoSpan1.setSpan(new UnderlineSpan(), 6, 10, 0);

        allJobs.setText(wordtoSpan1);

    }

    public void onBind(GitHubJob gitHubJob, final LinkInterface linkInterface) {

        String title = String.format("Title: %s", gitHubJob.getTitle());
        randomJob.setText(title);

        String location = String.format("Location: %s", gitHubJob.getLocation());
        locationTV.setText(location);

        String type = String.format("Type: %s", gitHubJob.getType());
        typeTV.setText(type);

        String company = String.format("Company: %s", gitHubJob.getCompany());
        companyTV.setText(company);

        final String text = gitHubJob.getUrl();

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
