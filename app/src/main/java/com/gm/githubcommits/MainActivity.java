package com.gm.githubcommits;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ysanjeeva on 11/04/18.
 */

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Check whether the activity is using the layout version with
		// the fragment_container FrameLayout. If so, we must add the search fragment
		if (findViewById(R.id.fragment_container) != null) {

			// However, if we're being restored from a previous state,
			// then we don't need to do anything and should return or else
			// we could end up with overlapping fragments.
			if (savedInstanceState != null) {
				return;
			}

			CommitListFragment fragment = new CommitListFragment();
			Bundle args = new Bundle();
			args.putString(CommitListFragment.ARG_SEARCH_REQUEST, "dagger");
			fragment.setArguments(args);

			getSupportFragmentManager().beginTransaction().add(
					R.id.fragment_container, fragment).commit();
		}
	}
}
