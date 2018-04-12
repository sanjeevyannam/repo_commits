package com.gm.githubcommits;

/**
 * Created by ysanjeeva on 11/04/18.
 */

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.gm.githubcommits.loader.CommitListLoader;
import com.gm.githubcommits.model.Repository;
import com.gm.githubcommits.utils.Constants;
import com.gm.githubcommits.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This ListFragment displays a list of commits.
 * It uses an {@link CommitListAdapter} to load
 * its data and the LoaderManager to manage the loader across the activity
 * and fragment life cycles.
 */
public class CommitListFragment extends ListFragment implements
        SearchView.OnQueryTextListener, LoaderManager.LoaderCallbacks<List<Repository>> {
    private static final String TAG = Constants.TAG+"CommitListFragment";
    private static final boolean DEBUG = true;

    // We use a custom BaseAdapter to bind application info to the ListView.
    private CommitListAdapter mAdapter;

    // The Loader's id (this id is specific to the ListFragment's LoaderManager)
    private static final int LOADER_ID = 1;

    public static final String ARG_SEARCH_REQUEST = "request";

    // If non-null, this is the current filter the user has provided.
    //User can filter the repositories based on query text
    String mCurFilter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = super.onCreateView(inflater, container, savedInstanceState);
        mCurFilter = getArguments().getString(ARG_SEARCH_REQUEST);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(R.string.toolbar_title_commit_list);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);

        mAdapter = new CommitListAdapter(getActivity(), new ArrayList<Repository>());
        setEmptyText(getString(R.string.empty_commits));
        setListAdapter(mAdapter);
        setListShown(false);

        if (DEBUG) {
            Log.i(TAG, "+++ Calling initLoader()! +++");
            if (getLoaderManager().getLoader(LOADER_ID) == null) {
                Log.i(TAG, "+++ Initializing the new Loader... +++");
            } else {
                Log.i(TAG, "+++ Reconnecting with existing Loader (id '1')... +++");
            }
        }

        //Inform the user that data is not available
        if(!Utils.isInternetAvailable(getContext())) {
            Toast.makeText(getContext(), getText(R.string.des_no_data),
                    Toast.LENGTH_SHORT).show();
        }

        // Initialize a Loader with id '1'. If the Loader with this id already
        // exists, then the LoaderManager will reuse the existing Loader.
        getLoaderManager().initLoader(LOADER_ID, null, this);
    }

    /**********************/
    /** LOADER CALLBACKS **/
    /**********************/

    @Override
    public Loader<List<Repository>> onCreateLoader(int id, Bundle args) {
        if (DEBUG) Log.i(TAG, "+++ onCreateLoader() called! +++");
        return new CommitListLoader(getActivity(), mCurFilter);
    }

    @Override
    public void onLoadFinished(Loader<List<Repository>> loader, List<Repository> data) {
        if (DEBUG) Log.i(TAG, "+++ onLoadFinished() called! +++");
        mAdapter.setRepoList(data);
        mAdapter.notifyDataSetChanged();

        if (isResumed()) {
            setListShown(true);
        } else {
            setListShownNoAnimation(true);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Repository>> loader) {
        if (DEBUG) Log.i(TAG, "+++ onLoadReset() called! +++");
        mAdapter.setRepoList(null);
    }

    public boolean onQueryTextChange(String newText) {
        //Don't care about this
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        //Called when the action bar search text changed and user selected
        // search key
        mCurFilter = !TextUtils.isEmpty(query) ? query : null;
        getLoaderManager().restartLoader(0, null, this);
        return true;
    }
}
