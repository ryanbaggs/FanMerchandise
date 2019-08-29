package com.fastburngames.fanmerchandise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Class is the Adapter for the RecyclerView, it inflates the Article data
 * into the RecyclerView.
 */
public class ArticleItemAdapter extends RecyclerView.Adapter<ArticleItemAdapter.ViewHolder> {

    // Member variables.
    private Context mContext;

    /**
     * Constructor that passes in the Context and the Article data.
     * TODO: Write comment, enter in Article data.
     *
     * @param context The context of the application.
     */
    public ArticleItemAdapter(Context context){
        this.mContext = context;
    }

    /**
     * Required method for creating the viewHolder object, inflates the
     * article_list_item view into the parent view from the context.
     *
     * @param parent The ViewGroup that the view will be put into after it is
     *               bound to the adapter position.
     * @param viewType The View type of the new View.
     * @return The newly created ViewHolder.
     */
    @NonNull
    @Override
    public ArticleItemAdapter.ViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.article_list_item, parent, false));
    }

    /**
     * Required method for binding the data to the ViewHolder.
     *
     * @param holder The ViewHolder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // TODO: Write code to bind the data to the current position
        //  of the adapter.
    }

    /**
     * Required method used to return the size of the data set.
     *
     * @return The number of Articles within the data set.
     */
    @Override
    public int getItemCount() {
        // TODO: Code return size() of Article list.
        return 0;
    }

    /**
     * The ViewHolder class holds the independent Views within the ViewHolder
     * that correspond with the views in article_list_item layout file.
     * Handles the cnClick() event on the overall ViewHolder.
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View
            .OnClickListener{

        // TODO: Initialize Views for the Articles.
        ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        /**
         * TODO: Setup intent for launching DetailActivity based off of
         *       which Article was selected.
         */
        @Override
        public void onClick(View v) {

        }

        // TODO: Add bindTo() method that binds data to the views.
    }
}
