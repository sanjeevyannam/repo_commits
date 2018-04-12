package com.gm.githubcommits.loader;

/**
 * Created by ysanjeeva on 11/04/18.
 */

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.gm.githubcommits.api.ApiConstants;
import com.gm.githubcommits.api.GitHubController;
import com.gm.githubcommits.model.GitHubRepository;
import com.gm.githubcommits.model.GitHubResponce;
import com.gm.githubcommits.model.GitHubUser;
import com.gm.githubcommits.model.Repository;
import com.gm.githubcommits.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

;

/**
 * An implementation of AsyncTaskLoader which loads a {@code List<Repository>}
 * containing repositories .
 */
public class CommitListLoader extends AsyncTaskLoader<List<Repository>> {
  private static final String TAG = Constants.TAG+"CommitListLoader";
  private static final boolean DEBUG = true;

  public final String mFilter;

  // We hold a reference to the Loader's data here.
  private List<Repository> mRepositories;

  public CommitListLoader(Context ctx, String filter) {
    // Loaders may be used across multiple Activitys (assuming they aren't
    // bound to the LoaderManager), so NEVER hold a reference to the context
    // directly. Doing so will cause you to leak an entire Activity's context.
    // The superclass constructor will store a reference to the Application
    // Context instead, and can be retrieved with a call to getContext().
    super(ctx);
    mFilter = filter;
  }

  /****************************************************/
  /** (1) A task that performs the asynchronous load **/
  /****************************************************/

  /**
   * This method is called on a background thread and generates a List of
   * {@link Repository} objects. Each entry corresponds to a single Git hub repository.
   */
  @Override
  public List<Repository> loadInBackground() {
    if (DEBUG) Log.i(TAG, "+++ loadInBackground() called! +++");

    GitHubController controller = new GitHubController();
    List<Repository> repList = new ArrayList<>();

    Call<GitHubResponce> call =  controller.start(mFilter, ApiConstants.REPO_SORT_TYPE,
            ApiConstants.REPO_ORDER_TYPE, ApiConstants.REPO_LIMIT_PER_PAGE);
    try {
      Response<GitHubResponce> response = call.execute();
      if(response.isSuccessful()) {
        Log.i(Constants.TAG, " response is Success");
        List<GitHubRepository> reps = response.body().getItems();
        for(GitHubRepository rep : reps) {
          GitHubUser user = rep.getOwner();

          Log.i(TAG,"commit is :"+rep.getDescription());
          repList.add(new Repository(user.getLogin(), rep.getDescription(), rep.getGitCommitsUrl()));
        }
      } else {
        Log.i(Constants.TAG, " response is fail :" +response.errorBody());
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return repList;
  }

  /*******************************************/
  /** (2) Deliver the results to the client **/
  /*******************************************/

  /**
   * Called when there is new data to deliver to the client. The superclass will
   * deliver it to the registered listener (i.e. the LoaderManager), which will
   * forward the results to the client through a call to onLoadFinished.
   */
  @Override
  public void deliverResult(List<Repository> reps) {
    if (isReset()) {
      if (DEBUG) Log.w(TAG, "+++ Warning! An async query came in while the Loader was reset! +++");
      // The Loader has been reset; ignore the result and invalidate the data.
      if (reps != null) {
        releaseResources(reps);
        return;
      }
    }

    // Hold a reference to the old data so it doesn't get garbage collected.
    // We must protect it until the new data has been delivered.
    List<Repository> oldReps = mRepositories;
    mRepositories = reps;

    if (isStarted()) {
      if (DEBUG) Log.i(TAG, "+++ Delivering results to the LoaderManager for" +
      		" the ListFragment to display! +++");
      // If the Loader is in a started state, have the superclass deliver the
      // results to the client.
      super.deliverResult(reps);
    }

    // Invalidate the old data as we don't need it any more.
    if (oldReps != null && oldReps != reps) {
      if (DEBUG) Log.i(TAG, "+++ Releasing any old data associated with this Loader. +++");
      releaseResources(oldReps);
    }
  }

  /*********************************************************/
  /** (3) Implement the Loader�s state-dependent behavior **/
  /*********************************************************/

  @Override
  protected void onStartLoading() {
    if (DEBUG) Log.i(TAG, "+++ onStartLoading() called! +++");

    if (mRepositories != null) {
      // Deliver any previously loaded data immediately.
      if (DEBUG) Log.i(TAG, "+++ Delivering previously loaded data to the client...");
      deliverResult(mRepositories);
    }

    if (takeContentChanged()) {
      // When the observer detects a new repository, it will call
      // onContentChanged() on the Loader, which will cause the next call to
      // takeContentChanged() to return true. If this is ever the case (or if
      // the current data is null), we force a new load.
      if (DEBUG) Log.i(TAG, "+++ A content change has been detected... so force load! +++");
      forceLoad();
    } else if (mRepositories == null) {
      // If the current data is null... then we should make it non-null! :)
      if (DEBUG) Log.i(TAG, "+++ The current data is data is null... so force load! +++");
      forceLoad();
    }
  }

  @Override
  protected void onStopLoading() {
    if (DEBUG) Log.i(TAG, "+++ onStopLoading() called! +++");

    // The Loader has been put in a stopped state, so we should attempt to
    // cancel the current load (if there is one).
    cancelLoad();

    // Note that we leave the observer as is; Loaders in a stopped state
    // should still monitor the data source for changes so that the Loader
    // will know to force a new load if it is ever started again.
  }

  @Override
  protected void onReset() {
    if (DEBUG) Log.i(TAG, "+++ onReset() called! +++");

    // Ensure the loader is stopped.
    onStopLoading();

    // At this point we can release the resources associated with 'repositories'.
    if (mRepositories != null) {
      releaseResources(mRepositories);
      mRepositories = null;
    }
  }

  @Override
  public void onCanceled(List<Repository> reps) {
    if (DEBUG) Log.i(TAG, "+++ onCanceled() called! +++");

    // Attempt to cancel the current asynchronous load.
    super.onCanceled(reps);

    // The load has been canceled, so we should release the resources
    // associated with 'mRepositories'.
    releaseResources(reps);
  }

  @Override
  public void forceLoad() {
    if (DEBUG) Log.i(TAG, "+++ forceLoad() called! +++");
    super.forceLoad();
  }

  /**
   * Helper method to take care of releasing resources associated with an
   * actively loaded data set.
   */
  private void releaseResources(List<Repository> reps) {
    // For a simple List, there is nothing to do.
  }
}
