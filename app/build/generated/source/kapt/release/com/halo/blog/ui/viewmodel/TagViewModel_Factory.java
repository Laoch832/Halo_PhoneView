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
public final class TagViewModel_Factory implements Factory<TagViewModel> {
  private final Provider<HaloRepository> repositoryProvider;

  public TagViewModel_Factory(Provider<HaloRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TagViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static TagViewModel_Factory create(Provider<HaloRepository> repositoryProvider) {
    return new TagViewModel_Factory(repositoryProvider);
  }

  public static TagViewModel newInstance(HaloRepository repository) {
    return new TagViewModel(repository);
  }
}
