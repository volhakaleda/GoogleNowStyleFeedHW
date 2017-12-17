package nyc.c4q.googlenowpractice;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.function.ToDoubleBiFunction;

import nyc.c4q.googlenowpractice.models.GitHubJob;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    GitHubJob gitHubJob;
    private static final int VIEW_TYPE_GITHUBJOB = 0;
    private static final int VIEW_TYPE_X = 1;
    private static final int VIEW_TYPE_Y = 2;
    private LinkInterface linkInterface;

    public FeedAdapter(LinkInterface linkInterface) {
        this.linkInterface = linkInterface;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_GITHUBJOB:
                View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_viewholder_layout, parent, false);
                return new JobViewHolder(childView);

//          TODO: for Raheel
//            case VIEW_TYPE_X:
//                View childView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_viewholder_layout, parent, false);
//                return new JobViewHolder(childView1);

////          TODO: for Vivian
//            case VIEW_TYPE_Y:
//                View childView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_viewholder_layout, parent, false);
//                return new JobViewHolder(childView2);
        }
        throw new IllegalArgumentException("Illegal ViewType " + viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);

        switch (viewType) {

            case VIEW_TYPE_GITHUBJOB:
                if (gitHubJob == null) {
                    return;
                }
                JobViewHolder jobHolder = (JobViewHolder) holder;
                jobHolder.onBind(gitHubJob, linkInterface);
                break;

//                TODO for Raheel

//            case VIEW_TYPE_X:
//                if (gitHubJob == null) {
//                    return;
//                }
//                JobViewHolder jobHolder = (JobViewHolder) holder;
//                jobHolder.onBind(gitHubJob, linkInterface);
//                break;

//                TODO for Vivian

//            case VIEW_TYPE_Y:
//                if (gitHubJob == null) {
//                    return;
//                }
//                JobViewHolder jobHolder = (JobViewHolder) holder;
//                jobHolder.onBind(gitHubJob, linkInterface);
//                break;
        }
    }
//
//              TODO for the last person to correct ItemCount to 3
    @Override
    public int getItemCount() {
        return 1;
    }

    public void setGitHubJob(GitHubJob gitHubJob){
        this.gitHubJob = gitHubJob;
    }

    @Override
    public int getItemViewType(int position) {

        if(position == 0) {
            return VIEW_TYPE_GITHUBJOB;
        }
        else if(position ==1) {
            return VIEW_TYPE_X;
        }
        else{
            return VIEW_TYPE_Y;
        }
    }
}
