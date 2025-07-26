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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<HaloRepository> repositoryProvider;

  public SearchViewModel_Factory(Provider<HaloRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<HaloRepository> repositoryProvider) {
    return new SearchViewModel_Factory(repositoryProvider);
  }

  public static SearchViewModel newInstance(HaloRepository repository) {
    return new SearchViewModel(repository);
  }
}
