package com.banguka.promoter.di.components;

import com.banguka.promoter.data.repository.AuthRepository;
import com.banguka.promoter.data.repository.UserRepository;
import com.banguka.promoter.di.scope.RepositoryScope;

import dagger.Subcomponent;

@RepositoryScope
@Subcomponent
public interface RepositoryComponent {

    void inject(AuthRepository repository);
    void inject(UserRepository repository);

}
