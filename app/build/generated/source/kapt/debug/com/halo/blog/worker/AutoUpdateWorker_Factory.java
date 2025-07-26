package com.halo.blog.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.halo.blog.data.repository.HaloRepository;
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

  public AutoUpdateWorker_Factory(Provider<HaloRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public AutoUpdateWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, repositoryProvider.get());
  }

  public static AutoUpdateWorker_Factory create(Provider<HaloRepository> repositoryProvider) {
    return new AutoUpdateWorker_Factory(repositoryProvider);
  }

  public static AutoUpdateWorker newInstance(Context context, WorkerParameters params,
      HaloRepository repository) {
    return new AutoUpdateWorker(context, params, repository);
  }
}
