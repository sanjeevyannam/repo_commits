package com.gm.githubcommits;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gm.githubcommits.model.Repository;

import java.util.List;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class CommitListAdapter extends BaseAdapter {

	private Context mContext;
	private List<Repository> repoList;

	public CommitListAdapter(Context mContext, List<Repository> repoList) {
		this.mContext = mContext;
		this.repoList = repoList;
	}

	public void setRepoList(List<Repository> repoList) {
		this.repoList = repoList;
	}

	@Override
	public int getCount() {
		if(repoList != null) {
			return repoList.size();
		} else {
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		return null; // we don't need it now
	}

	@Override
	public long getItemId(int position) {
		return 0; // we don't need it now
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		final ViewHolder holder;

		if (row == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			row = inflater.inflate(R.layout.row_repository, parent, false);
			holder = new ViewHolder();
			holder.userName = (TextView) row.findViewById(R.id.text_name);
			holder.commit = (TextView) row.findViewById(R.id.text_commit);
			holder.commitMessage = (TextView) row.findViewById(R.id.text_commit_message);
			row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}

		String commitMsg = repoList.get(position).getCommitMsg();
		//If the text is non English, setting text for the row is causing ANR,
		//So for time being shrink the text to 1000 chars for safe side
		//TODO fix this
		/*if(commitMsg != null && commitMsg.length() > 1000) {
			commitMsg = commitMsg.substring(0, 1000);
		}*/

		holder.userName.setText(repoList.get(position).getName());
		holder.commit.setText(repoList.get(position).getCommit());
		holder.commitMessage.setText(commitMsg);

		return row;
	}

	static class ViewHolder {
		TextView userName;
		TextView commit;
		TextView commitMessage;
	}

}
