package com.yanzhenjie.andserver.sample.util;

import android.os.Environment;

import com.yanzhenjie.andserver.sample.App;
import com.yanzhenjie.andserver.util.IOUtils;

import java.io.File;

/**
 * Created by wuph on 2018/12/13.
 */

public class PathManager {
    private static PathManager sInstance;

    public static PathManager getInstance() {
        if(sInstance == null) {
            synchronized (PathManager.class) {
                if(sInstance == null) {
                    sInstance = new PathManager();
                }
            }
        }
        return sInstance;
    }

    private File mRootDir;

    private PathManager() {
        if (FileUtils.storageAvailable()) {
            mRootDir = Environment.getExternalStorageDirectory();
        } else {
            mRootDir = App.getInstance().getFilesDir();
        }
        mRootDir = new File(mRootDir + "/Android", "bfb91d7b066933625763c1f38eef8d48");
        IOUtils.createFolder(mRootDir + "/Android");
    }

    public String getRootDir() {
        return mRootDir.getAbsolutePath();
    }

    public String getWebDir() {
        return new File(mRootDir, "web").getAbsolutePath();
    }
}
