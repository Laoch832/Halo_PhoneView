package com.halo.blog.ui.viewmodel;

import android.content.Context;
import com.halo.blog.data.repository.HaloRepository;
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
public final class CommentViewModel_Factory implements Factory<CommentViewModel> {
  private final Provider<HaloRepository> repositoryProvider;

  private final Provider<Context> contextProvider;

  public CommentViewModel_Factory(Provider<HaloRepository> repositoryProvider,
      Provider<Context> contextProvider) {
    this.repositoryProvider = repositoryProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public CommentViewModel get() {
    return newInstance(repositoryProvider.get(), contextProvider.get());
  }

  public static CommentViewModel_Factory create(Provider<HaloRepository> repositoryProvider,
      Provider<Context> contextProvider) {
    return new CommentViewModel_Factory(repositoryProvider, contextProvider);
  }

  public static CommentViewModel newInstance(HaloRepository repository, Context context) {
    return new CommentViewModel(repository, context);
  }
}
