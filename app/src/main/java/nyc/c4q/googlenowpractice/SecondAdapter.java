package nyc.c4q.googlenowpractice;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nyc.c4q.googlenowpractice.models.GitHubJob;

public class SecondAdapter extends RecyclerView.Adapter<JobViewHolder> {

    private ArrayList<GitHubJob> list;
    private LinkInterface linkInterface;

    public SecondAdapter(ArrayList<GitHubJob> list, LinkInterface linkInterface){
        this.list = list;
        this.linkInterface = linkInterface;
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_second_activity, parent, false);
        return new JobViewHolder(childView);

    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {
        GitHubJob gitHubJob = list.get(position);

        holder.onBind(gitHubJob, linkInterface);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
