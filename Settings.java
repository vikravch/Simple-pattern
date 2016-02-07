package com.example.dim.providerloaderasynctask;

import android.net.Uri;

/**
 * Created by Dim on 24.11.2015.
 */
public class Settings {
    public static final String ROW_NAME = "name";
    public static final String ROW_EMAIL = "email";
    public static final String PROVIDER_NAME = "com.example.dim.providerloaderasynctask";
    public static final String URI = "content://"+PROVIDER_NAME+"/cte";
    public static final Uri CONTENT_URI = Uri.parse(URI);
    public static final String ID = "_id";
    public static final String LOG_TAG = "ContentProviderAsyncLoad";
    public static final String USERS_PATH = "users";
    public static final String URI_USERS = "content://"+PROVIDER_NAME+"/"+USERS_PATH;
    public static final Uri CONTENT_URI_USERS = Uri.parse(URI_USERS);



}
