package com.fastburngames.fanmerchandise.database;

import com.google.firebase.firestore.FirebaseFirestore;

/**
 * This class is the Firestore database which will handle all of the work
 * done by a Room database, online database and a repository all in one.
 */
public class FirestoreDatabase {

    public FirestoreDatabase(){
        // Initialize the database.

        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }
}
