package com.halo.blog.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.halo.blog.data.repository.HaloRepository;
import com.halo.blog.utils.UpdateChecker;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AutoUpdateWorker_Factory {
  private final Provider<HaloRepository> repositoryProvider;

  private final Provider<UpdateChecker> updateCheckerProvider;

  public AutoUpdateWorker_Factory(Provider<HaloRepository> repositoryProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.updateCheckerProvider = updateCheckerProvider;
  }

  public AutoUpdateWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, repositoryProvider.get(), updateCheckerProvider.get());
  }

  public static AutoUpdateWorker_Factory create(Provider<HaloRepository> repositoryProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    return new AutoUpdateWorker_Factory(repositoryProvider, updateCheckerProvider);
  }

  public static AutoUpdateWorker newInstance(Context context, WorkerParameters params,
      HaloRepository repository, UpdateChecker updateChecker) {
    return new AutoUpdateWorker(context, params, repository, updateChecker);
  }
}
