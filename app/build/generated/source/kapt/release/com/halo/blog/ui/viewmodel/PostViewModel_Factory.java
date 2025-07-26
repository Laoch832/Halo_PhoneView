package com.halo.blog.ui.viewmodel;

import com.halo.blog.data.repository.HaloRepository;
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

  public PostViewModel_Factory(Provider<HaloRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PostViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static PostViewModel_Factory create(Provider<HaloRepository> repositoryProvider) {
    return new PostViewModel_Factory(repositoryProvider);
  }

  public static PostViewModel newInstance(HaloRepository repository) {
    return new PostViewModel(repository);
  }
}
