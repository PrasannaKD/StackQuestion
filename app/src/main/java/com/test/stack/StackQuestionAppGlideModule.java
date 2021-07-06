package com.test.stack;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Glide module for StackQuestion app.
 */
@GlideModule
public class StackQuestionAppGlideModule extends AppGlideModule {

    /**
     * Disabling manifest parsing to avoid adding same module twice.
     *
     * @return true or false.
     */
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
