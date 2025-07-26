package com.halo.blog.utils;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UpdateManager_Factory implements Factory<UpdateManager> {
  private final Provider<Context> contextProvider;

  private final Provider<UpdateChecker> updateCheckerProvider;

  public UpdateManager_Factory(Provider<Context> contextProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    this.contextProvider = contextProvider;
    this.updateCheckerProvider = updateCheckerProvider;
  }

  @Override
  public UpdateManager get() {
    return newInstance(contextProvider.get(), updateCheckerProvider.get());
  }

  public static UpdateManager_Factory create(Provider<Context> contextProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    return new UpdateManager_Factory(contextProvider, updateCheckerProvider);
  }

  public static UpdateManager newInstance(Context context, UpdateChecker updateChecker) {
    return new UpdateManager(context, updateChecker);
  }
}
