package com.halo.blog.ui.viewmodel;

import com.halo.blog.data.repository.HaloRepository;
import com.halo.blog.utils.PreferenceManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class PostViewModel_Factory implements Factory<PostViewModel> {
  private final Provider<HaloRepository> repositoryProvider;

  private final Provider<PreferenceManager> preferenceManagerProvider;

  public PostViewModel_Factory(Provider<HaloRepository> repositoryProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.preferenceManagerProvider = preferenceManagerProvider;
  }

  @Override
  public PostViewModel get() {
    return newInstance(repositoryProvider.get(), preferenceManagerProvider.get());
  }

  public static PostViewModel_Factory create(Provider<HaloRepository> repositoryProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    return new PostViewModel_Factory(repositoryProvider, preferenceManagerProvider);
  }

  public static PostViewModel newInstance(HaloRepository repository,
      PreferenceManager preferenceManager) {
    return new PostViewModel(repository, preferenceManager);
  }
}
