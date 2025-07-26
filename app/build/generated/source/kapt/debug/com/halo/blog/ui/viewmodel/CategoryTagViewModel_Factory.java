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
public final class CategoryTagViewModel_Factory implements Factory<CategoryTagViewModel> {
  private final Provider<HaloRepository> repositoryProvider;

  public CategoryTagViewModel_Factory(Provider<HaloRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CategoryTagViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static CategoryTagViewModel_Factory create(Provider<HaloRepository> repositoryProvider) {
    return new CategoryTagViewModel_Factory(repositoryProvider);
  }

  public static CategoryTagViewModel newInstance(HaloRepository repository) {
    return new CategoryTagViewModel(repository);
  }
}
